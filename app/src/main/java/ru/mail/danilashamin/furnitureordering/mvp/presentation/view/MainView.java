package ru.mail.danilashamin.furnitureordering.mvp.presentation.view;

import android.view.MotionEvent;
import android.view.View;

import com.arellomobile.mvp.MvpView;

public interface MainView extends MvpView {
    void dragView(View dragView, MotionEvent event);

}
