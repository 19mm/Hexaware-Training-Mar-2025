package com.hexaware.dao;

import com.hexaware.entity.Artwork;
import com.hexaware.exception.ArtWorkNotFoundException;
import com.hexaware.exception.UserNotFoundException;
import com.hexaware.util.DBConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VirtualArtGalleryServiceImpl implements IVirtualArtGallery {
    private Connection connection;

    public VirtualArtGalleryServiceImpl(Connection connection) {
        this.connection = connection;
    }

    // Artwork Management

    @Override
    public boolean addArtwork(Artwork artwork) {
        String sql = "INSERT INTO Artwork (ArtworkID, Title, Description, CreationDate, Medium, ImageURL, ArtistID) VALUES (?, ?, ?, ?, ?, ?, ?)";
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
        String sql = "UPDATE Artwork SET Title=?, Description=?, CreationDate=?, Medium=?, ImageURL=?, ArtistID=? WHERE ArtworkID=?";
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
        String sql = "DELETE FROM Artwork WHERE ArtworkID=?";
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
    public Artwork getArtworkById(int artworkId) {
        String sql = "SELECT * FROM Artwork WHERE ArtworkID=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, artworkId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Artwork artwork = new Artwork();
                artwork.setArtworkId(rs.getInt("ArtworkID"));
                artwork.setTitle(rs.getString("Title"));
                artwork.setDescription(rs.getString("Description"));
                artwork.setCreationDate(rs.getString("CreationDate"));
                artwork.setMedium(rs.getString("Medium"));
                artwork.setImageURL(rs.getString("ImageURL"));
                artwork.setArtistId(rs.getInt("ArtistID"));
                return artwork;
            } else {
                throw new ArtWorkNotFoundException("Artwork with ID " + artworkId + " not found.");
            }
        } catch(SQLException | ArtWorkNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Artwork> searchArtworks(String keyword) {
        List<Artwork> artworks = new ArrayList<>();
        String sql = "SELECT * FROM Artwork WHERE Title LIKE ? OR Description LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            String query = "%" + keyword + "%";
            ps.setString(1, query);
            ps.setString(2, query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Artwork artwork = new Artwork();
                artwork.setArtworkId(rs.getInt("ArtworkID"));
                artwork.setTitle(rs.getString("Title"));
                artwork.setDescription(rs.getString("Description"));
                artwork.setCreationDate(rs.getString("CreationDate"));
                artwork.setMedium(rs.getString("Medium"));
                artwork.setImageURL(rs.getString("ImageURL"));
                artwork.setArtistId(rs.getInt("ArtistID"));
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
        String sql = "INSERT INTO User_Favorite_Artwork (UserID, ArtworkID) VALUES (?, ?)";
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
    public boolean removeArtworkFromFavorite(int userId, int artworkId) {
        String sql = "DELETE FROM User_Favorite_Artwork WHERE UserID=? AND ArtworkID=?";
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
        String sql = "SELECT a.* FROM Artwork a JOIN User_Favorite_Artwork ufa ON a.ArtworkID = ufa.ArtworkID WHERE ufa.UserID=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Artwork artwork = new Artwork();
                artwork.setArtworkId(rs.getInt("ArtworkID"));
                artwork.setTitle(rs.getString("Title"));
                artwork.setDescription(rs.getString("Description"));
                artwork.setCreationDate(rs.getString("CreationDate"));
                artwork.setMedium(rs.getString("Medium"));
                artwork.setImageURL(rs.getString("ImageURL"));
                artwork.setArtistId(rs.getInt("ArtistID"));
                artworks.add(artwork);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return artworks;
    }
}
