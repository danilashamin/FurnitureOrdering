package ru.mail.danilashamin.furnitureordering.mvp.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import ru.mail.danilashamin.furnitureordering.mvp.model.FurnitureType;

public interface MainView extends MvpView {
    @StateStrategyType(AddToEndStrategy.class)
    void addFurnitureOnScreen(FurnitureType type);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setMattressCounter(Integer mattressCounter);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setPuffCounter(Integer puffCounter);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setCushionCounter(Integer cushionCounter);


}
