package org.hantel.social_media_platform.repository;

import java.util.UUID;

import org.hantel.social_media_platform.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, UUID> {

}
