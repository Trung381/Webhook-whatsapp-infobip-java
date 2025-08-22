package com.mobile.be.webhookwhatsappinfobipjava.service.whatsapp_infobip_webhook;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.mobile.be.webhookwhatsappinfobipjava.dto.request.MessageStatusCallback;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class WhatsappInfobipServiceImpl implements WhatsappInfobipService {

    @Async
    @Override
    public void handleInboundCallback(Object request) {
        log.info("INBOUND: " + request);
        //todo: handle
    }

    @Async
    @Override
    public void handleStatusCallback(Object request) {
        log.info(request);

        //todo: Phân biệt được là class nào
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));

        MessageStatusCallback req = mapper.convertValue(request, MessageStatusCallback.class);
        List<MessageStatusCallback.Result> messages = req.getResults();

        boolean shouldSave = false;
        for (MessageStatusCallback.Result msg : messages) {
            //todo: update shouldSave hợp lý tránh spam DB
            if (msg.getSeenAt() == null) {
                //todo: status = DELIVERED
                log.warn("DELIVERED");
            } else {
                //todo: status = SEEN
                log.warn("SEEN");
            }
        }

        if (shouldSave) {
            //todo: save db
        }
    }
}
