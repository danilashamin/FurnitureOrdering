package ru.mail.danilashamin.furnitureordering.mvp.presentation.presenter;

import android.view.MotionEvent;
import android.view.View;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.mail.danilashamin.furnitureordering.mvp.model.FurnitureType;
import ru.mail.danilashamin.furnitureordering.mvp.presentation.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    public MainPresenter() {

    }

    public void dragView(View view, MotionEvent event) {

    }

    public void addFurniture(FurnitureType type) {
        getViewState().addFurnitureOnScreen(type);
    }


    public void buy() {

    }
}
