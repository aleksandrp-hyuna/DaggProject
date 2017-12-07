package com.example.vlad.daggproject.data;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Vladyslav on 06.12.2017
 */

public interface RepoService {

    @GET("search/repositories?q=language:java&order=desc&sort=stars")
    Single<TrendingReposResponse> getTrendRepos();
}
