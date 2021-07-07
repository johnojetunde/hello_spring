package com.shegoestech.hello_spring.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShapePrinter {
    private final List<ShapeService> shapeServices;

    public ShapePrinter(List<ShapeService> shapeServices) {
        this.shapeServices = shapeServices;
    }

    public String getShapeName() {
        return shapeServices.stream()
                .map(ShapeService::getName)
                .collect(Collectors.joining("\r\n"));
    }
}
