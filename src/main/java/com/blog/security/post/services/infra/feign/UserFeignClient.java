package com.blog.security.post.services.infra.feign;

import com.blog.security.post.services.infra.feign.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "user-client", url = "http://localhost:8081")
public interface UserFeignClient {

    @GetMapping(value = "/api/v1/user/find_by_email", produces = "application/json")
    ResponseEntity<UserResponse> findByEmail(@RequestParam(value = "email") String email);

    @GetMapping(value = "/api/v1/user/{id}", produces = "application/json")
    ResponseEntity<UserResponse> findById(@PathVariable(value = "id") Long id);

}
