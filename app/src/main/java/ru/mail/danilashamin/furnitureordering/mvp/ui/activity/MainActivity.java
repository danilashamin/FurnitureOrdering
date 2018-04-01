package ru.mail.danilashamin.furnitureordering.mvp.ui.activity;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.mail.danilashamin.furnitureordering.R;
import ru.mail.danilashamin.furnitureordering.mvp.model.Furniture;
import ru.mail.danilashamin.furnitureordering.mvp.model.FurnitureType;
import ru.mail.danilashamin.furnitureordering.mvp.presentation.presenter.MainPresenter;
import ru.mail.danilashamin.furnitureordering.mvp.presentation.view.FurnitureView;
import ru.mail.danilashamin.furnitureordering.mvp.presentation.view.MainView;

import static ru.mail.danilashamin.furnitureordering.mvp.presentation.view.FurnitureView.FURNITURE_VIEW_TAG;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter mainPresenter;

    @BindView(R.id.fieldForFurniture)
    FrameLayout fieldForFurniture;
    @BindView(R.id.tvMattressCounter)
    TextView tvMattressCounter;
    @BindView(R.id.btnAddMattress)
    ImageView btnAddMattress;
    @BindView(R.id.tvPuffCounter)
    TextView tvPuffCounter;
    @BindView(R.id.btnAddPuff)
    ImageView btnAddPuff;
    @BindView(R.id.tvCushionCounter)
    TextView tvCushionCounter;
    @BindView(R.id.btnAddCushion)
    ImageView btnAddCushion;
    @BindView(R.id.btnBuy)
    Button btnBuy;
    @BindView(R.id.ivTrashCan)
    ImageView ivTrashCan;
    @BindView(R.id.tvPrice)
    TextView tvPrice;
    @BindView(R.id.btnColorPick)
    ImageView btnColorPick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void addFurnitureOnScreen(Furniture furniture) {
        FurnitureView furnitureView = new FurnitureView(this, furniture);
        furnitureView.setOnTouchListener(new OnFurnitureTouchListener(furniture));
        fieldForFurniture.addView(furnitureView);
    }

    @Override
    public void setMattressCounter(Integer mattressCounter) {
        tvMattressCounter.setText(String.valueOf(mattressCounter));
    }

    @Override
    public void setPuffCounter(Integer puffCounter) {
        tvPuffCounter.setText(String.valueOf(puffCounter));
    }

    @Override
    public void setCushionCounter(Integer cushionCounter) {
        tvCushionCounter.setText(String.valueOf(cushionCounter));
    }

    @Override
    public void setBackgroundPhoto(Drawable photo) {
        fieldForFurniture.setBackground(photo);
    }


    @Override
    public void deleteFurnitureView(Furniture furnitureForDelete) {
        fieldForFurniture.removeView(fieldForFurniture.findViewWithTag(String.format(Locale.getDefault(), "%s%d", FURNITURE_VIEW_TAG, furnitureForDelete.getID())));
        ivTrashCan.setImageDrawable(getResources().getDrawable(R.drawable.ic_delete_forever));
    }


    @OnClick(R.id.btnAddMattress)
    public void onBtnAddMattressClicked() {
        mainPresenter.addFurniture(FurnitureType.MATTRESS);
    }

    @OnClick(R.id.btnAddPuff)
    public void onBtnAddPuffClicked() {
        mainPresenter.addFurniture(FurnitureType.PUFF);
    }

    @OnClick(R.id.btnAddCushion)
    public void onBtnAddCushionClicked() {
        mainPresenter.addFurniture(FurnitureType.CUSHION);
    }

    @OnClick(R.id.btnBuy)
    public void onBtnBuyClicked() {
        mainPresenter.buy();
    }


    @OnClick(R.id.btnColorPick)
    public void onBtnColorPickClicked() {

    }


    public class OnFurnitureTouchListener implements View.OnTouchListener {
        private int _xDelta;
        private int _yDelta;
        private Furniture furniture;

        OnFurnitureTouchListener(Furniture furniture) {
            this.furniture = furniture;
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            final int X = (int) event.getRawX();
            final int Y = (int) event.getRawY();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:

                    FrameLayout.LayoutParams lParams = (FrameLayout.LayoutParams) v.getLayoutParams();
                    _xDelta = X - lParams.leftMargin;
                    _yDelta = Y - lParams.topMargin;

                    mainPresenter.setCurrentFurniture(((FurnitureView) v).getFurniture());
                    break;
                case MotionEvent.ACTION_UP:
                    if (doViewsIntersect(v, ivTrashCan)) {
                        mainPresenter.deleteFurniture(((FurnitureView) v).getFurniture());
                    }
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    break;
                case MotionEvent.ACTION_MOVE:
                    FrameLayout.LayoutParams layoutParams = setLayoutParams(X, Y, v);
                    furniture.setLayoutParams(layoutParams);
                    v.setLayoutParams(layoutParams);
                    changeTrashCanIcon(v);
                    break;
            }

            return true;
        }

        private FrameLayout.LayoutParams setLayoutParams(int X, int Y, View v) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) v.getLayoutParams();
            layoutParams.leftMargin = X - _xDelta;
            layoutParams.topMargin = Y - _yDelta;
            layoutParams.rightMargin = -250;
            layoutParams.bottomMargin = -250;
            return layoutParams;
        }
    }

    public void changeTrashCanIcon(View v) {
        if (doViewsIntersect(v, ivTrashCan)) {
            ivTrashCan.setImageDrawable(getResources().getDrawable(R.drawable.ic_delete_forever_activated));
        } else {
            ivTrashCan.setImageDrawable(getResources().getDrawable(R.drawable.ic_delete_forever));
        }
    }

    private boolean doViewsIntersect(View dropTarget, View item) {
        Rect dropRect = getScreenBounds(dropTarget);
        Rect itemRect = getScreenBounds(item);
        return Rect.intersects(dropRect, itemRect);
    }

    private Rect getScreenBounds(View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return new Rect(location[0], location[1], location[0] + view.getWidth(), location[1] + view.getHeight());
    }

}
