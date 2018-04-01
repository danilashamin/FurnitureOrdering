package ru.mail.danilashamin.furnitureordering.mvp.presentation.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import java.util.Locale;

import ru.mail.danilashamin.furnitureordering.R;
import ru.mail.danilashamin.furnitureordering.mvp.model.Furniture;
import ru.mail.danilashamin.furnitureordering.mvp.model.OnFurnitureTouchListener;

public class FurnitureView extends AppCompatImageView {
    private Furniture furniture;
    private static final String FURNITURE_VIEW_TAG = "FURNITURE_VIEW_";

    private Bitmap bitmap;
    private Paint paint;

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
                bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                break;
            case CUSHION:
                bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                bringToFront();
                break;
            case MATTRESS:
                bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                break;
        }
        setLayoutParams(furniture.getLayoutParams());

        bitmap = Bitmap.createScaledBitmap(bitmap, furniture.getLayoutParams().width, furniture.getLayoutParams().height, true);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColorFilter(new PorterDuffColorFilter(getResources().getColor(R.color.fourth_color), PorterDuff.Mode.MULTIPLY));
        setOnTouchListener(new OnFurnitureTouchListener(furniture));
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }
}
