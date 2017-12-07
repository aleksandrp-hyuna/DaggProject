package com.example.vlad.daggproject.home;

import com.example.vlad.daggproject.di.ActivityScope;
import com.example.vlad.daggproject.ui.NavigationModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Vladyslav on 04.12.2017
 */

@ActivityScope
@Subcomponent(modules = {
        MainScreenBindingModule.class,
        NavigationModule.class
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

        @Override
        public void seedInstance(MainActivity activity) {

        }
    }
}
