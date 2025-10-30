package com.sam.friendlens.data.model;

import java.time.Instant;

public class Bookmark extends BaseModel {
    private String markerId;
    private String postId;

    public Bookmark(String id, Instant createdAt, Instant updatedAt, String markerId, String postId) {
        super(id, createdAt, updatedAt);
        this.markerId = markerId;
        this.postId = postId;
    }

    public String getMarkerId() {
        return markerId;
    }

    public void setMarkerId(String markerId) {
        this.markerId = markerId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
