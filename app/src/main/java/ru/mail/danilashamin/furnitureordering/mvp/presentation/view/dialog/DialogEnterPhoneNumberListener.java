package ru.mail.danilashamin.furnitureordering.mvp.presentation.view.dialog;

import android.support.annotation.NonNull;

public interface DialogEnterPhoneNumberListener {
    void onMakeOrder(@NonNull String phoneNumber);

    void onDismiss();
}
