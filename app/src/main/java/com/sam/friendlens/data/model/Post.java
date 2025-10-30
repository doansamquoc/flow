package com.sam.friendlens.data.model;

import java.time.Instant;

public class Post extends BaseModel {
    private String creatorId;
    private String location;
    private String caption;

    public Post(String id, Instant createdAt, Instant updatedAt, String creatorId, String location, String caption) {
        super(id, createdAt, updatedAt);
        this.creatorId = creatorId;
        this.location = location;
        this.caption = caption;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
