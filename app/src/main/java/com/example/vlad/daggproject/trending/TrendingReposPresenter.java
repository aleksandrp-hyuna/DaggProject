package com.example.vlad.daggproject.trending;

import com.example.vlad.daggproject.data.RepoRequester;
import com.example.vlad.daggproject.di.ScreenScope;
import com.example.vlad.daggproject.model.Repo;

import javax.inject.Inject;

/**
 * Created by Vladyslav on 07.12.2017
 */

@ScreenScope
public class TrendingReposPresenter implements RepoAdapter.RepoClickedListener {

    private final TrendingReposViewModel viewModel;
    private final RepoRequester repoRequester;

    @Inject
    TrendingReposPresenter(TrendingReposViewModel viewModel, RepoRequester repoRequester) {
        this.viewModel = viewModel;
        this.repoRequester = repoRequester;
        loadRepo();
    }

    private void loadRepo() {
        repoRequester.getTrendingRepos()
                .doOnSubscribe(r -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.reposUpdated(), viewModel.onError());
    }

    @Override
    public void onRepoClicked(Repo repo) {

    }
}
