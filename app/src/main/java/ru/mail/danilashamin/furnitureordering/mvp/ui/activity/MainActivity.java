package ru.mail.danilashamin.furnitureordering.mvp.ui.activity;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.mail.danilashamin.furnitureordering.R;
import ru.mail.danilashamin.furnitureordering.mvp.model.OnFurnitureDragListener;
import ru.mail.danilashamin.furnitureordering.mvp.model.Furniture;
import ru.mail.danilashamin.furnitureordering.mvp.model.FurnitureType;
import ru.mail.danilashamin.furnitureordering.mvp.model.OnFurnitureTouchListener;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
