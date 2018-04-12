package ru.mail.danilashamin.furnitureordering.mvp.presentation.view.dialog;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.BindView;
import butterknife.OnClick;
import ru.mail.danilashamin.furnitureordering.R;
import ru.mail.danilashamin.furnitureordering.mvp.model.ZodiacSign;

public class FitoPickerDialog {
    private MaterialDialog dialog;
    private FitoPickerDialogListener listener;
    private ZodiacSign sign;

    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.acceptBtn)
    Button acceptBtn;
    @BindView(R.id.cancelBtn)
    Button cancelBtn;

    FitoPickerDialog(Context context, FitoPickerDialogListener listener) {
        dialog = new MaterialDialog.Builder(context)
                .cancelable(true)
                .canceledOnTouchOutside(true)
                .customView(R.layout.dialog_fito_pick, true)
                .build();
        this.listener = listener;
        spinner.setOnItemClickListener((parent, view, position, id) -> sign = ZodiacSign.getZodiacSign(position));
    }

    public void show(@Nullable ZodiacSign sign) {
        if (sign != null) {
            spinner.setSelection(sign.getZodiacIndex());
        }
        dialog.show();
    }

    @OnClick({R.id.acceptBtn, R.id.cancelBtn})
    public void onButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.acceptBtn:
                listener.onFitoPicked(sign);
                break;
            case R.id.cancelBtn:
                listener.onDismiss();
                break;
        }
    }
}
