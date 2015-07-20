package com.movile.up.seriestracker.presenter;

import android.content.Context;

import com.movile.up.seriestracker.interfaces.OnSeasonDetailsListener;
import com.movile.up.seriestracker.interfaces.SeasonDetailsView;
import com.movile.up.seriestracker.model.Episode;
import com.movile.up.seriestracker.retrofit.FetchLocalSeasonDetailsRetrofit;

import java.util.List;

public class SeasonDetailsPresenter implements OnSeasonDetailsListener<Episode> {
    private SeasonDetailsView mView;
    private Context mContext;

    public SeasonDetailsPresenter(Context context, SeasonDetailsView view) {
        mContext = context;
        mView = view;
    }

    public void loadRemoteEpisodesWithRetrofit() {
        new FetchLocalSeasonDetailsRetrofit(mContext, this).loadEpisodes("house-of-cards", 2l);
    }

    public void OnSeasonDetailsSuccess(List<Episode> episodes) {
        mView.displayEpisodes(episodes);
    }
}