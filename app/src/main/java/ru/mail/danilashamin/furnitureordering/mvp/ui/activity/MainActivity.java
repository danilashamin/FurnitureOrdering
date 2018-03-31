package ru.mail.danilashamin.furnitureordering.mvp.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.mail.danilashamin.furnitureordering.R;
import ru.mail.danilashamin.furnitureordering.mvp.model.DragListener;
import ru.mail.danilashamin.furnitureordering.mvp.model.FurnitureType;
import ru.mail.danilashamin.furnitureordering.mvp.presentation.presenter.MainPresenter;
import ru.mail.danilashamin.furnitureordering.mvp.presentation.view.MainView;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter mainPresenter;

    @BindView(R.id.fieldForFurniture)
    LinearLayout fieldForFurniture;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void addFurnitureOnScreen(FurnitureType type) {
        ImageView furniture = new ImageView(this);
        switch (type) {
            case PUFF:
                furniture.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
                break;
            case CUSHION:
                furniture.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
                break;
            case MATTRESS:
                furniture.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
                break;
        }
        WindowManager.LayoutParams imageViewLayoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        imageViewLayoutParams.width = 100;
        imageViewLayoutParams.height = 100;
        imageViewLayoutParams.gravity = Gravity.CENTER;
        furniture.setLayoutParams(imageViewLayoutParams);
        furniture.setOnTouchListener(new DragListener());
        fieldForFurniture.addView(furniture);
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
}
