package com.mobile.be.webhookwhatsappinfobipjava.dto.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.mobile.be.webhookwhatsappinfobipjava.dto.constant.BaseEnum;

public enum InboundMessageType implements BaseEnum<String> {
    UNSUPPORTED("UNSUPPORTED"),
    TEXT("TEXT"),
    LOCATION("LOCATION"),
    IMAGE("IMAGE"),
    DOCUMENT("DOCUMENT"),
    AUDIO("AUDIO"),
    VIDEO("VIDEO"),
    VOICE("VOICE"),
    CONTACT("CONTACT"),
    INFECTED_CONTENT("INFECTED_CONTENT"),
    BUTTON("BUTTON"),
    STICKER("STICKER"),
    INTERACTIVE_BUTTON_REPLY("INTERACTIVE_BUTTON_REPLY"),
    INTERACTIVE_LIST_REPLY("INTERACTIVE_LIST_REPLY"),
    INTERACTIVE_FLOW_REPLY("INTERACTIVE_FLOW_REPLY"),
    INTERACTIVE_PAYMENT_CONFIRMATION("INTERACTIVE_PAYMENT_CONFIRMATION"),
    INTERACTIVE_CALL_PERMISSION_REPLY("INTERACTIVE_CALL_PERMISSION_REPLY"),
    ORDER("ORDER");


    private final String value;

    InboundMessageType(String value) {
        this.value = value;
    }

    @Override
    public String toValue() {
        return value;
    }

    @JsonCreator
    public static InboundMessageType fromValue(String value) {
        for (InboundMessageType val : InboundMessageType.values()) {
            if (val.value.equalsIgnoreCase(value)) {
                return val;
            }
        }
        return null;
    }
}