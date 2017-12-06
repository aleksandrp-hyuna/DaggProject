package com.example.vlad.daggproject.di;

import android.app.Activity;
import android.content.Context;

import com.example.vlad.daggproject.base.BaseActivity;
import com.example.vlad.daggproject.base.DaggApp;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjector;
import dagger.android.AndroidInjector.Factory;

/**
 * Created by Vladyslav on 04.12.2017
 */

public class ActivityInjector {

    private final String notBaseActivityMessage = "Activity must extend BaseActivity";
    private final Map<Class<? extends Activity>, Provider<Factory<? extends Activity>>> activityInjectors;
    private final Map<String, AndroidInjector<? extends Activity>> cache = new HashMap<>();

    @Inject
    ActivityInjector(Map<Class<? extends Activity>, Provider<Factory<? extends Activity>>> activityInjectors) {
        this.activityInjectors = activityInjectors;
    }

    void inject(Activity activity) {
        if (!(activity instanceof BaseActivity)) {
            throw new IllegalArgumentException(notBaseActivityMessage);
        }

        String instanceId = ((BaseActivity) activity).getInstanceId();
        if (cache.containsKey(instanceId)) {
            //noinspection unchecked
            ((AndroidInjector<Activity>) cache.get(instanceId)).inject(activity);
            return;
        }

        //noinspection unchecked
        Factory<Activity> injectorFactory = (Factory<Activity>) activityInjectors.get(activity.getClass()).get();
        AndroidInjector<Activity> injector = injectorFactory.create(activity);
        cache.put(instanceId, injector);
        injector.inject(activity);
    }

    void clear(Activity activity) {
        if (!(activity instanceof BaseActivity)) {
            throw new IllegalArgumentException(notBaseActivityMessage);
        }
        cache.remove(((BaseActivity) activity).getInstanceId());
    }

    static ActivityInjector get(Context context) {
        return ((DaggApp) context.getApplicationContext()).getActivityInjector();
    }
}
