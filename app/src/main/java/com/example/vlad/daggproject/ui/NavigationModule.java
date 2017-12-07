package com.example.vlad.daggproject.ui;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Vladyslav on 06.12.2017
 */

@Module
public abstract class NavigationModule {

    @Binds
    abstract ScreenNavigator provideScreenNavigator(DefaultScreenNavigator screenNavigator);
}
