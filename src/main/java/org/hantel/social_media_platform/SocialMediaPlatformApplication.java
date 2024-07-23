package org.hantel.social_media_platform;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hantel.social_media_platform.model.Comment;
import org.hantel.social_media_platform.model.User;
import org.hantel.social_media_platform.service.CommentService;
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
    private final CommentService commentService;
    
    @Autowired
    public SocialMediaPlatformApplication(UserService userService, CommentService commentService) {
        this.userService = userService;
        this.commentService = commentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SocialMediaPlatformApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        User user = new User();
//        user.setUsername("max12345");
//        user.setFirstName("Max");
//        user.setLastName("Jackson");
//        user.setEmail("max_jackson@mail.com");
//        
//        userService.save(user);
//        
//        LOGGER.info("\nUser after save: {}", user.toString());
//        
//        UUID id = user.getId();
//        User persistedUser = userService.findById(id);
//        LOGGER.info("\nRetrieved User: {}", persistedUser.toString());
//        
//        Comment comment = new Comment(user, "My comment", LocalDateTime.now());
//        commentService.save(comment);
//        
//        LOGGER.info("\nComment after save: {}", comment.toString());
//        
//        User userWithComments = userService.findById(id);
//        LOGGER.info("\nRetrieved User with comments: {}", userWithComments.toString());
        
        Comment comment = commentService.findById(UUID.fromString("571ab2c6-c296-4522-98c3-2ca26c43e2d6"));
        LOGGER.info("\nRetrieved Comment: {}", comment.toString());
        
        User persistedUser = userService.findById(UUID.fromString("9968dc82-8dbd-42a0-b144-2a64d3925071"));
        LOGGER.info("\nRetrieved User: {}", persistedUser.toString());
    }

}
