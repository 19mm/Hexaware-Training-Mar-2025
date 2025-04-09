package com.hexaware.entity;

public class Artwork {
    private int artworkId;
    private String title;
    private String description;
    private String creationDate;
    private String medium;
    private String imageURL;
    private int artistId; // Foreign key to Artist

    //Default Constructor
    public Artwork() { }

    //Parameterised Constructor
    public Artwork(int artworkId, String title, String description, String creationDate, String medium, String imageURL, int artistId) {
        this.artworkId = artworkId;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.medium = medium;
        this.imageURL = imageURL;
        this.artistId = artistId;
    }

    // Getters and setters
    public int getArtworkId() {
        return artworkId;
    }
    public void setArtworkId(int artworkId) {
        this.artworkId = artworkId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    public String getMedium() {
        return medium;
    }
    public void setMedium(String medium) {
        this.medium = medium;
    }
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public int getArtistId() {
        return artistId;
    }
    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
}
