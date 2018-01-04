package com.example.vlad.daggproject.home;

import com.example.vlad.daggproject.di.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Vladyslav on 04.01.2018
 */

@ActivityScope
@Subcomponent(modules = {
    TestScreenBindingModule.class
})
public interface TestMainActivityComponent extends AndroidInjector<MainActivity>{

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }
}
