package com.example.vlad.daggproject.trending;

import com.example.vlad.daggproject.data.RepoRepository;
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
    private RepoRepository repoRepository;

    @Inject
    TrendingReposPresenter(TrendingReposViewModel viewModel, RepoRepository repoRepository) {
        this.viewModel = viewModel;
        this.repoRepository = repoRepository;
        loadRepo();
    }

    private void loadRepo() {
        repoRepository.getTrendingRepos()
                .doOnSubscribe(r -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.reposUpdated(), viewModel.onError());
    }

    @Override
    public void onRepoClicked(Repo repo) {

    }
}
