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

import java.util.ArrayList;
import java.util.List;

import ru.mail.danilashamin.furnitureordering.R;
import ru.mail.danilashamin.furnitureordering.mvp.model.Furniture;

public class FurnitureView extends AppCompatImageView {
    private Furniture furniture;

    private Bitmap currentFurniturePicture;
    private Bitmap fitoBitmap;

    private Paint furniturePaint;
    private Paint fitoPaint;

    List<Bitmap> listOfPictures;

    int indexOfCurrentPicture;

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
        listOfPictures = new ArrayList<>();
        indexOfCurrentPicture = 0;
        switch (furniture.getType()) {
            case SINGLE_UNIT_MODULE:
                currentFurniturePicture = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                listOfPictures.add(currentFurniturePicture);
                listOfPictures.add(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sofa), 100, 100, true));
                break;
            case FOUR_UNIT_MODULE:
                currentFurniturePicture = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                listOfPictures.add(currentFurniturePicture);
                break;
            case EIGHT_UNIT_MODULE:
                currentFurniturePicture = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                listOfPictures.add(currentFurniturePicture);
                break;
            case PILLOW:
                currentFurniturePicture = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                listOfPictures.add(currentFurniturePicture);
                bringToFront();
                break;
        }
        setLayoutParams(furniture.getLayoutParams());

        currentFurniturePicture = Bitmap.createScaledBitmap(currentFurniturePicture, furniture.getLayoutParams().width, furniture.getLayoutParams().height, true);
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
            fitoBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ic_grass_picked), currentFurniturePicture.getWidth() / 5, currentFurniturePicture.getHeight() / 5, true);
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
        canvas.drawBitmap(currentFurniturePicture, 0, 0, furniturePaint);
        if (fitoBitmap == null) {
            return;
        }
        canvas.drawBitmap(fitoBitmap, currentFurniturePicture.getWidth() - fitoBitmap.getWidth(), currentFurniturePicture.getHeight() - fitoBitmap.getHeight(), fitoPaint);
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

    public void changePicture() {
        if (indexOfCurrentPicture == listOfPictures.size() - 1) {
            indexOfCurrentPicture = 0;
            setCurrentFurniturePicture(indexOfCurrentPicture);
        } else {
            indexOfCurrentPicture++;
            setCurrentFurniturePicture(indexOfCurrentPicture);
        }
    }

    private void setCurrentFurniturePicture(int index) {
        currentFurniturePicture = listOfPictures.get(index);
        invalidate();
    }
}
