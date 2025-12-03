package com.ely.spring_messager_api.service;

import com.ely.spring_messager_api.converter.RequestsConverter;
import com.ely.spring_messager_api.dto.MessagerRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class MessagerService {

    private final RestClient restClient = RestClient.create();
    String baseUri = "http://localhost:3030/templates";

    public String handleMessagerRequest(MessagerRequestDto data) {

        return restClient
                .post()
                .uri(baseUri)
                .body(RequestsConverter.fromMessagerRequestDtoToTemplateApiRequestDto(data))
                .retrieve()
                .body(String.class);
    }
}
