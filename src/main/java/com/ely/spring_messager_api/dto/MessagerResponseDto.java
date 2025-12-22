package com.ely.spring_messager_api.dto;

import java.io.Serializable;

public record MessagerResponseDto(
        String successMessage,
        String addressee,
        String subject,
        String name,
        String title,
        String description,
        String template
) implements Serializable {
}
