package com.hexaware.entity;

public class Gallery {
    private int galleryId;
    private String name;
    private String description;
    private String location;
    private int curator; // Reference to an Artist (curator)
    private String openingHours;

    public Gallery() { }

    public Gallery(int galleryId, String name, String description, String location, int curator, String openingHours) {
        this.galleryId = galleryId;
        this.name = name;
        this.description = description;
        this.location = location;
        this.curator = curator;
        this.openingHours = openingHours;
    }

    // Getters and setters
    public int getGalleryId() {
        return galleryId;
    }
    public void setGalleryId(int galleryId) {
        this.galleryId = galleryId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getCurator() {
        return curator;
    }
    public void setCurator(int curator) {
        this.curator = curator;
    }
    public String getOpeningHours() {
        return openingHours;
    }
    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }
}
