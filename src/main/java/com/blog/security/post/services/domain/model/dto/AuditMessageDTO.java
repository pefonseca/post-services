package com.blog.security.post.services.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditMessageDTO implements Serializable {
    private static final Long serialVersionUID = 1L;

    private String entityName;
    private Long entityId;
    private String action;
    private String performedBy;
    private String details;

}
