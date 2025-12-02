package com.ely.spring_messager_api.service;

import com.ely.spring_messager_api.dto.MessagerRequestDto;
import com.ely.spring_messager_api.dto.MessagerResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class MessagerService {

    private final RestClient restClient = RestClient.create();
    String baseUri = "http://localhost:3030/templates";

    public MessagerResponseDto handleMessagerRequest(MessagerRequestDto data) {
        return restClient
                .post()
                .uri(baseUri)
                .body(data)
                .retrieve()
                .body(MessagerResponseDto.class);
    }
}
