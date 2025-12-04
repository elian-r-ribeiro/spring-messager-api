package com.ely.spring_messager_api.dto;

public record MessagerResponseDto(
        String addressee,
        String name,
        String title,
        String description,
        String template
) {
}
