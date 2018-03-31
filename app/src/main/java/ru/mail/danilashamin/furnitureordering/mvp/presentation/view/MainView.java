package ru.mail.danilashamin.furnitureordering.mvp.presentation.view;

import android.view.MotionEvent;
import android.view.View;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import ru.mail.danilashamin.furnitureordering.mvp.model.FurnitureType;

public interface MainView extends MvpView {
    @StateStrategyType(AddToEndStrategy.class)
    void addFurnitureOnScreen(FurnitureType type);

    void dragView(View dragView, MotionEvent event);

}
