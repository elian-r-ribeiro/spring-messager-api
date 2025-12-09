package com.ely.spring_messager_api.service;

import com.ely.spring_messager_api.configuration.RabbitConfig;
import com.ely.spring_messager_api.dto.MessagerResponseDto;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessagerConsumer {

    private final JavaMailSender mailSender;

    @RabbitListener(queues = RabbitConfig.QUEUE_EMAIL)
    public void receiveMessage(MessagerResponseDto data) {

        try {
            MimeMessage mime = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mime, true, "UTF-8");

            helper.setTo(data.addressee());
            helper.setFrom(data.sender());
            helper.setSubject("Mensagem automática");
            helper.setText(data.template(), true); // HTML = true

            mailSender.send(mime);

            System.out.println("Email enviado para: " + data.addressee());

        } catch (Exception e) {
            System.err.println("Erro ao enviar email: " + e.getMessage());
        }
    }
}
