package com.blog.security.post.services.domain.producer;

import com.blog.security.post.services.domain.model.dto.AuditMessageDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuditLogRequestProducer {

    @Autowired private AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void integration(AuditMessageDTO auditMessageDTO) {
        try {
            amqpTemplate.convertAndSend(
                    "audit-log-request-exchange",
                    "audit-log-request-rout-key",
                    objectMapper.writeValueAsString(auditMessageDTO)
            );
        } catch (JsonProcessingException e) {
            log.error("Ocorreu um erro ao integrar com a aplicação de auditoria: {}", e.getMessage());
        }
    }
}
