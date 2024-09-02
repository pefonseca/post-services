package com.blog.security.post.services.api.rest.dto.request;

import com.blog.security.post.services.domain.model.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDTO {

    private String content;
    private Long userId;

    public Post toEntity() {
        return Post.builder()
                .content(this.content)
                .userId(this.userId)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

}
