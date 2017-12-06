package com.example.vlad.daggproject.di;

import com.bluelinelabs.conductor.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import dagger.MapKey;

/**
 * Created by Vladyslav on 05.12.2017
 */


@MapKey
@Target(ElementType.METHOD)
public @interface Controllerkey {
    Class<? extends Controller> value();
}
