package com.blog.security.post.services.domain.service;

import com.blog.security.post.services.api.rest.dto.request.PostRequestDTO;
import com.blog.security.post.services.api.rest.dto.response.PostResponseDTO;

import java.util.List;

public interface PostService {

    List<PostResponseDTO> findAll();
    PostResponseDTO create(PostRequestDTO requestDTO);
    void errorAuditLog(String payload);
    void successAuditLog(String payload);
}
