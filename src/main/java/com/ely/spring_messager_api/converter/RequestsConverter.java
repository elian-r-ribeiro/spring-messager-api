package com.ely.spring_messager_api.converter;

import com.ely.spring_messager_api.dto.MessagerRequestDto;
import com.ely.spring_messager_api.dto.RequestToTemplateApiDto;

public class RequestsConverter {

    public static RequestToTemplateApiDto fromMessagerRequestDtoToTemplateApiRequestDto(MessagerRequestDto dto) {
        return new RequestToTemplateApiDto(
                dto.name(),
                dto.title(),
                dto.description(),
                dto.type()
        );
    }
}
