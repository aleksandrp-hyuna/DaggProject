package com.example.vlad.daggproject.di;

import android.app.Activity;

import com.bluelinelabs.conductor.Controller;
import com.example.vlad.daggproject.base.BaseActivity;
import com.example.vlad.daggproject.base.BaseController;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjector;
import dagger.android.AndroidInjector.Factory;

/**
 * Created by Vladyslav on 05.12.2017
 */

@ActivityScope
public class ScreenInjector {

    private Map<Class<? extends Controller>, Provider<Factory<? extends Controller>>> screenInjectors;
    private final Map<String, AndroidInjector<Controller>> cache = new HashMap<>();

    @Inject
    ScreenInjector(Map<Class<? extends Controller>, Provider<Factory<? extends Controller>>> screenInjectors) {
        this.screenInjectors = screenInjectors;
    }

    void inject(Controller controller) {
        if (!(controller instanceof BaseController)) {
            String notBaseControllerMessage = "Controller must extend BaseController";
            throw new IllegalArgumentException(notBaseControllerMessage);
        }

        String instanceId = controller.getInstanceId();
        if (cache.containsKey(instanceId)) {
            cache.get(instanceId).inject(controller);
            return;
        }
        //noinspection unchecked
        Factory<Controller> injectorFactory = (Factory<Controller>) screenInjectors.get(controller.getClass()).get();
        AndroidInjector<Controller> injector = injectorFactory.create(controller);
        cache.put(instanceId, injector);
        injector.inject(controller);
    }

    void clear(Controller controller) {
        cache.remove(controller.getInstanceId());
    }

    static ScreenInjector get(Activity activity) {
        if (!(activity instanceof BaseActivity)) {
            throw new IllegalArgumentException("Activity must extends from BaseActivity");
        }
        return ((BaseActivity) activity).getScreenInjector();
    }
}

