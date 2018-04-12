package ru.mail.danilashamin.furnitureordering.mvp.presentation.view.dialog;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;

import br.com.sapereaude.maskedEditText.MaskedEditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.mail.danilashamin.furnitureordering.R;

public class DialogEnterPhoneNumber {
    private final static Integer LENGTH_OF_NUMBER = 17;

    @BindView(R.id.phoneEditText)
    MaskedEditText phoneEditText;
    @BindView(R.id.cancel)
    Button cancel;
    @BindView(R.id.makeOrderButton)
    Button makeOrderButton;

    private MaterialDialog dialog;
    private String phoneNumber;
    private DialogEnterPhoneNumberListener listener;

    public DialogEnterPhoneNumber(Context context, DialogEnterPhoneNumberListener listener) {
        dialog = new MaterialDialog.Builder(context)
                .customView(R.layout.dialog_phone_number, true)
                .canceledOnTouchOutside(true)
                .cancelable(true)
                .build();
        this.listener = listener;

        ButterKnife.bind(this, dialog);

        makeOrderButton.setEnabled(false);

        phoneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == LENGTH_OF_NUMBER) {
                    phoneNumber = s.toString();
                    makeOrderButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void show() {
        dialog.show();
    }

    public void dismiss() {
        dialog.dismiss();
    }

    @OnClick({R.id.cancel, R.id.makeOrderButton})
    public void onButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.cancel:
                listener.onDismiss();
                break;
            case R.id.makeOrderButton:
                listener.onMakeOrder(phoneNumber);
                break;
        }
    }
}
