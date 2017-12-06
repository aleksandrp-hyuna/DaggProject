package com.example.vlad.daggproject.base;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.example.vlad.daggproject.di.Injector;

/**
 * Created by Vladyslav on 05.12.2017
 */

public abstract class BaseController extends Controller {

    private boolean injected = false;

    @Override
    protected void onContextAvailable(@NonNull Context context) {
        //Controller instances are retained across config changes, so this method can be called more than once. This makes
        //sure we don't waste any time injecting more than once, though technically it wouldn't change functionality.
        if (!injected) {
            Injector.inject(this);
            injected = true;
        }
        super.onContextAvailable(context);
    }
}
