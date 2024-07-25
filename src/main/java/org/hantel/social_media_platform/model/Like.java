package org.hantel.social_media_platform.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "likes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Like {
    private User user;
    private LocalDateTime createdAt;
    private Post post;
    private Comment comment;
}
