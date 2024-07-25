package org.hantel.social_media_platform;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hantel.social_media_platform.model.Comment;
import org.hantel.social_media_platform.model.Like;
import org.hantel.social_media_platform.model.Post;
import org.hantel.social_media_platform.model.User;
import org.hantel.social_media_platform.service.CommentService;
import org.hantel.social_media_platform.service.LikeService;
import org.hantel.social_media_platform.service.PostService;
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
    private final PostService postService;
    private final LikeService likeService;
    
    @Autowired
    public SocialMediaPlatformApplication(UserService userService, 
                                          CommentService commentService,
                                          PostService postService,
                                          LikeService likeService) {
        this.userService = userService;
        this.commentService = commentService;
        this.postService = postService;
        this.likeService = likeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SocialMediaPlatformApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        User user = User.builder().username("max12345").firstName("Max").lastName("Mayers").email("max_mayers@mail.com").build();
        userService.create(user);
        
        User commentedUser = User.builder().username("jack1234").firstName("Jack").lastName("Johnson").email("jack_johnson@mail.com").build();
        userService.create(commentedUser);
        
        User likedUser = User.builder().username("rob1234").firstName("Rob").lastName("Robinson").email("rob_robinson@mail.com").build();
        userService.create(likedUser);
        
        Post post = Post.builder().content("My new post").user(user).createdAt(LocalDateTime.now()).build();
        postService.create(post);
        
        Comment comment = Comment.builder().content("My new comment").user(commentedUser).post(post).createdAt(LocalDateTime.now()).build();
        commentService.create(comment);
        
        Like postLike = Like.builder().post(post).user(likedUser).createdAt(LocalDateTime.now()).build();
        Like commentLike = Like.builder().comment(comment).user(user).createdAt(LocalDateTime.now()).build();
        likeService.save(postLike);
        likeService.save(commentLike);
    }

}
