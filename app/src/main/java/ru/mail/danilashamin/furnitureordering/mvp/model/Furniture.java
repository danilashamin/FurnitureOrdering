package ru.mail.danilashamin.furnitureordering.mvp.model;

import android.view.Gravity;
import android.view.WindowManager;
import android.widget.FrameLayout;

import java.util.Locale;

public class Furniture {
    private FurnitureType type;
    private Integer Id;
    private Double price;
    private String article;
    private ZodiacSign sign;

    private FrameLayout.LayoutParams layoutParams;

    public Furniture(FurnitureType type, int Id) {
        this.type = type;
        this.Id = Id;
        price = FurnitureType.getPriceByType(type);
        article = "OK 3";
        initLayoutParams();
    }

    private void initLayoutParams() {
        layoutParams = new FrameLayout.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        layoutParams.width = 100;
        layoutParams.height = 100;
        layoutParams.gravity = Gravity.CENTER;
    }

    public FurnitureType getType() {
        return type;
    }

    public int getId() {
        return Id;
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
        builder.append(String.format(Locale.getDefault(), "№ %d\n", Id));
        builder.append(FurnitureType.getNameByType(type));
        builder.append("Вид товара: ").append(type).append("\n");
        builder.append("Артикул цвета: ").append(article).append("\n");
        if (sign != null) {
            builder.append("Знак зодиака фитосостава: ").append(sign.getZodiacName()).append("\n");
        }
        builder.append("Цена: ").append(price).append("\n");
        return builder.toString();
    }

    public void setSign(ZodiacSign sign) {
        this.sign = sign;
    }

    public ZodiacSign getSign() {
        return sign;
    }
}
