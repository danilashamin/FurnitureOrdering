package ru.mail.danilashamin.furnitureordering.mvp.model;

import android.support.annotation.DrawableRes;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.FrameLayout;

import java.util.Locale;

import ru.mail.danilashamin.furnitureordering.R;

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
        initLayoutParams(type);
    }

    private void initLayoutParams(FurnitureType type) {

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

    public FrameLayout.LayoutParams getLayoutParams(@DrawableRes int idRes) {
        layoutParams = new FrameLayout.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        switch (type) {
            case SINGLE_UNIT_MODULE:
                layoutParams.width = 125;
                layoutParams.height = 125;
                break;
            case DOUBLE_UNIT_MODULE:
                layoutParams.width = 250;
                layoutParams.height = 150;
                break;
            case TRIPLE_UNIT_MODULE:
                layoutParams.width = 375;
                layoutParams.height = 175;
                break;
            case FOURTH_MODULE_UNIT:
                switch (idRes) {
                    default:
                    case R.drawable.fourth_first:
                        layoutParams.width = 500;
                        layoutParams.height = 200;
                        break;
                    case R.drawable.fourth_third:
                        layoutParams.width = 400;
                        layoutParams.height = 200;
                        break;
                }
                break;
        }
        layoutParams.gravity = Gravity.CENTER;
        return layoutParams;
    }


    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(Locale.getDefault(), "№ %d\n", Id));
        builder.append("Вид товара: ").append(FurnitureType.getNameByType(type)).append("\n");
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
