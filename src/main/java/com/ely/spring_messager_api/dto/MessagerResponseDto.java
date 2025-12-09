package com.ely.spring_messager_api.dto;

import java.io.Serializable;

public record MessagerResponseDto(
        String addressee,
        String sender,
        String name,
        String title,
        String description,
        String template
) implements Serializable {
}
