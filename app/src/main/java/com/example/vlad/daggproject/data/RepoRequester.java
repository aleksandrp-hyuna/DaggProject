package com.example.vlad.daggproject.data;

import com.example.vlad.daggproject.model.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Vladyslav on 06.12.2017
 */

public class RepoRequester {

    private final RepoService service;

    @Inject
    RepoRequester(RepoService service) {
        this.service = service;
    }

    public Single<List<Repo>> getTrendingRepos() {
        return service.getTrendRepos()
                .map(TrendingReposResponse::repos)
                .subscribeOn(Schedulers.io());
    }
}
