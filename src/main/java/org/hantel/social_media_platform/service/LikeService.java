package org.hantel.social_media_platform.service;

import java.util.UUID;

import org.hantel.social_media_platform.model.Like;
import org.hantel.social_media_platform.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LikeService {
    private final LikeRepository likeRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }
    
    public Like save(Like like) {
        return likeRepository.insert(like);
    }
    
    public Like findById(UUID id) {
        return likeRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Can't find like by id = {}", id.toString())));
    }

}
