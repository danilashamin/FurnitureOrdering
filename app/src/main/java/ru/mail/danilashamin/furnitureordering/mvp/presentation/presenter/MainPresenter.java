package ru.mail.danilashamin.furnitureordering.mvp.presentation.presenter;

import android.graphics.drawable.Drawable;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import ru.mail.danilashamin.furnitureordering.mvp.model.Furniture;
import ru.mail.danilashamin.furnitureordering.mvp.model.FurnitureType;
import ru.mail.danilashamin.furnitureordering.mvp.presentation.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Integer singleUnitModuleCounter = 0, eightUnitModuleCounter = 0, fourUnitModuleCounter = 0, pillowCounter = 0;
    private Double totalValue = (double) 0;
    private List<Furniture> furnitureList;
    private int furnitureCounter;
    private Furniture currentFurniture;

    public MainPresenter() {
        furnitureCounter = 0;
        furnitureList = new ArrayList<>();
    }


    public void addFurniture(FurnitureType type) {
        Furniture furniture = new Furniture(type, ++furnitureCounter);
        totalValue += furniture.getPrice();
        switch (type) {
            case SINGLE_UNIT_MODULE:
                getViewState().setSingleUnitModuleCounter(++singleUnitModuleCounter);
                break;
            case FOUR_UNIT_MODULE:
                getViewState().setFourUnitModuleCounter(++fourUnitModuleCounter);
                break;
            case EIGHT_UNIT_MODULE:
                getViewState().setEightUnitModuleCounter(++eightUnitModuleCounter);
                break;
            case PILLOW:
                getViewState().setPillowCounter(++pillowCounter);
                break;

        }
        getViewState().setPrice(totalValue);
        getViewState().addFurnitureOnScreen(furniture);
        furnitureList.add(furniture);
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
            case SINGLE_UNIT_MODULE:
                getViewState().setSingleUnitModuleCounter(--singleUnitModuleCounter);
                break;
            case FOUR_UNIT_MODULE:
                getViewState().setFourUnitModuleCounter(--fourUnitModuleCounter);
                break;
            case EIGHT_UNIT_MODULE:
                getViewState().setEightUnitModuleCounter(--eightUnitModuleCounter);
                break;
            case PILLOW:
                getViewState().setPillowCounter(--pillowCounter);
                break;
        }
        getViewState().setPrice(totalValue);
        getViewState().deleteFurnitureView(furnitureForDelete);
        furnitureList.remove(furnitureForDelete);
    }

    public void changeCurrentFurnitureColor(int color, String article) {
        if (currentFurniture != null) {
            currentFurniture.setArticle(article);
        }
        getViewState().changeCurrentFurnitureColor(color, currentFurniture);
    }


    public void deleteAllFurniture() {
        singleUnitModuleCounter = 0;
        pillowCounter = 0;
        fourUnitModuleCounter = 0;
        eightUnitModuleCounter = 0;
        totalValue = (double) 0;
        getViewState().setSingleUnitModuleCounter(singleUnitModuleCounter);
        getViewState().setPillowCounter(pillowCounter);
        getViewState().setFourUnitModuleCounter(fourUnitModuleCounter);
        getViewState().setEightUnitModuleCounter(eightUnitModuleCounter);
        getViewState().setPrice(totalValue);
        getViewState().deleteAllFurniture();
    }

    public void showColorPickerDialog() {
        getViewState().showColorPickerDialog();
    }

    public void dismissColorPickerDialog() {
        getViewState().dismissColorPickerDialog();
    }

    public void selectFito() {

    }

    public void buy() {

    }
}
