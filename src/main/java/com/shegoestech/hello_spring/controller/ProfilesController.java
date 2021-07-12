package com.shegoestech.hello_spring.controller;

import com.shegoestech.hello_spring.services.profiles.ProfileInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
public class ProfilesController {
    private final ProfileInterface profileInterface;

    public ProfilesController(ProfileInterface profileInterface) {
        this.profileInterface = profileInterface;
    }

    @GetMapping
    public String getProfileName() {
        return profileInterface.profileName();
    }
}
