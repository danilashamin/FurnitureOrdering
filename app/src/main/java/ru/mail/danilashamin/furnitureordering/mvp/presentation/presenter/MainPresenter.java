package ru.mail.danilashamin.furnitureordering.mvp.presentation.presenter;

import android.graphics.drawable.Drawable;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.mail.danilashamin.furnitureordering.mvp.model.Furniture;
import ru.mail.danilashamin.furnitureordering.mvp.model.FurnitureType;
import ru.mail.danilashamin.furnitureordering.mvp.presentation.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Integer mattressCounter = 0, puffCounter = 0, cushionCounter = 0;
    private Double totalValue = (double) 0;

    private int furnitureCounter;
    private Furniture currentFurniture;

    public MainPresenter() {
        furnitureCounter = 0;
    }


    public void addFurniture(FurnitureType type) {
        Furniture furniture = new Furniture(type, ++furnitureCounter);
        totalValue += furniture.getPrice();
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
        getViewState().setPrice(totalValue);
        getViewState().addFurnitureOnScreen(furniture);
    }

    public void setBackgroundPhoto(Drawable backgroundPhoto) {
        getViewState().setBackgroundPhoto(backgroundPhoto);
    }

    public void startCamera() {
        getViewState().startCamera();
    }

    public void stopCamera() {
        getViewState().stopCamera();
    }

    public void setCurrentFurniture(Furniture currentFurniture) {
        unsetCurrentFurniture();
        this.currentFurniture = currentFurniture;
        getViewState().setCurrentFurniture(currentFurniture);
    }

    public void unsetCurrentFurniture() {
        if (currentFurniture == null) {
            return;
        }
        getViewState().unsetCurrentFurniture(currentFurniture);
    }

    public void deleteFurniture(Furniture furnitureForDelete) {
        totalValue -= furnitureForDelete.getPrice();
        switch (furnitureForDelete.getType()) {
            case MATTRESS:
                getViewState().setMattressCounter(--mattressCounter);
                break;
            case CUSHION:
                getViewState().setCushionCounter(--cushionCounter);
                break;
            case PUFF:
                getViewState().setPuffCounter(--puffCounter);
                break;
        }
        getViewState().setPrice(totalValue);
        getViewState().deleteFurnitureView(furnitureForDelete);
    }

    public void changeCurrentFurnitureColor(int color) {
        getViewState().changeCurrentFurnitureColor(color, currentFurniture);
    }


    public void deleteAllFurniture() {
        mattressCounter = 0;
        cushionCounter = 0;
        puffCounter = 0;
        totalValue = (double) 0;
        getViewState().setMattressCounter(mattressCounter);
        getViewState().setCushionCounter(cushionCounter);
        getViewState().setPuffCounter(puffCounter);
        getViewState().setPrice(totalValue);
        getViewState().deleteAllFurniture();
    }

    public void showColorPickerDialog() {
        getViewState().showColorPickerDialog();
    }

    public void dismissColorPickerDialog() {
        getViewState().dismissColorPickerDialog();
    }

    public void buy() {

    }
}
