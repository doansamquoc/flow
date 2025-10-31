package com.sam.friendlens.data.model;

import com.google.firebase.Timestamp;

import java.time.Instant;

public class Conversation extends BaseModel {
    private String userOneId;
    private String userTwoId;
    private String lastMessage;
    private String lastSenderId;
    private Timestamp lastSentAt;

    public Conversation(String id, Instant createdAt, Instant updatedAt, String userOneId, String userTwoId, String lastMessage, String lastSenderId, Timestamp lastSentAt) {
        super(id, createdAt, updatedAt);
        this.userOneId = userOneId;
        this.userTwoId = userTwoId;
        this.lastMessage = lastMessage;
        this.lastSenderId = lastSenderId;
        this.lastSentAt = lastSentAt;
    }

    public String getUserOneId() {
        return userOneId;
    }

    public void setUserOneId(String userOneId) {
        this.userOneId = userOneId;
    }

    public String getUserTwoId() {
        return userTwoId;
    }

    public void setUserTwoId(String userTwoId) {
        this.userTwoId = userTwoId;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getLastSenderId() {
        return lastSenderId;
    }

    public void setLastSenderId(String lastSenderId) {
        this.lastSenderId = lastSenderId;
    }

    public Timestamp getLastSentAt() {
        return lastSentAt;
    }

    public void setLastSentAt(Timestamp lastSentAt) {
        this.lastSentAt = lastSentAt;
    }
}
