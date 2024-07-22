package org.hantel.social_media_platform;

import java.util.UUID;

import org.hantel.social_media_platform.document.User;
import org.hantel.social_media_platform.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialMediaPlatformApplication implements CommandLineRunner {
    public static final Logger LOGGER = LoggerFactory.getLogger(SocialMediaPlatformApplication.class);
    private final UserService userService;
    
    @Autowired
    public SocialMediaPlatformApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SocialMediaPlatformApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("max12345");
        user.setFirstName("Max");
        user.setLastName("Jackson");
        user.setEmail("max_jackson@mail.com");
        
        LOGGER.info("\nUser before save: {}", user.toString());
        
        userService.save(user);
        
        LOGGER.info("\nUser after save: {}", user.toString());
        
        UUID id = user.getId();
        User persistedUser = userService.findById(id);
        LOGGER.info("\nRetrieved User: {}", persistedUser.toString());
    }

}
