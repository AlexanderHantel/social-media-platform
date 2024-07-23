package org.hantel.social_media_platform.repository;

import java.util.UUID;

import org.hantel.social_media_platform.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, UUID> {

}
