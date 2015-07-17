package com.movile.up.seriestracker.presenter;

import android.content.Context;
import android.util.Log;

import com.movile.up.seriestracker.interfaces.EpisodeDetailsView;
import com.movile.up.seriestracker.interfaces.OnEpisodeDetailsListener;
import com.movile.up.seriestracker.model.Episode;
import com.movile.up.seriestracker.retrofit.FetchLocalEpisodeDetailsRetrofit;

public class EpisodeDetailsPresenter implements OnEpisodeDetailsListener<Episode> {
    private EpisodeDetailsView mView;
    private Context mContext;

    public EpisodeDetailsPresenter (Context context, EpisodeDetailsView view) {
        mContext = context;
        mView = view;
    }

    public void loadRemoteEpisodeWithRetrofit() {
        new FetchLocalEpisodeDetailsRetrofit(mContext, this).loadEpisode("house-of-cards", 2l, 7l);
    }

    public void onEpisodeDetailsSuccess(Episode episode) {
        mView.displayEpisode(episode);
    }
}