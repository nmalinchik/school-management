package com.mallinapps.designdomain.controller.api.common;

public enum ErrorType {
    SECURITY("security"), REQUEST("request"), VALIDATION("validation"), CONSTRAINT("constraint"), INTERNAL("internal");
    final String type;

    ErrorType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
