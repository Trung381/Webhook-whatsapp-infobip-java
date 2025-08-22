package com.mobile.be.webhookwhatsappinfobipjava.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mobile.be.webhookwhatsappinfobipjava.dto.enums.InboundMessageType;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InboundReq {
    @Valid
    private List<Result> results;
    private Integer messageCount;
    private Integer pendingMessageCount;

    @Getter
    @Setter
    @RequiredArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
        @Size(min = 0, max = 255, message = "Entity ID must be between 0 and 255 characters")
        private String entityId;

        @Size(min = 0, max = 255, message = "Entity ID must be between 0 and 255 characters")
        private String applicationId;

        @NotBlank
        private String from;

        @NotBlank
        private String to;

        @NotBlank
        private String integrationType;

        @NotBlank
        private Date receivedAt;

        private String keyword;

        @NotBlank
        private String messageId;

        private String pairedMessageId;

        private String callbackData;

        @Valid
        @NotNull
        private Message message;

        @Valid
        @NotNull
        private Price price;

        @Valid
        @NotNull
        private Contact contact;

        @Valid
        private Identity identity;

        @Getter
        @Setter
        @RequiredArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Message {
            @NotNull
            private InboundMessageType type;
            @Valid
            private Context context;

            @Getter
            @Setter
            @RequiredArgsConstructor
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Context {
                private String from;
                private String id;
                private String groupId;
                @Valid
                private ReferredProduct referredProduct;

                @Getter
                @Setter
                @RequiredArgsConstructor
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class ReferredProduct {
                    @NotBlank
                    private String catalogId;
                    @NotBlank
                    private String productRetailerId;
                }
            }
        }

        @Getter
        @Setter
        @RequiredArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Price {
            private Double pricePerMessage;
            private String currency;
        }

        @Getter
        @Setter
        @RequiredArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Contact {
            private String name;
        }

        @Getter
        @Setter
        @RequiredArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Identity {
            @NotNull
            private Boolean acknowledged;
            @NotBlank
            private String hash;
            @NotBlank
            private Date createdAt;
        }
    }
}
