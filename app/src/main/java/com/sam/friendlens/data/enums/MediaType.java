package com.sam.friendlens.data.enums;

public enum MediaType {
    VIDEO("Video"), IMAGE("Image");
    private final String name;

    MediaType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
