package org.hantel.social_media_platform.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Post extends UuidIdentifiedDocument {
    private String content;
    private User user;
    private LocalDateTime createdAt;
    @Builder.Default
    @DBRef(lazy = true)
    private List<Comment> comments = new ArrayList<>();
    @Builder.Default
    @DBRef(lazy = true)
    private List<Like> likes = new ArrayList<>();

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
