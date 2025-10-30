package com.sam.friendlens.ui.auth.data.model;

import java.time.Instant;
import java.time.LocalDate;

public class User {
    private String id;
    private String username;
    private String displayName;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;
    private String emailAddress;
    private String phoneNumber;
    private String avatarUrl;
    private Instant createdAt;
    private Instant updatedAt;

    public User() {
    }

    public User(
            String id,
            String username,
            String displayName,
            LocalDate dateOfBirth,
            String gender,
            String address,
            String emailAddress,
            String phoneNumber,
            String avatarUrl,
            Instant createdAt,
            Instant updatedAt
    ) {
        this.id = id;
        this.username = username;
        this.displayName = displayName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
