package com.blog.security.post.services.api.rest.controller;

import com.blog.security.post.services.api.rest.dto.request.PostRequestDTO;
import com.blog.security.post.services.api.rest.dto.response.PostResponseDTO;
import com.blog.security.post.services.domain.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> getTimeLine() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<PostResponseDTO> create(@Valid @RequestBody PostRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(requestDTO));
    }

}
