package com.mobile.be.webhookwhatsappinfobipjava.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageStatusCallback {
    private List<Result> results;

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
        String bulkId;
        Price price;
        Status status;
        Error error;
        String messageId;
        Date doneAt;
        Integer messageCount;
        Date sentAt;
        Date seenAt;
        String from;
        String to;
        String applicationId;
        String entityId;


        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Price {
            private String currency;
            private Double pricePerMessage;
        }

        @Data
        @FieldDefaults(level = AccessLevel.PRIVATE)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Status {
            String groupName;
            Integer id;
            Integer groupId;
            String name;
            String action;
            String description;
        }

        @Data
        @FieldDefaults(level = AccessLevel.PRIVATE)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Error {
            String description;
            Boolean permanent;
            String name;
            Integer id;
            String groupName;
            Integer groupId;
        }
    }
}
