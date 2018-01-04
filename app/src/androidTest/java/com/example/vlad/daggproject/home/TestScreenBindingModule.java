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
 * Created by Vladyslav on 04.01.2018
 */

@Module(subcomponents = {
        TrendingReposComponent.class
})
public abstract class TestScreenBindingModule {

    @Binds
    @IntoMap
    @Controllerkey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTreningReposInjector(TrendingReposComponent.Builder builder);
}
