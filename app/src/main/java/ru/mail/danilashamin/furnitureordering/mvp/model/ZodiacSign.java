package ru.mail.danilashamin.furnitureordering.mvp.model;

import ru.mail.danilashamin.furnitureordering.mvp.model.Constants.ZodiacSignsStringConstants;

public enum ZodiacSign {
    ARIES(1, ZodiacSignsStringConstants.ARIES), TAURUS(2, ZodiacSignsStringConstants.TAURUS),
    GEMINI(3, ZodiacSignsStringConstants.GEMINI), CANCER(4, ZodiacSignsStringConstants.CANCER),
    LEO(5, ZodiacSignsStringConstants.LEO), VIRGO(6, ZodiacSignsStringConstants.VIRGO),
    LIBRA(7, ZodiacSignsStringConstants.LIBRA), SCORPIO(8, ZodiacSignsStringConstants.SCORPIO),
    SAGITTARIUS(9, ZodiacSignsStringConstants.SAGITTARIUS), CAPRICORN(10, ZodiacSignsStringConstants.CAPRICORN),
    AQUARIUS(11, ZodiacSignsStringConstants.AQUARIUS), PISCES(12, ZodiacSignsStringConstants.PISCES);

    private int zodiacIndex;
    private String zodiacSign;

    ZodiacSign(int zodiacIndex, String zodiacSign) {
        this.zodiacIndex = zodiacIndex;
        this.zodiacSign = zodiacSign;
    }


    public static ZodiacSign getZodiacSign(int number) {
        for (ZodiacSign sign : values()) {
            if (sign.zodiacIndex == number) {
                return sign;
            }
        }
        return null;
    }

    public int getZodiacIndex() {
        return zodiacIndex;
    }

    public String getZodiacName() {
        return zodiacSign;
    }
}
