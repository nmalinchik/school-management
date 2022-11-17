package com.mallinapps.designdomain.domain.enums;

public enum Grade {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    SIXTH(6),
    SEVENTH(7),
    EIGHTH(8),
    NINTH(9),
    TENS(10),
    ELEVENTH(11);

    final int value;

    Grade(final int value) {this.value = value;}
}
