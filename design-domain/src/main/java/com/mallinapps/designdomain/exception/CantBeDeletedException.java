package com.mallinapps.designdomain.exception;

public class CantBeDeletedException extends RuntimeException {
    public CantBeDeletedException(final String message) {
        super(message);
    }
}
