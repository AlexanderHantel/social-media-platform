package org.hantel.social_media_platform.repository;

import java.util.UUID;

import org.hantel.social_media_platform.model.Like;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LikeRepository extends MongoRepository<Like, UUID> {

}
