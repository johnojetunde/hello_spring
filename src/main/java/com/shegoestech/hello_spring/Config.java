package com.shegoestech.hello_spring;

import com.shegoestech.hello_spring.repository.StudentDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public StudentDatabase createStudentDatabase() {
        return new StudentDatabase();
    }
}
