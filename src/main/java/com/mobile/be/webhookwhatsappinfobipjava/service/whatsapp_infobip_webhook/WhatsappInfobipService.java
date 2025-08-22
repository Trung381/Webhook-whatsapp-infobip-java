package com.mobile.be.webhookwhatsappinfobipjava.service.whatsapp_infobip_webhook;

public interface WhatsappInfobipService {
    void handleInboundCallback(Object request);

    void handleStatusCallback(Object request);
}
