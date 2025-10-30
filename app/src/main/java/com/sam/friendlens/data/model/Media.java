package com.sam.friendlens.data.model;

import java.time.Instant;

public class Media extends BaseModel {
    private String postId;
    private String mediaType;
    private String mediaUrl;
    private int sequenceOrder;

    public Media(String id, Instant createdAt, Instant updatedAt, String postId, String mediaType, String mediaUrl, int sequenceOrder) {
        super(id, createdAt, updatedAt);
        this.postId = postId;
        this.mediaType = mediaType;
        this.mediaUrl = mediaUrl;
        this.sequenceOrder = sequenceOrder;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public int getSequenceOrder() {
        return sequenceOrder;
    }

    public void setSequenceOrder(int sequenceOrder) {
        this.sequenceOrder = sequenceOrder;
    }
}
