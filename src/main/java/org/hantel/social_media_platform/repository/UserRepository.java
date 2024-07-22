package org.hantel.social_media_platform.repository;

import java.util.UUID;

import org.hantel.social_media_platform.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, UUID>{

}
