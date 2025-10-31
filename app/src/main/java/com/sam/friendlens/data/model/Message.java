package com.sam.friendlens.data.model;

import com.google.firebase.Timestamp;

import java.time.Instant;

public class Message extends BaseModel {
    private String conversationId;
    private String senderId;
    private String text;
    private boolean isRead;
    private Timestamp readAt;

    public Message(String id, Instant createdAt, Instant updatedAt, String conversationId, String senderId, String text, boolean isRead, Timestamp readAt) {
        super(id, createdAt, updatedAt);
        this.conversationId = conversationId;
        this.senderId = senderId;
        this.text = text;
        this.isRead = isRead;
        this.readAt = readAt;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public Timestamp getReadAt() {
        return readAt;
    }

    public void setReadAt(Timestamp readAt) {
        this.readAt = readAt;
    }
}
