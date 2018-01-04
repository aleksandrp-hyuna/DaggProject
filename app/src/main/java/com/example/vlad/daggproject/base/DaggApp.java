package com.example.vlad.daggproject.base;

import android.app.Application;
import android.support.annotation.NonNull;

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

    protected ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = initComponent();
        component.inject(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    protected ApplicationComponent initComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
