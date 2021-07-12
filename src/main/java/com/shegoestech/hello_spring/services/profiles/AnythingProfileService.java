package com.shegoestech.hello_spring.services.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("default")
@Service
public class AnythingProfileService implements ProfileInterface {
    @Override
    public String profileName() {
        return "Default";
    }
}
