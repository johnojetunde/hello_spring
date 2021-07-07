package com.shegoestech.hello_spring.repository;

import org.springframework.stereotype.Component;

@Component
public class ShoutService {
    public String shout() {
        return "Shout";
    }
}
