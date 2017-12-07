package com.example.vlad.daggproject.base;

import android.app.Application;

import com.example.vlad.daggproject.di.ActivityInjector;

import javax.inject.Inject;

import timber.log.BuildConfig;
import timber.log.Timber;

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

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
