package com.udacity.gradle.builditbigger;

import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.annotation.VisibleForTesting;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import com.baris.jokedisplayer.JokeActivity;



public class MainActivityFragment extends Fragment
{
    private Unbinder unbinder;
    private boolean isTesting = false;
    private String jokes;

    @BindView(R.id.progressbar_loading) ProgressBar progressLoading;

    public MainActivityFragment() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @OnClick(R.id.joke_button)
    public void tellJoke() {
        showLoading();
        EndpointGetJokeAsyncTask getJokeAsyncTask = new EndpointGetJokeAsyncTask(new EndpointGetJokeAsyncTask.OnEventListener<String>() {
            @Override
            public void onSuccess(String joke) {
                hideLoading();
                onJokeRetrieved(joke);
            }
        });
        getJokeAsyncTask.execute();
    }

    private void onJokeRetrieved(String joke) {
        jokes = joke;
        if (!isTesting) {
            startJokeScreen();
        }
    }

    private void startJokeScreen() {
        startActivity(JokeActivity.jokeDisplayerIntent(getActivity(), jokes));
    }

    private void showLoading() {
        progressLoading.setVisibility(View.VISIBLE);
    }

    private void hideLoading() {
        progressLoading.setVisibility(View.GONE);
    }

    @VisibleForTesting
    public String getJoke() {
        return jokes;
    }

    @VisibleForTesting
    public void setJoke(String joke) {
        jokes = joke;
    }

    @VisibleForTesting
    public void setTesting() {
        isTesting = true;
    }
}
