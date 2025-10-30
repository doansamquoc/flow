package com.sam.friendlens.data.model;

import java.time.Instant;

public class User extends BaseModel {
    private String username;
    private String displayName;
    private String photoUrl;
    private String email;
    private String gender;
    private String dateOfBirth;

    public User(String id, Instant createdAt, Instant updatedAt, String username, String displayName, String photoUrl, String email, String gender, String dateOfBirth) {
        super(id, createdAt, updatedAt);
        this.username = username;
        this.displayName = displayName;
        this.photoUrl = photoUrl;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
