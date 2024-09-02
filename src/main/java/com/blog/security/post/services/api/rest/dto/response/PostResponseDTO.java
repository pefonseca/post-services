package com.blog.security.post.services.api.rest.dto.response;

import com.blog.security.post.services.infra.feign.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDTO {

    private Long id;
    private String content;
    private UserResponse userResponse;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

}
