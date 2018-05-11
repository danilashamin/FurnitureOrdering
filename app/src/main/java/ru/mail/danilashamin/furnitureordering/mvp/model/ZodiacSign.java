package ru.mail.danilashamin.furnitureordering.mvp.model;

import ru.mail.danilashamin.furnitureordering.mvp.model.Constants.ZodiacSignsStringConstants;
import ru.mail.danilashamin.furnitureordering.mvp.model.Constants.ZodiacSignsComposition;

public enum ZodiacSign {
    ARIES(1, ZodiacSignsStringConstants.ARIES, ZodiacSignsComposition.ARIES), TAURUS(2, ZodiacSignsStringConstants.TAURUS, ZodiacSignsComposition.TAURUS),
    GEMINI(3, ZodiacSignsStringConstants.GEMINI, ZodiacSignsComposition.GEMINI), CANCER(4, ZodiacSignsStringConstants.CANCER, ZodiacSignsComposition.CANCER),
    LEO(5, ZodiacSignsStringConstants.LEO, ZodiacSignsComposition.LEO), VIRGO(6, ZodiacSignsStringConstants.VIRGO, ZodiacSignsComposition.VIRGO),
    LIBRA(7, ZodiacSignsStringConstants.LIBRA, ZodiacSignsComposition.LIBRA), SCORPIO(8, ZodiacSignsStringConstants.SCORPIO, ZodiacSignsComposition.SCORPIO),
    SAGITTARIUS(9, ZodiacSignsStringConstants.SAGITTARIUS, ZodiacSignsComposition.SAGITTARIUS), CAPRICORN(10, ZodiacSignsStringConstants.CAPRICORN, ZodiacSignsComposition.CAPRICORN),
    AQUARIUS(11, ZodiacSignsStringConstants.AQUARIUS, ZodiacSignsComposition.AQUARIUS), PISCES(12, ZodiacSignsStringConstants.PISCES, ZodiacSignsComposition.PISCES);

    private int zodiacIndex;
    private String zodiacSign;
    private String composition;

    ZodiacSign(int zodiacIndex, String zodiacSign, String composition) {
        this.zodiacIndex = zodiacIndex;
        this.zodiacSign = zodiacSign;
        this.composition = composition;
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

    public String getComposition() {
        return composition;
    }
}
