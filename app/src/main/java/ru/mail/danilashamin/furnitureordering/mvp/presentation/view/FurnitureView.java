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

public class FurnitureView extends AppCompatImageView {
    private Furniture furniture;

    private Bitmap bitmap;
    private Paint paint;

    public FurnitureView(Context context, Furniture furniture) {
        super(context);
        this.furniture = furniture;
        setTag(furniture.getId());
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
            case SINGLE_UNIT_MODULE:
                bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                break;
            case FOUR_UNIT_MODULE:
                bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                break;
            case EIGHT_UNIT_MODULE:
                bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                break;
            case PILLOW:
                bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                bringToFront();
                break;
        }
        setLayoutParams(furniture.getLayoutParams());

        bitmap = Bitmap.createScaledBitmap(bitmap, furniture.getLayoutParams().width, furniture.getLayoutParams().height, true);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        setColorFilterOnBitmap(getResources().getColor(R.color.first_color));
    }

    public void setColorFilterOnBitmap(int color) {
        paint.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
        invalidate();
    }


    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }

    public Furniture getFurniture() {
        return furniture;
    }

    public void setCurrent() {
        setBackground(getResources().getDrawable(R.drawable.current_furniture_border));
        invalidate();
    }

    public void unsetCurrent() {
        setBackground(null);
        invalidate();
    }
}
