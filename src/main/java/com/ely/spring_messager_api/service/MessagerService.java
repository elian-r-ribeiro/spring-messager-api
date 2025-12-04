package com.ely.spring_messager_api.service;

import com.ely.spring_messager_api.converter.MessagerConverter;
import com.ely.spring_messager_api.dto.MessagerRequestDto;
import com.ely.spring_messager_api.dto.MessagerResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class MessagerService {

    private final RestClient restClient = RestClient.create();

    public MessagerResponseDto handleMessagerRequest(MessagerRequestDto data) {

        String templateApiResponse = makeTemplateApiRequest(data);

        return MessagerConverter.toMessagerResponseDto(data, templateApiResponse);
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
