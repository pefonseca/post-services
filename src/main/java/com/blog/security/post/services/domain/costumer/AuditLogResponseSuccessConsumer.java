package com.blog.security.post.services.domain.costumer;

import com.blog.security.post.services.domain.service.PostService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AuditLogResponseSuccessConsumer {

    @Autowired private PostService postService;

    @RabbitListener(queues = {"audit-log-response-success-queue"})
    public void receive(@Payload Message message) {
        String payload = String.valueOf(message.getPayload());
        postService.successAuditLog(payload);
    }

}
