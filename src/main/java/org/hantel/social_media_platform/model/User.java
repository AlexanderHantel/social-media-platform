package org.hantel.social_media_platform.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "users")
@CompoundIndexes({
    @CompoundIndex(name = "username_email",
                   def ="{'username': 1, 'email': 1}"),
    @CompoundIndex(name = "lastName_firstName",
                   def ="{'lastName': 1, 'firstName': 1}")
})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User extends UuidIdentifiedDocument {
    
    @Indexed(direction = IndexDirection.ASCENDING)
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    @Builder.Default
    @DBRef(lazy = true)
    private List<User> following = new ArrayList<>();
    @Builder.Default
    @DBRef(lazy = true)
    private List<User> followers = new ArrayList<>();
    
    @Transient
    private String password;
}
