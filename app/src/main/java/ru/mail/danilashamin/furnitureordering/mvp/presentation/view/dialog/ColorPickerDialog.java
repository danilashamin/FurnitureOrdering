package ru.mail.danilashamin.furnitureordering.mvp.presentation.view.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import ru.mail.danilashamin.furnitureordering.R;

public class ColorPickerDialog {

    private MaterialDialog dialog;

    @BindView(R.id.btnFirstColor)
    CircleImageView btnFirstColor;
    @BindView(R.id.btnSecondColor)
    CircleImageView btnSecondColor;
    @BindView(R.id.btnThirdColor)
    CircleImageView btnThirdColor;
    @BindView(R.id.btnFourthColor)
    CircleImageView btnFourthColor;
    @BindView(R.id.btnFifthColor)
    CircleImageView btnFifthColor;
    @BindView(R.id.btnSixthColor)
    CircleImageView btnSixthColor;
    @BindView(R.id.btnSeventhColor)
    CircleImageView btnSeventhColor;
    @BindView(R.id.btnEightColor)
    CircleImageView btnEightColor;
    @BindView(R.id.btnNinethColor)
    CircleImageView btnNinethColor;
    @BindView(R.id.btnTenthColor)
    CircleImageView btnTenthColor;
    @BindView(R.id.btnEleventhColor)
    CircleImageView btnEleventhColor;
    @BindView(R.id.btnTwelvethColor)
    CircleImageView btnTwelvethColor;
    @BindView(R.id.btnThirteenthColor)
    CircleImageView btnThirteenthColor;
    @BindView(R.id.btnFourteenthColor)
    CircleImageView btnFourteenthColor;
    @BindView(R.id.btnFifteenthColor)
    CircleImageView btnFifteenthColor;
    @BindView(R.id.btnSixteenthColor)
    CircleImageView btnSixteenthColor;
    @BindView(R.id.cancelButton)
    Button cancelButton;

    private Resources resources;
    private ColorPickerDialogListener listener;

    public ColorPickerDialog(Context context, ColorPickerDialogListener listener) {
        dialog = new MaterialDialog.Builder(context)
                .customView(R.layout.dialog_color_pick, true)
                .canceledOnTouchOutside(false)
                .build();
        this.listener = listener;
        this.resources = context.getResources();
        ButterKnife.bind(this, dialog);
    }

    public void show() {
        dialog.show();
    }

    public void dismiss() {
        dialog.dismiss();
    }

    @OnClick({R.id.btnFirstColor, R.id.btnSecondColor, R.id.btnThirdColor, R.id.btnFourthColor, R.id.btnFifthColor, R.id.btnSixthColor, R.id.btnSeventhColor, R.id.btnEightColor, R.id.btnNinethColor, R.id.btnTenthColor, R.id.btnEleventhColor, R.id.btnTwelvethColor, R.id.btnThirteenthColor, R.id.btnFourteenthColor, R.id.btnFifteenthColor, R.id.btnSixteenthColor, R.id.cancelButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnFirstColor:
                listener.onColorPicked(resources.getColor(R.color.first_color), "OK 3");
                break;
            case R.id.btnSecondColor:
                listener.onColorPicked(resources.getColor(R.color.second_color), "OK 4");
                break;
            case R.id.btnThirdColor:
                listener.onColorPicked(resources.getColor(R.color.third_color), "OK 6");
                break;
            case R.id.btnFourthColor:
                listener.onColorPicked(resources.getColor(R.color.fourth_color), "OK 8");
                break;
            case R.id.btnFifthColor:
                listener.onColorPicked(resources.getColor(R.color.fifth_color), "OK 10");
                break;
            case R.id.btnSixthColor:
                listener.onColorPicked(resources.getColor(R.color.sixth_color), "OK 11");
                break;
            case R.id.btnSeventhColor:
                listener.onColorPicked(resources.getColor(R.color.seventh_color), "OK 13");
                break;
            case R.id.btnEightColor:
                listener.onColorPicked(resources.getColor(R.color.eighth_color), "OK 13");
                break;
            case R.id.btnNinethColor:
                listener.onColorPicked(resources.getColor(R.color.nineth_color), "OK 15");
                break;
            case R.id.btnTenthColor:
                listener.onColorPicked(resources.getColor(R.color.tenth_color), "OK 18");
                break;
            case R.id.btnEleventhColor:
                listener.onColorPicked(resources.getColor(R.color.eleventh_color), "OK 19");
                break;
            case R.id.btnTwelvethColor:
                listener.onColorPicked(resources.getColor(R.color.twelveth_color), "OK 20");
                break;
            case R.id.btnThirteenthColor:
                listener.onColorPicked(resources.getColor(R.color.thirteenth_color), "OK 21");
                break;
            case R.id.btnFourteenthColor:
                listener.onColorPicked(resources.getColor(R.color.fourteenth_color), "OK 25");
                break;
            case R.id.btnFifteenthColor:
                listener.onColorPicked(resources.getColor(R.color.fifteenth_color), "OK BLACK");
                break;
            case R.id.btnSixteenthColor:
                listener.onColorPicked(resources.getColor(R.color.sixteenth_color), "OK 12");
                break;
            case R.id.cancelButton:
                listener.onDismissButtonClicked();
                break;
        }
    }
}
