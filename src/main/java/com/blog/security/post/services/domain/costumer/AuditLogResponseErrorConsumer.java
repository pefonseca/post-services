package com.blog.security.post.services.domain.costumer;

import com.blog.security.post.services.domain.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class AuditLogResponseErrorConsumer {

    private final PostService postService;

    @RabbitListener(queues = {"audit-log-response-error-queue"})
    public void receive(@Payload Message message) {
        System.out.println("Message " + message + " " + LocalDateTime.now());
        String payload = String.valueOf(message.getPayload());

        postService.errorAuditLog(payload);
    }
}
