package ru.mail.danilashamin.furnitureordering.mvp.ui.activity;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.creativityapps.gmailbackgroundlibrary.BackgroundMail;
import com.otaliastudios.cameraview.CameraListener;
import com.otaliastudios.cameraview.CameraUtils;
import com.otaliastudios.cameraview.CameraView;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.mail.danilashamin.furnitureordering.R;
import ru.mail.danilashamin.furnitureordering.mvp.App;
import ru.mail.danilashamin.furnitureordering.mvp.model.Furniture;
import ru.mail.danilashamin.furnitureordering.mvp.model.FurnitureType;
import ru.mail.danilashamin.furnitureordering.mvp.presentation.presenter.MainPresenter;
import ru.mail.danilashamin.furnitureordering.mvp.presentation.view.FurnitureView;
import ru.mail.danilashamin.furnitureordering.mvp.presentation.view.MainView;
import ru.mail.danilashamin.furnitureordering.mvp.presentation.view.dialog.ColorPickerDialog;
import ru.mail.danilashamin.furnitureordering.mvp.presentation.view.dialog.ColorPickerDialogListener;

import static ru.mail.danilashamin.furnitureordering.mvp.presentation.view.FurnitureView.FURNITURE_VIEW_TAG;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter mainPresenter;

    @BindView(R.id.photoView)
    CameraView photoView;
    @BindView(R.id.tvSingleUnitModuleCounter)
    TextView tvSingleUnitModuleCounter;
    @BindView(R.id.btnAddSingleModuleUnit)
    ImageView btnAddSingleModuleUnit;
    @BindView(R.id.tvFourModuleUnitCounter)
    TextView tvFourModuleUnitCounter;
    @BindView(R.id.btnAddFourModuleUnit)
    ImageView btnAddFourModuleUnit;
    @BindView(R.id.tvEightModuleUnitCounter)
    TextView tvEightModuleUnitCounter;
    @BindView(R.id.btnAddEightModuleUnit)
    ImageView btnAddEightModuleUnit;
    @BindView(R.id.btnBuy)
    Button btnBuy;
    @BindView(R.id.ivTrashCan)
    ImageView ivTrashCan;
    @BindView(R.id.tvPrice)
    TextView tvPrice;
    @BindView(R.id.btnColorPick)
    ImageView btnColorPick;
    @BindView(R.id.btnCamera)
    ImageView btnCamera;
    @BindView(R.id.fieldForFurniture)
    FrameLayout fieldForFurniture;
    @BindView(R.id.tvPillowCounter)
    TextView tvPillowCounter;
    @BindView(R.id.btnAddPillow)
    ImageView btnAddPillow;

    private ColorPickerDialog colorPickerDialog;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        colorPickerDialog = new ColorPickerDialog(this, new ColorPickerDialogListener() {
            @Override
            public void onColorPicked(int color, String article) {
                mainPresenter.changeCurrentFurnitureColor(color, article);
                mainPresenter.dismissColorPickerDialog();
            }

            @Override
            public void onDismissButtonClicked() {
                mainPresenter.dismissColorPickerDialog();
            }
        });
        photoView.addCameraListener(new CameraListener() {
            @Override
            public void onPictureTaken(byte[] jpeg) {
                CameraUtils.decodeBitmap(jpeg,
                        bitmap -> {
                            mainPresenter.stopCamera();
                            mainPresenter.setBackgroundPhoto(new BitmapDrawable(getResources(), bitmap));
                        });
            }
        });

        fieldForFurniture.setOnTouchListener((v, event) -> {
            mainPresenter.unsetCurrentFurniture();
            return true;
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        photoView.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        photoView.destroy();
    }

    @Override
    public void addFurnitureOnScreen(Furniture furniture) {
        FurnitureView furnitureView = new FurnitureView(this, furniture);
        furnitureView.setOnTouchListener(new OnFurnitureTouchListener(furniture));
        fieldForFurniture.addView(furnitureView);
        mainPresenter.setCurrentFurniture(furniture);
    }

    @Override
    public void setSingleUnitModuleCounter(Integer singleUnitModuleCounter) {
        tvSingleUnitModuleCounter.setText(String.valueOf(singleUnitModuleCounter));
    }

    @Override
    public void setFourUnitModuleCounter(Integer fourUnitModuleCounter) {
        tvFourModuleUnitCounter.setText(String.valueOf(fourUnitModuleCounter));
    }

    @Override
    public void setEightUnitModuleCounter(Integer eightUnitModuleCounter) {
        tvEightModuleUnitCounter.setText(String.valueOf(eightUnitModuleCounter));
    }

    @Override
    public void setPillowCounter(Integer pillowCounter) {
        tvPillowCounter.setText(String.valueOf(pillowCounter));
    }

    @Override
    public void setBackgroundPhoto(Drawable photo) {
        photoView.setBackground(photo);
    }


    @Override
    public void deleteFurnitureView(Furniture furnitureForDelete) {
        fieldForFurniture.removeView(findFurnitureView(furnitureForDelete));
        ivTrashCan.setImageDrawable(getResources().getDrawable(R.drawable.ic_delete_forever));
    }

    private FurnitureView findFurnitureView(Furniture furniture) {
        return fieldForFurniture.findViewWithTag(String.format(Locale.getDefault(), "%s%d", FURNITURE_VIEW_TAG, furniture.getID()));
    }

    @Override
    public void showColorPickerDialog() {
        colorPickerDialog.show();
    }

    @Override
    public void dismissColorPickerDialog() {
        colorPickerDialog.dismiss();
    }

    @Override
    public void changeCurrentFurnitureColor(int color, Furniture currentFurniture) {
        findFurnitureView(currentFurniture).setColorFilterOnBitmap(color);
    }

    @Override
    public void startCamera() {
        photoView.start();
        btnCamera.setOnClickListener(v -> {
                    photoView.capturePicture();
                    btnCamera.setOnClickListener(v1 -> mainPresenter.startCamera());
                }
        );
    }

    @Override
    public void stopCamera() {
        photoView.stop();
    }

    @Override
    public void deleteAllFurniture() {
        fieldForFurniture.removeAllViews();
    }

    @Override
    public void setCurrentFurniture(Furniture currentFurniture) {
        FurnitureView view = findFurnitureView(currentFurniture);
        if (view != null) {
            view.setCurrent();
        }
    }

    @Override
    public void unsetCurrentFurniture(Furniture currentFurniture) {
        FurnitureView view = findFurnitureView(currentFurniture);
        if (view != null) {
            view.unsetCurrent();
        }
    }

    @Override
    public void setPrice(double price) {
        tvPrice.setText(String.format("\u20BD%s", String.valueOf(price)));
    }


    @Override
    public void buy(List<Furniture> furnitureList) {
        if (furnitureList.isEmpty()) {
            Toast.makeText(this, getString(R.string.order_empty), Toast.LENGTH_SHORT).show();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Содержание заказа: \n");
        for (Furniture furniture : furnitureList) {
            stringBuilder.append(furniture.toString());
        }
        BackgroundMail.newBuilder(this)
                .withUsername("suncoinfurnitureneworder@gmail.com")
                .withPassword("akofcNl7")
                .withMailto("danilashamin@mail.ru")
                .withType(BackgroundMail.TYPE_PLAIN)
                .withSubject("Новый заказ")
                .withBody(stringBuilder.toString())
                .withOnSuccessCallback(() -> Toast.makeText(this, getString(R.string.email_succcess), Toast.LENGTH_LONG).show())
                .withOnFailCallback(() -> Toast.makeText(this, getString(R.string.email_fail), Toast.LENGTH_LONG).show())
                .send();
    }


    @OnClick(R.id.btnBuy)
    public void onBtnBuyClicked() {
        mainPresenter.buy();
    }


    @OnClick(R.id.btnColorPick)
    public void onBtnColorPickClicked() {
        mainPresenter.showColorPickerDialog();
    }

    @OnClick(R.id.btnCamera)
    public void onCameraBtnClicked() {
        mainPresenter.startCamera();
    }

    @OnClick(R.id.ivTrashCan)
    public void onTrashCanClicked() {
        mainPresenter.deleteAllFurniture();
    }

    @OnClick({R.id.btnAddSingleModuleUnit, R.id.btnAddFourModuleUnit, R.id.btnAddEightModuleUnit, R.id.btnAddPillow})
    public void onAddButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.btnAddSingleModuleUnit:
                mainPresenter.addFurniture(FurnitureType.SINGLE_UNIT_MODULE);
                break;
            case R.id.btnAddFourModuleUnit:
                mainPresenter.addFurniture(FurnitureType.FOUR_UNIT_MODULE);
                break;
            case R.id.btnAddEightModuleUnit:
                mainPresenter.addFurniture(FurnitureType.EIGHT_UNIT_MODULE);
                break;
            case R.id.btnAddPillow:
                mainPresenter.addFurniture(FurnitureType.PILLOW);
                break;
        }
    }

    @OnClick(R.id.btnSelectFito)
    public void onbtnSelectFitoClicked() {
        mainPresenter.selectFito();
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
