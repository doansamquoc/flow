package com.sam.friendlens.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.sam.friendlens.R;
import com.sam.friendlens.data.model.User;

import java.util.List;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder> {
    private final List<User> friendList;

    public FriendsAdapter(List<User> friends) {
        this.friendList = friends;
    }

    @NonNull
    @Override
    public FriendsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post_user, parent, false);
        return new FriendsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendsViewHolder holder, int position) {
        holder.bind(friendList.get(position));
    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }


    public static class FriendsViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView avatar;

        public FriendsViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar_image_view);
        }

        public void bind(User friend) {
            Glide.with(avatar.getContext())
                    .load(friend.getPhotoUrl())
                    .placeholder(R.drawable.one)
                    .into(avatar);

        }
    }
}
