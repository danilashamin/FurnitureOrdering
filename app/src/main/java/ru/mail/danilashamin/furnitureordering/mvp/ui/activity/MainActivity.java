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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.mail.danilashamin.furnitureordering.R;
import ru.mail.danilashamin.furnitureordering.mvp.model.Furniture;
import ru.mail.danilashamin.furnitureordering.mvp.model.FurnitureType;
import ru.mail.danilashamin.furnitureordering.mvp.presentation.presenter.MainPresenter;
import ru.mail.danilashamin.furnitureordering.mvp.presentation.view.FurnitureView;
import ru.mail.danilashamin.furnitureordering.mvp.presentation.view.MainView;

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
    public void showColorPickerDialog() {
    }

    @Override
    public void dismissColorPickerDialog() {

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
        mainPresenter.showColorPickerDialog();
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
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    if (containsView(v)) {
                        fieldForFurniture.removeView(v);
                    }
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    break;
                case MotionEvent.ACTION_MOVE:
                    FrameLayout.LayoutParams layoutParams = setLayoutParams(X, Y, v);
                    furniture.setLayoutParams(layoutParams);
                    v.setLayoutParams(layoutParams);
                    if (containsView(v)) {
                        ivTrashCan.setImageDrawable(getResources().getDrawable(R.drawable.ic_delete_forever_activated));
                    }
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

    public boolean containsView(View draggedView) {
        // Create the Rect for the view where items will be dropped
        int[] pointA = new int[2];
        ivTrashCan.getLocationOnScreen(pointA);
        Rect rectA = new Rect(pointA[0], pointA[1], pointA[0] + ivTrashCan.getWidth(), pointA[1] + ivTrashCan.getHeight());

        // Create the Rect for the view been dragged
        int[] pointB = new int[2];
        draggedView.getLocationOnScreen(pointB);
        Rect rectB = new Rect(pointB[0], pointB[1], pointB[0] + draggedView.getWidth(), pointB[1] + draggedView.getHeight());

        // Check if the dropzone currently contains the dragged view
        return rectA.contains(rectB);
    }
}
