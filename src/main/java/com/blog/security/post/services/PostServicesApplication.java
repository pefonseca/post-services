package com.blog.security.post.services;

import com.blog.security.post.services.infra.feign.UserFeignClient;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableRabbit
@EnableFeignClients(clients = {UserFeignClient.class})
@SpringBootApplication
public class PostServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostServicesApplication.class, args);
    }

}