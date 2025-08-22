package com.mobile.be.webhookwhatsappinfobipjava.dto.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.mobile.be.webhookwhatsappinfobipjava.dto.constant.BaseEnum;

public enum ErrorGroupName implements BaseEnum<String> {
    OK("OK"),
    HANDSET_ERRORS("HANDSET_ERRORS"),
    USER_ERRORS("USER_ERRORS"),
    OPERATOR_ERRORS("OPERATOR_ERRORS");


    private final String value;

    ErrorGroupName(String value) {
        this.value = value;
    }

    @Override
    public String toValue() {
        return value;
    }

    @JsonCreator
    public static ErrorGroupName fromValue(String value) {
        for (ErrorGroupName val : ErrorGroupName.values()) {
            if (val.value.equalsIgnoreCase(value)) {
                return val;
            }
        }
        return null;
    }
}