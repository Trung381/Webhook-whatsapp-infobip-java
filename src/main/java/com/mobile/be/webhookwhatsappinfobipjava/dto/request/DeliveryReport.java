package com.mobile.be.webhookwhatsappinfobipjava.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryReport {
    private List<Result> results;

    @Getter
    @Setter
    @RequiredArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
        private String bulkId;
        private Price price;
        private Status status;
        private ErrorRes error;
        private String messageId;
        private String doneAt;
        private Integer messageCount;
        private String sentAt;
        private String to;

        @Getter
        @Setter
        @RequiredArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Price {
            private String currency;
            private Double pricePerMessage;
        }

        @Getter
        @Setter
        @RequiredArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Status {
            private String groupName;
            private Integer id;
            private Integer groupId;
            private String name;
            private String action;
            private String description;
        }

        @Getter
        @Setter
        @RequiredArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ErrorRes {
            private String description;
            private Boolean permanent;
            private String name;
            private Integer id;
            private String groupName;
            private Integer groupId;
        }


    }
}
