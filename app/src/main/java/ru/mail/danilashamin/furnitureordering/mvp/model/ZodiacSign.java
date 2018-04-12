package ru.mail.danilashamin.furnitureordering.mvp.model;

import ru.mail.danilashamin.furnitureordering.mvp.model.Constants.ZodiacSignsStringConstants;
public enum ZodiacSign {
    ARIES, TAURUS, GEMINI, CANCER, LEO, VIRGO, LIBRA, SCORPIO, SAGITTARIUS, CAPRICORN, AQUARIUS, PISCES;

    public static String getZodiacSign(ZodiacSign sign) {
        switch (sign) {
            case ARIES:
                return ZodiacSignsStringConstants.ARIES;
            case TAURUS:
                return ZodiacSignsStringConstants.TAURUS;
            case GEMINI:
                return ZodiacSignsStringConstants.GEMINI;
            case CANCER:
                return ZodiacSignsStringConstants.CANCER;
            case LEO:
                return ZodiacSignsStringConstants.LEO;
            case VIRGO:
                return ZodiacSignsStringConstants.VIRGO;
            case LIBRA:
                return ZodiacSignsStringConstants.LIBRA;
            case SCORPIO:
                return ZodiacSignsStringConstants.SCORPIO;
            case SAGITTARIUS:
                return ZodiacSignsStringConstants.SAGITTARIUS;
            case CAPRICORN:
                return ZodiacSignsStringConstants.CAPRICORN;
            case AQUARIUS:
                return ZodiacSignsStringConstants.AQUARIUS;
            case PISCES:
                return ZodiacSignsStringConstants.PISCES;
            default:
                return "";
        }
    }
}
