package com.shegoestech.hello_spring.services;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Order(1)
@Service
public class TriangleService implements ShapeService {
    @Override
    public String getName() {
        return "Triangle";
    }
}
