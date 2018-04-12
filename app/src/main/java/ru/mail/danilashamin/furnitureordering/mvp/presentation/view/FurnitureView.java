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

import ru.mail.danilashamin.furnitureordering.R;
import ru.mail.danilashamin.furnitureordering.mvp.model.Furniture;

public class FurnitureView extends AppCompatImageView {
    private Furniture furniture;

    private Bitmap furniturePicture;
    private Bitmap fitoBitmap;

    private Paint furniturePaint;
    private Paint fitoPaint;

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
                furniturePicture = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                break;
            case FOUR_UNIT_MODULE:
                furniturePicture = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                break;
            case EIGHT_UNIT_MODULE:
                furniturePicture = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                break;
            case PILLOW:
                furniturePicture = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                bringToFront();
                break;
        }
        setLayoutParams(furniture.getLayoutParams());

        furniturePicture = Bitmap.createScaledBitmap(furniturePicture, furniture.getLayoutParams().width, furniture.getLayoutParams().height, true);
        furniturePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        fitoPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        setColorFilterOnBitmap(getResources().getColor(R.color.first_color));
    }

    public void setColorFilterOnBitmap(int color) {
        furniturePaint.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
        invalidate();
    }

    public void setFitoSelected(boolean selected) {
        if (selected) {
            fitoBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ic_grass_picked), furniturePicture.getWidth() / 5, furniturePicture.getHeight() / 5, true);
        } else {
            fitoBitmap = null;
        }
        invalidate();
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(furniturePicture, 0, 0, furniturePaint);
        if (fitoBitmap == null) {
            return;
        }
        canvas.drawBitmap(fitoBitmap, furniturePicture.getWidth() - fitoBitmap.getWidth(), furniturePicture.getHeight() - fitoBitmap.getHeight(), fitoPaint);
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
