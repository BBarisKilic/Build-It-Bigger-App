package com.udacity.gradle.builditbigger;

import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.baris.jokedisplayer.JokeActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivityFragment extends Fragment {

    private Unbinder unbinder;
    private boolean isTesting = false;
    private String jokes;
    private InterstitialAd interstitialAd;

    @BindView(R.id.adView) AdView adView;
    @BindView(R.id.progressbar_loading) ProgressBar progressLoading;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        MobileAds.initialize(getActivity(), "<<<<<PUT YOUR ADMOB_APP_ID HERE>>>>>");

        unbinder = ButterKnife.bind(this, root);

        interstitialAd = new InterstitialAd(getActivity());
        interstitialAd.setAdUnitId(getString(R.string.intersticial_ad_id));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                startJokeScreen();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        interstitialAd.loadAd(adRequest);
        adView.loadAd(adRequest);
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
            if (interstitialAd.isLoaded()) {
                interstitialAd.show();
            }
        }
    }

    private void showLoading() {
        progressLoading.setVisibility(View.VISIBLE);
    }

    private void hideLoading() {
        progressLoading.setVisibility(View.GONE);
    }

    private void startJokeScreen() {
        startActivity(JokeActivity.jokeDisplayerIntent(getActivity(), jokes));
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
