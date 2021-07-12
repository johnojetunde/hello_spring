package com.shegoestech.hello_spring.services.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("shegoestech")
@Service
public class SheGoesTechEngineers implements ProfileInterface {
    @Override
    public String profileName() {
        return "shegoestech";
    }
}
