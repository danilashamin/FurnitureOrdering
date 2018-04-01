package ru.mail.danilashamin.furnitureordering.mvp.presentation.view;

import android.graphics.drawable.Drawable;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import ru.mail.danilashamin.furnitureordering.mvp.model.Furniture;

public interface MainView extends MvpView {
    @StateStrategyType(AddToEndStrategy.class)
    void addFurnitureOnScreen(Furniture furniture);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setMattressCounter(Integer mattressCounter);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setPuffCounter(Integer puffCounter);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setCushionCounter(Integer cushionCounter);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setBackgroundPhoto(Drawable photo);

    @StateStrategyType(AddToEndStrategy.class)
    void deleteFurnitureView(Furniture furnitureForDelete);

    @StateStrategyType(AddToEndStrategy.class)
    void showColorPickerDialog();

    @StateStrategyType(AddToEndStrategy.class)
    void dismissColorPickerDialog();

    @StateStrategyType(AddToEndStrategy.class)
    void changeCurrentFurnitureColor(int color);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void startCamera();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void stopCamera();

    void deleteAllFurniture();
}
