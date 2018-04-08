package ru.mail.danilashamin.furnitureordering.mvp.presentation.view.dialog;

public interface ColorPickerDialogListener {
    void onColorPicked(int color, String article);
    void onDismissButtonClicked();
}
