package ru.mail.danilashamin.furnitureordering.mvp.model;

public enum FurnitureType {
    SINGLE_UNIT_MODULE, FOUR_UNIT_MODULE, EIGHT_UNIT_MODULE, PILLOW;

    public static Double getPriceByType(FurnitureType type) {
        switch (type) {
            case SINGLE_UNIT_MODULE:
                return Constants.Prices.SINGLE_UNIT_MODULE;
            case FOUR_UNIT_MODULE:
                return Constants.Prices.FOUR_UNIT_MODULE;
            case EIGHT_UNIT_MODULE:
                return Constants.Prices.EIGHT_UNIT_MODULE;
            case PILLOW:
                return Constants.Prices.PILLOW;
            default:
                return 0D;
        }
    }

    public static String getNameByType(FurnitureType type) {
        switch (type) {
            case SINGLE_UNIT_MODULE:
                return Constants.NamesOfFurniture.SINGLE_UNIT_MODULE;
            case FOUR_UNIT_MODULE:
                return Constants.NamesOfFurniture.FOUR_UNIT_MODULE;
            case EIGHT_UNIT_MODULE:
                return Constants.NamesOfFurniture.EIGHT_UNIT_MODULE;
            case PILLOW:
                return Constants.NamesOfFurniture.PILLOW;
            default:
                return "";
        }
    }
}

