package com.example.vlad.daggproject.home;

import com.bluelinelabs.conductor.Controller;
import com.example.vlad.daggproject.R;
import com.example.vlad.daggproject.base.BaseActivity;
import com.example.vlad.daggproject.trending.TrendingReposController;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Controller initialScreen() {
        return new TrendingReposController();
    }
}
