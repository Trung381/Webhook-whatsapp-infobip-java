package com.mobile.be.webhookwhatsappinfobipjava.controller;

import com.mobile.be.webhookwhatsappinfobipjava.service.whatsapp_infobip_webhook.WhatsappInfobipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/")
@RequiredArgsConstructor
public class WhatsappInfobipWebhook {
    private final WhatsappInfobipService whatsappInfobipService;

    @PostMapping("v1/whatsapp/webhook/inbound")
    public ResponseEntity<Object> inboundCallback(@RequestBody Object request) {
        whatsappInfobipService.handleInboundCallback(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("v1/whatsapp/webhook/status")
    public ResponseEntity<Object> statusCallback(@RequestBody Object request) {
        whatsappInfobipService.handleStatusCallback(request);
        return ResponseEntity.ok().build();
    }
}
