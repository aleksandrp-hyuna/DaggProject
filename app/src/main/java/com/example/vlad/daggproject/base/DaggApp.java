package com.example.vlad.daggproject.base;

import android.app.Application;

import com.example.vlad.daggproject.di.ActivityInjector;

import javax.inject.Inject;

/**
 * Created by Vladyslav on 04.12.2017
 */

public class DaggApp extends Application {


    @Inject
    ActivityInjector activityInjector;

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.inject(this);
    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
