package ru.mail.danilashamin.furnitureordering.mvp.presentation.view;

import android.graphics.drawable.Drawable;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import ru.mail.danilashamin.furnitureordering.mvp.model.Furniture;
import ru.mail.danilashamin.furnitureordering.mvp.model.ZodiacSign;

public interface MainView extends MvpView {
    @StateStrategyType(AddToEndStrategy.class)
    void addFurnitureOnScreen(Furniture furniture);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setSingleUnitModuleCounter(Integer singleUnitModuleCounter);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setFourUnitModuleCounter(Integer fourUnitModuleCounter);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setEightUnitModuleCounter(Integer eightUnitModuleCounter);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setPillowCounter(Integer pillowCounter);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setBackgroundPhoto(Drawable photo);

    @StateStrategyType(AddToEndStrategy.class)
    void deleteFurnitureView(Furniture furnitureForDelete);

    @StateStrategyType(AddToEndStrategy.class)
    void showColorPickerDialog();

    @StateStrategyType(AddToEndStrategy.class)
    void dismissColorPickerDialog();

    @StateStrategyType(AddToEndStrategy.class)
    void showFitoPickerDialog(ZodiacSign currentFurnitureZodiacSign);

    @StateStrategyType(AddToEndStrategy.class)
    void dismissFitoPickerDialog();

    @StateStrategyType(AddToEndStrategy.class)
    void showPhoneNumberDialog();

    @StateStrategyType(AddToEndStrategy.class)
    void dismissPhoneNumberDialog();

    @StateStrategyType(AddToEndStrategy.class)
    void changeCurrentFurnitureColor(int color, Furniture currentFurniture);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void startCamera();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void stopCamera();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void deleteAllFurniture();

    @StateStrategyType(AddToEndStrategy.class)
    void setCurrentFurniture(Furniture currentFurniture);

    @StateStrategyType(AddToEndStrategy.class)
    void unsetCurrentFurniture(Furniture currentFurniture);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setPrice(double price);

    @StateStrategyType(SkipStrategy.class)
    void buy(String order);


    @StateStrategyType(AddToEndStrategy.class)
    void changeFitoOnCurrentFurnitureView(Furniture currentFurniture, boolean selected);

    @StateStrategyType(SkipStrategy.class)
    void showEmptyOrderMessage();
}
