package com.shegoestech.hello_spring.repository;


import org.springframework.stereotype.Component;

@Component
public class RandomService {
    private final ShoutService shoutService;

    public RandomService(ShoutService shoutService) {
        this.shoutService = shoutService;
    }

    public void shout() {
        shoutService.shout();
    }
}
