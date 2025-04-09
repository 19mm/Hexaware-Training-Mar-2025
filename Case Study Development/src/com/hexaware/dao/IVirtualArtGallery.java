package com.hexaware.dao;

import com.hexaware.entity.Artwork;
import java.util.List;
import com.hexaware.exception.*;

public interface IVirtualArtGallery {
    // Artwork Management
    boolean addArtwork(Artwork artwork);
    boolean updateArtwork(Artwork artwork);
    boolean removeArtwork(int artworkId);
    Artwork getArtworkById(int artworkId) throws ArtWorkNotFoundException;
    List<Artwork> searchArtworks(String keyword);

    // User Favorites
    boolean addArtworkToFavorite(int userId, int artworkId);
    boolean removeArtworkFromFavorite(int userId, int artworkId);
    List<Artwork> getUserFavoriteArtworks(int userId);
}
