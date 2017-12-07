package com.example.vlad.daggproject.base;

import com.example.vlad.daggproject.data.RepoServiceModule;
import com.example.vlad.daggproject.networking.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Vladyslav on 04.12.2017
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        RepoServiceModule.class
})
public interface ApplicationComponent {
    void inject(DaggApp daggApp);
}
