package ru.mail.danilashamin.furnitureordering.mvp.presentation.view.dialog;

import ru.mail.danilashamin.furnitureordering.mvp.model.ZodiacSign;

public interface FitoPickerDialogListener {
    void onFitoPicked(ZodiacSign sign);

    void onDismiss();
}
