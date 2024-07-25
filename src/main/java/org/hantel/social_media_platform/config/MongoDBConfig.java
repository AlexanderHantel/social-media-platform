package org.hantel.social_media_platform.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.hantel.social_media_platform.model.Comment;
import org.hantel.social_media_platform.model.Like;
import org.hantel.social_media_platform.model.Post;
import org.hantel.social_media_platform.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDBConfig {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Bean
    CommandLineRunner initData() {
        return args -> {

            // Cleanup existing collections
            mongoTemplate.dropCollection(User.class);
            mongoTemplate.dropCollection(Post.class);
            mongoTemplate.dropCollection(Comment.class);
            mongoTemplate.dropCollection(Like.class);
            
        };
    }


}
