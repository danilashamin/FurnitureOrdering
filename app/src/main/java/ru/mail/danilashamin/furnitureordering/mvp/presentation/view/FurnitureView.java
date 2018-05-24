package ru.mail.danilashamin.furnitureordering.mvp.presentation.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
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

    List<Integer> listOfPicturesResourcesIds;

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
        listOfPicturesResourcesIds = new ArrayList<>();
        indexOfCurrentPicture = 0;
        switch (furniture.getType()) {
            case SINGLE_UNIT_MODULE:
                listOfPicturesResourcesIds.add(R.drawable.single_first);
                //listOfPicturesResourcesIds.add(R.drawable.single_second);
                listOfPicturesResourcesIds.add(R.drawable.single_third);
                //listOfPicturesResourcesIds.add(R.drawable.single_fourth);
                break;
            case DOUBLE_UNIT_MODULE:
                listOfPicturesResourcesIds.add(R.drawable.double_first);
                //listOfPicturesResourcesIds.add(R.drawable.double_second);
                listOfPicturesResourcesIds.add(R.drawable.double_third);
               // listOfPicturesResourcesIds.add(R.drawable.double_fourth);
                break;
            case TRIPLE_UNIT_MODULE:
                listOfPicturesResourcesIds.add(R.drawable.triple_first);
                //listOfPicturesResourcesIds.add(R.drawable.triple_second);
                listOfPicturesResourcesIds.add(R.drawable.triple_third);
                //listOfPicturesResourcesIds.add(R.drawable.triple_fourth);
                break;
            case FOURTH_MODULE_UNIT:
                listOfPicturesResourcesIds.add(R.drawable.fourth_first);
               //listOfPicturesResourcesIds.add(R.drawable.fourth_second);
                listOfPicturesResourcesIds.add(R.drawable.fourth_third);
                //listOfPicturesResourcesIds.add(R.drawable.fourth_fourth);
                bringToFront();
                break;
        }
        setLayoutParams(furniture.getLayoutParams());

        currentFurniturePicture = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(getResources(), listOfPicturesResourcesIds.get(0)),
                furniture.getLayoutParams().width, furniture.getLayoutParams().height, true);
        furniturePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        fitoPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        // setColorFilterOnBitmap(getResources().getColor(R.color.first_color));
    }

    public void setColorFilterOnBitmap(int color) {
        if (color == getResources().getColor(R.color.first_color)) {
            furniturePaint.setColorFilter(null);
        } else {
            furniturePaint.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
        }
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
        if (indexOfCurrentPicture == listOfPicturesResourcesIds.size() - 1) {
            indexOfCurrentPicture = 0;
            setCurrentFurniturePicture(indexOfCurrentPicture);
        } else {
            indexOfCurrentPicture++;
            setCurrentFurniturePicture(indexOfCurrentPicture);
        }
    }

    private void setCurrentFurniturePicture(int index) {
        currentFurniturePicture = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(getResources(), listOfPicturesResourcesIds.get(index)),
                furniture.getLayoutParams().width, furniture.getLayoutParams().height, true);
        invalidate();
    }
}
