package com.example.vlad.daggproject.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.example.vlad.daggproject.di.ActivityScope;

import javax.inject.Inject;

/**
 * Created by Vladyslav on 06.12.2017
 */

@ActivityScope
public class DefaultScreenNavigator implements ScreenNavigator {

    private Router router;

    @Inject
    DefaultScreenNavigator() {

    }

    @Override
    public void initWithRouter(Router router, Controller rootScrean) {
        this.router = router;
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(rootScrean));
        }
    }

    @Override
    public boolean pop() {
        return router != null && router.handleBack();
    }

    @Override
    public void clear() {
        router = null;
    }
}
