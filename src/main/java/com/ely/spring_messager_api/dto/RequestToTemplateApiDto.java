package com.ely.spring_messager_api.dto;

public record RequestToTemplateApiDto(
        String name,
        String title,
        String description,
        String type
) {
}
