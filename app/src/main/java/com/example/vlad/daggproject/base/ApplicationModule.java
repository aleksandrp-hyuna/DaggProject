package com.example.vlad.daggproject.base;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Vladyslav on 04.12.2017
 */

@Module
public class ApplicationModule {

    private final Application app;

    ApplicationModule(Application app) {
        this.app = app;
    }

    @Provides
    Context provideApplicationContext() {
        return app;
    }
}
