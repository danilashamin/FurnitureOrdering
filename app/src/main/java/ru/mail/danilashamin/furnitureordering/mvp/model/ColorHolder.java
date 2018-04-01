package ru.mail.danilashamin.furnitureordering.mvp.model;

import android.content.res.Resources;
import android.support.annotation.NonNull;

import ru.mail.danilashamin.furnitureordering.R;

public class ColorHolder {
    @NonNull
    public static int[] getColorArray(Resources resources) {
        return new int[]{resources.getColor(R.color.first_color),
                resources.getColor(R.color.second_color),
                resources.getColor(R.color.third_color),
                resources.getColor(R.color.fourth_color),
                resources.getColor(R.color.fifth_color),
                resources.getColor(R.color.sixth_color),
                resources.getColor(R.color.seventh_color),
                resources.getColor(R.color.eighth_color),
                resources.getColor(R.color.tenth_color),
                resources.getColor(R.color.eleventh_color),
                resources.getColor(R.color.twelveth_color)};
    }
}
