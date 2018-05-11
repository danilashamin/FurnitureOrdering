package ru.mail.danilashamin.furnitureordering.mvp.model;

public enum FurnitureType {
    SINGLE_UNIT_MODULE, DOUBLE_UNIT_MODULE, TRIPLE_UNIT_MODULE, FOURTH_MODULE_UNIT;

    public static Double getPriceByType(FurnitureType type) {
        switch (type) {
            case SINGLE_UNIT_MODULE:
                return Constants.Prices.SINGLE_UNIT_MODULE;
            case DOUBLE_UNIT_MODULE:
                return Constants.Prices.DOUBLE_UNIT_MODULE;
            case TRIPLE_UNIT_MODULE:
                return Constants.Prices.TRIPLE_UNIT_MODULE;
            case FOURTH_MODULE_UNIT:
                return Constants.Prices.FOURTH_UNIT_MODULE;
            default:
                return 0D;
        }
    }

    public static String getNameByType(FurnitureType type) {
        switch (type) {
            case SINGLE_UNIT_MODULE:
                return Constants.NamesOfFurniture.SINGLE_UNIT_MODULE;
            case DOUBLE_UNIT_MODULE:
                return Constants.NamesOfFurniture.DOUBLE_UNIT_MODULE;
            case TRIPLE_UNIT_MODULE:
                return Constants.NamesOfFurniture.TRIPLE_UNIT_MODULE;
            case FOURTH_MODULE_UNIT:
                return Constants.NamesOfFurniture.FOURTH_UNIT_MODULE;
            default:
                return "";
        }
    }
}

