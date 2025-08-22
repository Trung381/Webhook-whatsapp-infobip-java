package com.mobile.be.webhookwhatsappinfobipjava.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketingUpdateNotification {
    @NotBlank
    private String from;
    @Valid
    private Content content;
    private String createdAt;

    @Getter
    @Setter
    @RequiredArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Content {
        @NotBlank
        private String sender;
        @NotBlank
        private String from;
        @NotBlank
        private String notificationMessagesStatus;
        @NotBlank
        private String description;
    }
}
