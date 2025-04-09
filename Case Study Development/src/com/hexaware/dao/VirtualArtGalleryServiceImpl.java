package com.hexaware.dao;

import com.hexaware.entity.Artwork;
import com.hexaware.exception.ArtWorkNotFoundException;
import com.hexaware.exception.UserNotFoundException;
import com.hexaware.util.DBConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class VirtualArtGalleryServiceImpl implements IVirtualArtGallery {
    private Connection connection;

    public VirtualArtGalleryServiceImpl(Connection connection) {
        this.connection = connection;
    }

    // Artwork Management

    @Override
    public boolean addArtwork(Artwork artwork) {
        String sql = "INSERT INTO artwork (artwork_id, title, description, creation_date, medium, image_url, artist_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, artwork.getArtworkId());
            ps.setString(2, artwork.getTitle());
            ps.setString(3, artwork.getDescription());
            ps.setString(4, artwork.getCreationDate());
            ps.setString(5, artwork.getMedium());
            ps.setString(6, artwork.getImageURL());
            ps.setInt(7, artwork.getArtistId());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateArtwork(Artwork artwork) {
        String sql = "UPDATE artwork SET title=?, description=?, creation_date=?, medium=?, image_url=?, artist_id=? WHERE artwork_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, artwork.getTitle());
            ps.setString(2, artwork.getDescription());
            ps.setString(3, artwork.getCreationDate());
            ps.setString(4, artwork.getMedium());
            ps.setString(5, artwork.getImageURL());
            ps.setInt(6, artwork.getArtistId());
            ps.setInt(7, artwork.getArtworkId());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeArtwork(int artworkId) {
        String sql = "DELETE FROM artwork WHERE artwork_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, artworkId);
            int rows = ps.executeUpdate();
            if(rows == 0) {
                throw new ArtWorkNotFoundException("Artwork with ID " + artworkId + " not found.");
            }
            return rows > 0;
        } catch(SQLException | ArtWorkNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Artwork getArtworkById(int artworkId) throws ArtWorkNotFoundException {
        String sql = "SELECT * FROM artwork WHERE artwork_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, artworkId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Artwork artwork = new Artwork();
                artwork.setArtworkId(rs.getInt("artwork_id"));
                artwork.setTitle(rs.getString("title"));
                artwork.setDescription(rs.getString("description"));
                artwork.setCreationDate(rs.getString("creation_date"));
                artwork.setMedium(rs.getString("medium"));
                artwork.setImageURL(rs.getString("image_url"));
                artwork.setArtistId(rs.getInt("artist_id"));
                return artwork;
            } else {
                throw new ArtWorkNotFoundException("Artwork with ID " + artworkId + " not found.");
            }
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<Artwork> searchArtworks(String keyword) {
        List<Artwork> artworks = new ArrayList<>();
        String sql = "SELECT * FROM artwork WHERE title LIKE ? OR description LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            String query = "%" + keyword + "%";
            ps.setString(1, query);
            ps.setString(2, query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Artwork artwork = new Artwork();
                artwork.setArtworkId(rs.getInt("artwork_id"));
                artwork.setTitle(rs.getString("title"));
                artwork.setDescription(rs.getString("description"));
                artwork.setCreationDate(rs.getString("creation_date"));
                artwork.setMedium(rs.getString("medium"));
                artwork.setImageURL(rs.getString("image_url"));
                artwork.setArtistId(rs.getInt("artist_id"));
                artworks.add(artwork);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return artworks;
    }

    // User Favorites

    @Override
    public boolean addArtworkToFavorite(int userId, int artworkId) {
        String sql = "INSERT INTO user_favorite_artwork (user_id, artwork_id) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, artworkId);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch(SQLIntegrityConstraintViolationException e) {
            System.out.println("Failed to add artwork to favorites. The user with ID " + userId + " does not exist.");
            return false;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeArtworkFromFavorite(int userId, int artworkId) {
        String sql = "DELETE FROM user_favorite_artwork WHERE user_id=? AND artwork_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, artworkId);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Artwork> getUserFavoriteArtworks(int userId) {
        List<Artwork> artworks = new ArrayList<>();
        String sql = "SELECT a.* FROM artwork a JOIN user_favorite_artwork ufa ON a.artwork_id = ufa.artwork_id WHERE ufa.user_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Artwork artwork = new Artwork();
                artwork.setArtworkId(rs.getInt("artwork_id"));
                artwork.setTitle(rs.getString("title"));
                artwork.setDescription(rs.getString("description"));
                artwork.setCreationDate(rs.getString("creation_date"));
                artwork.setMedium(rs.getString("medium"));
                artwork.setImageURL(rs.getString("image_url"));
                artwork.setArtistId(rs.getInt("artist_id"));
                artworks.add(artwork);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return artworks;
    }
}
