package org.hantel.social_media_platform.service;

import java.util.UUID;

import org.hantel.social_media_platform.document.User;
import org.hantel.social_media_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User save(User user) {
        return userRepository.insert(user);
    }
    
    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Can't find user by id = {}", id.toString())));
    }

}
