package com.hexaware.main;

import com.hexaware.dao.IVirtualArtGallery;
import com.hexaware.dao.VirtualArtGalleryServiceImpl;
import com.hexaware.entity.Artwork;
import com.hexaware.exception.ArtWorkNotFoundException;
import com.hexaware.util.DBConnUtil;
import com.hexaware.util.DBPropertyUtil;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        // Load connection properties from "db.properties" (place this file in your project root)
        String connectionString = DBPropertyUtil.getPropertyString("C:\\Users\\Mayuresh\\OneDrive\\Desktop\\Hexaware Training\\Case Study Development\\src\\db.properties");
        Connection connection = DBConnUtil.getConnection(connectionString);

        IVirtualArtGallery artGalleryService = new VirtualArtGalleryServiceImpl(connection);
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nVirtual Art Gallery Menu:");
            System.out.println("1. Add Artwork");
            System.out.println("2. Update Artwork");
            System.out.println("3. Remove Artwork");
            System.out.println("4. Get Artwork By ID");
            System.out.println("5. Search Artworks");
            System.out.println("6. Add Artwork to Favorites");
            System.out.println("7. Remove Artwork from Favorites");
            System.out.println("8. Get User Favorite Artworks");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch(choice) {
                case 1:
                    // Add Artwork
                    System.out.print("Enter Artwork ID: ");
                    int addId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Creation Date (YYYY-MM-DD): ");
                    String creationDate = scanner.nextLine();
                    System.out.print("Enter Medium: ");
                    String medium = scanner.nextLine();
                    System.out.print("Enter Image URL: ");
                    String imageURL = scanner.nextLine();
                    System.out.print("Enter Artist ID: ");
                    int artistId = Integer.parseInt(scanner.nextLine());
                    Artwork artwork = new Artwork(addId, title, description, creationDate, medium, imageURL, artistId);
                    if(artGalleryService.addArtwork(artwork)) {
                        System.out.println("Artwork added successfully.");
                    } else {
                        System.out.println("Failed to add artwork.");
                    }
                    break;
                case 2:
                    // Update Artwork
                    System.out.print("Enter Artwork ID to update: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new Description: ");
                    String newDesc = scanner.nextLine();
                    System.out.print("Enter new Creation Date (YYYY-MM-DD): ");
                    String newDate = scanner.nextLine();
                    System.out.print("Enter new Medium: ");
                    String newMedium = scanner.nextLine();
                    System.out.print("Enter new Image URL: ");
                    String newImageURL = scanner.nextLine();
                    System.out.print("Enter new Artist ID: ");
                    int newArtistId = Integer.parseInt(scanner.nextLine());
                    Artwork updateArtwork = new Artwork(updateId, newTitle, newDesc, newDate, newMedium, newImageURL, newArtistId);
                    if(artGalleryService.updateArtwork(updateArtwork)) {
                        System.out.println("Artwork updated successfully.");
                    } else {
                        System.out.println("Failed to update artwork.");
                    }
                    break;
                case 3:
                    // Remove Artwork
                    System.out.print("Enter Artwork ID to remove: ");
                    int removeId = Integer.parseInt(scanner.nextLine());
                    if(artGalleryService.removeArtwork(removeId)) {
                        System.out.println("Artwork removed successfully.");
                    } else {
                        System.out.println("Failed to remove artwork.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Artwork ID: ");
                    int getId = Integer.parseInt(scanner.nextLine());
                    try {
                        Artwork foundArtwork = artGalleryService.getArtworkById(getId);
                        System.out.println("Artwork Details:");
                        System.out.println("ID: " + foundArtwork.getArtworkId());
                        System.out.println("Title: " + foundArtwork.getTitle());
                        System.out.println("Description: " + foundArtwork.getDescription());
                        System.out.println("Creation Date: " + foundArtwork.getCreationDate());
                        System.out.println("Medium: " + foundArtwork.getMedium());
                        System.out.println("Image URL: " + foundArtwork.getImageURL());
                        System.out.println("Artist ID: " + foundArtwork.getArtistId());
                    } catch(ArtWorkNotFoundException e) {
                        System.out.println("Artwork not found.");
                    }
                    break;
                case 5:
                    // Search Artworks
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    List<Artwork> artworks = artGalleryService.searchArtworks(keyword);
                    if(artworks.isEmpty()) {
                        System.out.println("No artworks found for keyword: " + keyword);
                    } else {
                        System.out.println("Search Results:");
                        for(Artwork a : artworks) {
                            System.out.println("ID: " + a.getArtworkId() + ", Title: " + a.getTitle()+ ", Title: " + a.getDescription()+ ", Title: " + a.getCreationDate()+ ", Title: " + a.getMedium()+ ", Title: " + a.getImageURL()+ ", Title: " + a.getArtistId());
                        }
                    }
                    break;
                case 6:
                    // Add Artwork to Favorites
                    System.out.print("Enter User ID: ");
                    int favUserId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Artwork ID to add to favorites: ");
                    int favArtworkId = Integer.parseInt(scanner.nextLine());
                    if(artGalleryService.addArtworkToFavorite(favUserId, favArtworkId)) {
                        System.out.println("Artwork added to favorites.");
                    } 
                    break;
                case 7:
                    // Remove Artwork from Favorites
                    System.out.print("Enter User ID: ");
                    int remFavUserId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Artwork ID to remove from favorites: ");
                    int remFavArtworkId = Integer.parseInt(scanner.nextLine());
                    if(artGalleryService.removeArtworkFromFavorite(remFavUserId, remFavArtworkId)) {
                        System.out.println("Artwork removed from favorites.");
                    } else {
                        System.out.println("Failed to remove artwork from favorites.");
                    }
                    break;
                case 8:
                    // Get User Favorite Artworks
                    System.out.print("Enter User ID: ");
                    int userIdFav = Integer.parseInt(scanner.nextLine());
                    List<Artwork> favArtworks = artGalleryService.getUserFavoriteArtworks(userIdFav);
                    if(favArtworks.isEmpty()) {
                        System.out.println("No favorite artworks found for user.");
                    } else {
                        System.out.println("Favorite Artworks:");
                        for(Artwork a : favArtworks) {
                            System.out.println("ID: " + a.getArtworkId() + ", Title: " + a.getTitle());
                        }
                    }
                    break;
                case 9:
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while(choice != 9);
        scanner.close();
    }
}
