package com.sam.friendlens.data.model;

import java.time.Instant;

public class Like extends BaseModel {
    private String likerId;
    private String postId;

    public Like(String id, Instant createdAt, Instant updatedAt, String likerId, String postId) {
        super(id, createdAt, updatedAt);
        this.likerId = likerId;
        this.postId = postId;
    }

    public String getLikerId() {
        return likerId;
    }

    public void setLikerId(String likerId) {
        this.likerId = likerId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
