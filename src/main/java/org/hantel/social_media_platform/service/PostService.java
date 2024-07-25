package org.hantel.social_media_platform.service;

import java.util.UUID;

import org.hantel.social_media_platform.model.Post;
import org.hantel.social_media_platform.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    @Autowired
    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }
    
    public void create(Post post) {
        postRepository.insert(post);
    }
    
    public void update(Post post) {
        postRepository.save(post);
    }
    
    public Post findById(UUID id) {
        return postRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Can't find post by id = {}", id.toString())));
    }

}
