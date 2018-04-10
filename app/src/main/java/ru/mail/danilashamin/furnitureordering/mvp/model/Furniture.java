package ru.mail.danilashamin.furnitureordering.mvp.model;

import android.view.Gravity;
import android.view.WindowManager;
import android.widget.FrameLayout;

import java.util.Locale;

import static android.view.Gravity.CENTER;

public class Furniture {
    private FurnitureType type;
    private int ID;
    private Double price;
    private String article;
    private int fitoNumber;

    private FrameLayout.LayoutParams layoutParams;

    public Furniture(FurnitureType type, int ID) {
        this.type = type;
        this.ID = ID;
        this.layoutParams = new FrameLayout.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        layoutParams.width = 100;
        layoutParams.height = 100;
        layoutParams.gravity = Gravity.CENTER;
        article = "OK 3";
        setPrice();
    }

    private void setPrice() {
        switch (type) {
            case SINGLE_UNIT_MODULE:
                price = (double) 3000;
                break;
            case FOUR_UNIT_MODULE:
                price = (double) 90000;
                break;
            case EIGHT_UNIT_MODULE:
                price = (double) 150000;
                break;
            case PILLOW:
                price = (double) 600;
                break;

        }
    }

    public FurnitureType getType() {
        return type;
    }

    public int getID() {
        return ID;
    }

    public void setLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.layoutParams = layoutParams;
    }

    public Double getPrice() {
        return price;
    }

    public FrameLayout.LayoutParams getLayoutParams() {
        return layoutParams;
    }


    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(Locale.getDefault(), "№ %d\n", ID));
        String type = "";
        switch (this.type) {
            case SINGLE_UNIT_MODULE:
                type = "Одноблочный модуль";
                break;
            case FOUR_UNIT_MODULE:
                type = "Четырёхблочный модуль";
                break;
            case EIGHT_UNIT_MODULE:
                type = "Восьмиблочный модуль";
                break;
            case PILLOW:
                type = "Подушка";
                break;

        }
        builder.append("Вид товара: ").append(type).append("\n");
        builder.append("Артикул цвета: ").append(article).append("\n");
        if (fitoNumber != 0) {
            builder.append("Номер фитосостава: ").append(fitoNumber).append("\n");
        }
        builder.append("Цена: ").append(price).append("\n");
        return builder.toString();
    }

    public void setFitoNumber(int fitoNumber) {
        this.fitoNumber = fitoNumber;
    }
}
