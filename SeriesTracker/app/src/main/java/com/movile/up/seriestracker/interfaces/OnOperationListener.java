package com.movile.up.seriestracker.interfaces;

import com.movile.up.seriestracker.model.Episode;

public interface OnOperationListener<T> {
    public void onOperationSuccess(T type);
}
