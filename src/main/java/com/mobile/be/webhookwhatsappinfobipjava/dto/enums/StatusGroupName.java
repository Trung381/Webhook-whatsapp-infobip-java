package com.mobile.be.webhookwhatsappinfobipjava.dto.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.mobile.be.webhookwhatsappinfobipjava.dto.constant.BaseEnum;

public enum StatusGroupName implements BaseEnum<String> {
    PENDING("PENDING"),
    UNDELIVERABLE("UNDELIVERABLE"),
    DELIVERED("DELIVERED"),
    EXPIRED("EXPIRED"),
    REJECTED("REJECTED");


    private final String value;

    StatusGroupName(String value) {
        this.value = value;
    }

    @Override
    public String toValue() {
        return value;
    }

    @JsonCreator
    public static StatusGroupName fromValue(String value) {
        for (StatusGroupName val : StatusGroupName.values()) {
            if (val.value.equalsIgnoreCase(value)) {
                return val;
            }
        }
        return null;
    }
}
