package ru.mail.danilashamin.furnitureordering.mvp.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.mail.danilashamin.furnitureordering.mvp.model.FurnitureType;
import ru.mail.danilashamin.furnitureordering.mvp.presentation.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Integer mattressCounter = 0, puffCounter = 0, cushionCounter = 0;

    public MainPresenter() {

    }


    public void addFurniture(FurnitureType type) {
        switch (type) {
            case MATTRESS:
                getViewState().setMattressCounter(++mattressCounter);
                break;
            case CUSHION:
                getViewState().setCushionCounter(++cushionCounter);
                break;
            case PUFF:
                getViewState().setPuffCounter(++puffCounter);
                break;
        }
        getViewState().addFurnitureOnScreen(type);
    }


    public void buy() {

    }
}
