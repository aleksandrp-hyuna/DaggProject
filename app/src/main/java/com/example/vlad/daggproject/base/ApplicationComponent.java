package com.example.vlad.daggproject.base;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Vladyslav on 04.12.2017
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class
})
public interface ApplicationComponent {
    void inject(DaggApp daggApp);
}
