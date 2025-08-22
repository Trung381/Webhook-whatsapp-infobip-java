package com.mobile.be.webhookwhatsappinfobipjava.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeenReport {
    private List<Result> results;

    @Getter
    @Setter
    @RequiredArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
        private String messageId;
        private String from;
        private String to;
        private String sentAt;
        private String seenAt;
        private String applicationId;
        private String entityId;
    }
}
