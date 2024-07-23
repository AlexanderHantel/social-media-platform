package org.hantel.social_media_platform.service;

import java.util.UUID;

import org.hantel.social_media_platform.model.Comment;
import org.hantel.social_media_platform.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    
    public Comment save(Comment comment) {
        return commentRepository.insert(comment);
    }
    
    public Comment findById(UUID id) {
        return commentRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Can't find user by id = {}", id.toString())));
    }
}
