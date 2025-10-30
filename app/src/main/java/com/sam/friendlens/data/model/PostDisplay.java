package com.sam.friendlens.data.model;

public class PostDisplay {
    private Post post;
    private Media media;
    private User creator;
    private int likeCount;
    private boolean likedByCurrentUser;
    private int saveCount;
    private boolean savedByCurrentUser;

    public PostDisplay(Post post, Media media, User creator, int likeCount, boolean likedByCurrentUser, int saveCount, boolean savedByCurrentUser) {
        this.post = post;
        this.media = media;
        this.creator = creator;
        this.likeCount = likeCount;
        this.likedByCurrentUser = likedByCurrentUser;
        this.saveCount = saveCount;
        this.savedByCurrentUser = savedByCurrentUser;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public boolean isLikedByCurrentUser() {
        return likedByCurrentUser;
    }

    public void setLikedByCurrentUser(boolean likedByCurrentUser) {
        this.likedByCurrentUser = likedByCurrentUser;
    }

    public int getSaveCount() {
        return saveCount;
    }

    public void setSaveCount(int saveCount) {
        this.saveCount = saveCount;
    }

    public boolean isSavedByCurrentUser() {
        return savedByCurrentUser;
    }

    public void setSavedByCurrentUser(boolean savedByCurrentUser) {
        this.savedByCurrentUser = savedByCurrentUser;
    }
}
