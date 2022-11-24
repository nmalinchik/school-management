package com.mallinapps.designdomain.common;

import lombok.Getter;

public enum FirstPage {

    ZERO(0), ONE(1);

    @Getter
    private final int number;

    FirstPage(final int number) {
        this.number = number;
    }

}
