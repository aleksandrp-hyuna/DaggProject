package com.example.vlad.daggproject.base;

import com.example.vlad.daggproject.data.TestRepoServiceModule;
import com.example.vlad.daggproject.networking.ServiceModule;
import com.example.vlad.daggproject.trending.TrendingReposControllerTest;
import com.example.vlad.daggproject.ui.NavigationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Vladyslav on 04.01.2018
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        TestActivityBindingModule.class,
        TestRepoServiceModule.class,
        ServiceModule.class,
        NavigationModule.class
})
public interface TestApplicationComponent extends ApplicationComponent {

    void inject(TrendingReposControllerTest trendingReposControllerTest);
}
