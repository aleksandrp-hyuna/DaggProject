package com.example.vlad.daggproject.base;

import android.app.Activity;

import com.example.vlad.daggproject.home.MainActivity;
import com.example.vlad.daggproject.home.TestMainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by Vladyslav on 04.01.2018
 */

@Module(subcomponents = TestMainActivityComponent.class)
public abstract class TestActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjector(TestMainActivityComponent.Builder builder);
}
