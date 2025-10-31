package com.sam.friendlens.ui.dashboard.message;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.sam.friendlens.R;
import com.sam.friendlens.data.dto.ConversationItem;
import com.sam.friendlens.data.model.Conversation;
import com.sam.friendlens.data.model.User;

import java.text.DateFormat;
import java.util.List;

public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.ConversationViewHolder> {

    private final List<ConversationItem> conversationItems;

    public ConversationAdapter(List<ConversationItem> conversationItems) {
        this.conversationItems = conversationItems;
    }

    @NonNull
    @Override
    public ConversationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conversation, parent, false);
        return new ConversationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConversationViewHolder holder, int position) {
        holder.bind(conversationItems.get(position));
    }

    @Override
    public int getItemCount() {
        return conversationItems.size();
    }

    public static class ConversationViewHolder extends RecyclerView.ViewHolder {
        private ShapeableImageView avatarImageView;
        private TextView displayNameTextView;
        private TextView statusTextView;
        private TextView lastMessageTextView;
        private TextView lastSentAtTextView;

        public ConversationViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarImageView = itemView.findViewById(R.id.avatar_image_view);
            displayNameTextView = itemView.findViewById(R.id.display_name_text_view);
            statusTextView = itemView.findViewById(R.id.status_text_view);
            lastMessageTextView = itemView.findViewById(R.id.last_message_text_view);
            lastSentAtTextView = itemView.findViewById(R.id.last_message_timestamp_text_view);
        }

        public void bind(ConversationItem item) {
            User otherUser = item.getOtherUser();
            Conversation conversation = item.getConversation();

            displayNameTextView.setText(otherUser.getDisplayName());
            lastMessageTextView.setText(
                    conversation.getLastSenderId().equals(otherUser.getId())
                            ? "You: " + conversation.getLastMessage()
                            : otherUser.getDisplayName() + ": " + conversation.getLastMessage()
            );

            lastSentAtTextView.setText(
                    DateFormat.getTimeInstance(DateFormat.SHORT)
                            .format(conversation.getLastSentAt().toDate())
            );

            Glide.with(itemView.getContext())
                    .load(otherUser.getPhotoUrl())
                    .placeholder(R.drawable.two)
                    .into(avatarImageView);
        }

    }
}
