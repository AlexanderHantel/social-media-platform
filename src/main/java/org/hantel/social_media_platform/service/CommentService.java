package org.hantel.social_media_platform.service;

import java.util.UUID;

import org.hantel.social_media_platform.model.Comment;
import org.hantel.social_media_platform.model.Post;
import org.hantel.social_media_platform.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostService postService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
    }
    
    public void create(Comment comment) {
        commentRepository.insert(comment);
        
        Post post = comment.getPost();
        post.addComment(comment);
        
        postService.update(post);
        
    }
    
    public Comment findById(UUID id) {
        return commentRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Can't find comment by id = {}", id.toString())));
    }
}
