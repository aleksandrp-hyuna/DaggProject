package com.example.vlad.daggproject.data;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Vladyslav on 04.01.2018
 */

@Module
public abstract class TestRepoServiceModule {

    @Binds
    abstract RepoService bindRepoService(TestRepoService repoService);
}
