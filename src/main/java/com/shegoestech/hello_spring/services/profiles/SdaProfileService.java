package com.shegoestech.hello_spring.services.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("sda")
@Service
public class SdaProfileService implements ProfileInterface {
    @Override
    public String profileName() {
        return "SDA Profile Service";
    }
}
