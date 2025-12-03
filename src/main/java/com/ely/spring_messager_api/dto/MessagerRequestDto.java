package com.ely.spring_messager_api.dto;

public record MessagerRequestDto(
        String addressee,
        String name,
        String title,
        String description,
        String type
) {
}
