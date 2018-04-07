package ru.mail.danilashamin.furnitureordering.mvp.model;

import android.view.WindowManager;
import android.widget.FrameLayout;

public class Furniture {
    private FurnitureType type;
    private int ID;
    private Double price;

    private FrameLayout.LayoutParams layoutParams;

    public Furniture(FurnitureType type, int ID) {
        this.type = type;
        this.ID = ID;
        this.layoutParams = new FrameLayout.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        layoutParams.width = 100;
        layoutParams.height = 100;
        setPrice();
    }

    private void setPrice() {
        switch (type) {
            case FOUR_UNIT_MODULE:
                price = (double) 10;
                break;
            case PILLOW:
                price = (double) 10;
                break;
            case SINGLE_UNIT_MODULE:
                price = (double) 10;
                break;
        }
    }

    public FurnitureType getType() {
        return type;
    }

    public int getID() {
        return ID;
    }

    public void setLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.layoutParams = layoutParams;
    }

    public Double getPrice() {
        return price;
    }

    public FrameLayout.LayoutParams getLayoutParams() {
        return layoutParams;
    }


}
