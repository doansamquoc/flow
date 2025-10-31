package com.sam.friendlens.data.dto;

import com.sam.friendlens.data.model.Conversation;
import com.sam.friendlens.data.model.User;

public class ConversationItem {
    private Conversation conversation;
    private User otherUser;

    public ConversationItem(Conversation conversation, User otherUser) {
        this.conversation = conversation;
        this.otherUser = otherUser;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public User getOtherUser() {
        return otherUser;
    }

    public void setOtherUser(User otherUser) {
        this.otherUser = otherUser;
    }
}
