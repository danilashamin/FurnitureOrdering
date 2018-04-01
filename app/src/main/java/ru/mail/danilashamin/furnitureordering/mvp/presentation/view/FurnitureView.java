package ru.mail.danilashamin.furnitureordering.mvp.presentation.view;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.WindowManager;

import java.util.Locale;

import ru.mail.danilashamin.furnitureordering.R;
import ru.mail.danilashamin.furnitureordering.mvp.model.Furniture;
import ru.mail.danilashamin.furnitureordering.mvp.model.OnFurnitureDragListener;

public class FurnitureView extends AppCompatImageView {
    private Furniture furniture;
    private static final String FURNITURE_VIEW_TAG = "FURNITURE_VIEW_";

    public FurnitureView(Context context, Furniture furniture) {
        super(context);
        this.furniture = furniture;
        setTag(String.format(Locale.getDefault(), "%s%d", FURNITURE_VIEW_TAG, furniture.getID()));
        init();
    }

    public FurnitureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FurnitureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        switch (furniture.getType()) {
            case PUFF:
                setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
                break;
            case CUSHION:
                setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
                break;
            case MATTRESS:
                setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
                break;
        }
        setLayoutParams(furniture.getLayoutParams());
        setOnTouchListener(new OnFurnitureDragListener(furniture));
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }
}
