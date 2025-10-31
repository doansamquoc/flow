package com.sam.friendlens.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.sam.friendlens.R;
import com.sam.friendlens.data.model.Media;
import com.sam.friendlens.data.model.Post;
import com.sam.friendlens.data.model.PostDisplay;
import com.sam.friendlens.data.model.User;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private final List<PostDisplay> postList;

    public PostAdapter(List<PostDisplay> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.bindData(postList.get(position));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView displayName, timestamp, location, caption;
        ImageView photo;
        MaterialButton likeButton, messageButton, saveButton;

        public PostViewHolder(View itemView) {
            super(itemView);
            displayName = itemView.findViewById(R.id.display_name_text_view);
            timestamp = itemView.findViewById(R.id.timestamp_text_view);
            caption = itemView.findViewById(R.id.caption_text_view);
            photo = itemView.findViewById(R.id.post_image_view);
//            likeButton = itemView.findViewById(R.id.like_button);
//            messageButton = itemView.findViewById(R.id.comment_button);
//            saveButton = itemView.findViewById(R.id.share_button);
        }

        public void bindData(@NonNull PostDisplay postDisplay) {
            User creator = postDisplay.getCreator();
            Post post = postDisplay.getPost();
            Media media = postDisplay.getMedia();

            assert post != null;
            displayName.setText(creator.getDisplayName());
            caption.setText(post.getCaption());
            timestamp.setText(String.valueOf(post.getCreatedAt().getNano()));
//            likeButton.setText(String.valueOf(postDisplay.getLikeCount()));
//            saveButton.setText(String.valueOf(postDisplay.getSaveCount()));


            if (media != null && media.getMediaUrl() != null) {
                Glide.with(itemView.getContext()).load(media.getMediaUrl()).into(photo);
            } else {
                photo.setImageDrawable(null);
            }
//
//            likeButton.setChecked(postDisplay.isLikedByCurrentUser());
//            saveButton.setChecked(postDisplay.isSavedByCurrentUser());
        }
    }
}

