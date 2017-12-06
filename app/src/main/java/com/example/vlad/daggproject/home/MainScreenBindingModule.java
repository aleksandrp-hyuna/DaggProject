package com.example.vlad.daggproject.home;

import com.bluelinelabs.conductor.Controller;
import com.example.vlad.daggproject.di.Controllerkey;
import com.example.vlad.daggproject.trending.TrendingReposComponent;
import com.example.vlad.daggproject.trending.TrendingReposController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by Vladyslav on 05.12.2017
 */

@Module(subcomponents = {
        TrendingReposComponent.class,
})
public abstract class MainScreenBindingModule {
    @Binds
    @IntoMap
    @Controllerkey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);
}
