package com.ely.spring_messager_api.controller;

import com.ely.spring_messager_api.dto.MessagerRequestDto;
import com.ely.spring_messager_api.dto.MessagerResponseDto;
import com.ely.spring_messager_api.service.MessagerService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messager")
@AllArgsConstructor
public class MessagerController {

    private MessagerService messagerService;

    @PostMapping(version = "1.0")
    public ResponseEntity<MessagerResponseDto> MessageRequest(@RequestBody MessagerRequestDto data) {
        return ResponseEntity.ok(messagerService.handleMessagerRequest(data));
    }
}
