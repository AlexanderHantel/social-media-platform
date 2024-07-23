package org.hantel.social_media_platform.model;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "users")
@CompoundIndexes({
    @CompoundIndex(name = "username_email",
                   def ="{'username': 1, 'email': 1}"),
    @CompoundIndex(name = "lastName_firstName",
                   def ="{'lastName': 1, 'firstName': 1}")
})
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper=true)
public class User extends UuidIdentifiedDocument {
    
    @Indexed(direction = IndexDirection.ASCENDING)
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private List<UUID> following;
    private List<UUID> followers;
    private List<Comment> comments;
    
    @Transient
    private String password;
    
    public User(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
