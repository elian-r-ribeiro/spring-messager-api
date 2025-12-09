package com.ely.spring_messager_api.service;

import com.ely.spring_messager_api.configuration.RabbitConfig;
import com.ely.spring_messager_api.converter.MessagerConverter;
import com.ely.spring_messager_api.dto.MessagerRequestDto;
import com.ely.spring_messager_api.dto.MessagerResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@AllArgsConstructor
public class MessagerProducer {

    private final RestClient restClient = RestClient.create();
    private final RabbitTemplate rabbitTemplate;

    public MessagerResponseDto handleMessagerRequest(MessagerRequestDto data) {

        String sender = "no-reply@messagerapi.com";
        String templatesApiResponse = makeTemplateApiRequest(data);
        MessagerResponseDto messagerResponse = MessagerConverter.toMessagerResponseDto(data, templatesApiResponse);

        sendToQueue(messagerResponse);
        return messagerResponse;
    }

    public void sendToQueue(MessagerResponseDto data) {
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_EMAIL, data);
    }

    private String makeTemplateApiRequest(MessagerRequestDto data) {
        final String baseUri = "http://localhost:3030/templates";

        return restClient
                .post()
                .uri(baseUri)
                .body(MessagerConverter.toTemplateApiRequestDto(data))
                .retrieve()
                .body(String.class);
    }
}
