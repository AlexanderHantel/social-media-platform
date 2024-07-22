package org.hantel.social_media_platform.document;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
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

@NoArgsConstructor
@Document(collection = "users")
@CompoundIndexes({
    @CompoundIndex(name = "username_email",
                   def ="{'username': 1, 'email': 1}"),
    @CompoundIndex(name = "lastName_firstName",
                   def ="{'lastName': 1, 'firstName': 1}")
})
public class User extends UuidIdentifiedDocument {
    
    @Getter
    @Setter
    @Indexed(direction = IndexDirection.ASCENDING)
    private String username;
    
    @Getter
    @Setter
    private String firstName;
    
    @Getter
    @Setter
    private String lastName;
    
    @Getter
    @Setter
    private String email;
    
    @Getter
    @Setter
    @Transient
    private String password;
    
    @Getter
    private List<UUID> following;
    
    @Getter
    private List<UUID> followers;
    
    public User(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", password=" + password + ", following=" + following + ", followers=" + followers + ", id=" + id
                + "]";
    }
    
    
}
