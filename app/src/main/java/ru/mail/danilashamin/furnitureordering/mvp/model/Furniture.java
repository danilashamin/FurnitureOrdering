package ru.mail.danilashamin.furnitureordering.mvp.model;

import android.view.WindowManager;
import android.widget.FrameLayout;

public class Furniture {
    private FurnitureType type;
    private int ID;
    private FrameLayout.LayoutParams layoutParams;

    public Furniture(FurnitureType type, int ID) {
        this.type = type;
        this.ID = ID;
        this.layoutParams = new FrameLayout.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        layoutParams.width = 100;
        layoutParams.height = 100;
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

    public FrameLayout.LayoutParams getLayoutParams() {
        return layoutParams;
    }
}
