package com.ely.spring_messager_api.converter;

import com.ely.spring_messager_api.dto.MessagerRequestDto;
import com.ely.spring_messager_api.dto.MessagerResponseDto;
import com.ely.spring_messager_api.dto.RequestToTemplateApiDto;

public class MessagerConverter {

    public static RequestToTemplateApiDto toTemplateApiRequestDto(MessagerRequestDto dto) {
        return new RequestToTemplateApiDto(
                dto.name(),
                dto.title(),
                dto.description(),
                dto.type(),
                dto.template()
        );
    }

    public static MessagerResponseDto toMessagerResponseDto(MessagerRequestDto dto, String template) {
        return new MessagerResponseDto(
                dto.addressee(),
                dto.sender(),
                dto.name(),
                dto.title(),
                dto.description(),
                template
        );
    }
}
