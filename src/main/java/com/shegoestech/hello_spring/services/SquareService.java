package com.shegoestech.hello_spring.services;

import org.springframework.stereotype.Service;

@Service
public class SquareService implements ShapeService {
    @Override
    public String getName() {
        return "Square";
    }
}
