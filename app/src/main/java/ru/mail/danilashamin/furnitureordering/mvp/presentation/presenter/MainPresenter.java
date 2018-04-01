package ru.mail.danilashamin.furnitureordering.mvp.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import ru.mail.danilashamin.furnitureordering.mvp.model.Furniture;
import ru.mail.danilashamin.furnitureordering.mvp.model.FurnitureType;
import ru.mail.danilashamin.furnitureordering.mvp.presentation.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Integer mattressCounter = 0, puffCounter = 0, cushionCounter = 0;

    private List<Furniture> furnitures;

    public MainPresenter() {
        furnitures = new ArrayList<>();
    }


    public void addFurniture(FurnitureType type) {
        furnitures.add(new Furniture(type, furnitures.size()));

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
        getViewState().addFurnitureOnScreen(furnitures.get(furnitures.size() - 1));
    }


    public void buy() {

    }
}
