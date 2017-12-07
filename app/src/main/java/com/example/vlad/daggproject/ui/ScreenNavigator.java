package com.example.vlad.daggproject.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

/**
 * Created by Vladyslav on 06.12.2017
 */

public interface ScreenNavigator {

    void initWithRouter(Router router, Controller controller);

    boolean pop();

    void clear();
}
