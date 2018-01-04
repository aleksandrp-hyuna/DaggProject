package com.example.vlad.daggproject.base;

import android.support.test.InstrumentationRegistry;

/**
 * Created by Vladyslav on 04.01.2018
 */

public class TestApplication extends DaggApp {

    @Override
    protected ApplicationComponent initComponent() {
        return DaggerTestApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static TestApplicationComponent getComponent() {
        return (TestApplicationComponent)
                ((TestApplication) InstrumentationRegistry.getTargetContext().getApplicationContext()).component;
    }
}
