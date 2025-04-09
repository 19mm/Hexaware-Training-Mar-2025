package com.hexaware.dao;

import com.hexaware.entity.Artwork;
import com.hexaware.exception.ArtWorkNotFoundException;
import com.hexaware.util.DBConnUtil;
import com.hexaware.util.DBPropertyUtil;
import org.junit.jupiter.api.*; // Import JUnit 5 annotations

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*; // Import JUnit 5 assertions

// Indicates the order of test execution (optional but can be helpful)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VirtualArtGalleryServiceImplTest {

    private static IVirtualArtGallery virtualArtGalleryService;
    private static Connection connection;

    @BeforeAll // Runs once before all tests in this class
    static void setUp() {
        // Use properties file for test database if needed, or use development DB
        // Ensure the path is correct for your test environment
        String connectionString = DBPropertyUtil.getPropertyString("src/db.properties"); // Or path to test db.properties
        connection = DBConnUtil.getConnection(connectionString);
        virtualArtGalleryService = new VirtualArtGalleryServiceImpl(connection);
        // Optional: Initialize test database state here (e.g., clear tables, insert base data)
        System.out.println("BeforeAll: Database Connection Established.");
    }

    @AfterAll // Runs once after all tests in this class
    static void tearDown() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("AfterAll: Database Connection Closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @BeforeEach // Runs before each test method
    void init() {
        // Optional: Reset state before each test if needed
        System.out.println("BeforeEach: Test starting...");
    }

    @AfterEach // Runs after each test method
    void cleanup() {
        // Optional: Clean up changes made by a test (e.g., delete added artwork)
        System.out.println("AfterEach: Test finished.");
        // Example cleanup: You might want to remove artwork added during a test
        // Be careful with dependencies between tests if you clean up specific IDs.
    }

    // --- Task 10: Artwork Management Tests [cite: 156, 157] ---

    @Test
    @Order(1) // Execute this test first
    @DisplayName("Test Adding New Artwork")
    void testAddArtwork() {
        // Arrange: Create a new artwork object
        // Using a high ID to avoid clashing with existing sample data [cite: Case_Study.sql]
        Artwork newArtwork = new Artwork(99, "Test Artwork", "Test Desc", "2025-04-08", "Oil Test", "test.jpg", 1);

        // Act: Call the addArtwork method
        boolean result = virtualArtGalleryService.addArtwork(newArtwork);

        // Assert: Check if the artwork was added successfully
        assertTrue(result, "Artwork should be added successfully.");

        // Optional: Verify by fetching the added artwork
        try {
            Artwork fetchedArtwork = virtualArtGalleryService.getArtworkById(99);
            assertNotNull(fetchedArtwork, "Fetched artwork should not be null.");
            assertEquals("Test Artwork", fetchedArtwork.getTitle(), "Fetched artwork title should match.");
        } catch (ArtWorkNotFoundException e) {
            fail("ArtworkNotFoundException was thrown when trying to fetch the newly added artwork.");
        }
    }

    @Test
    @Order(2)
    @DisplayName("Test Updating Artwork Details")
    void testUpdateArtwork() {
        // Arrange: Use the artwork added in the previous test (ID 99) or add one if tests run independently
        // Ensure artwork with ID 99 exists from testAddArtwork or add it here first.
        Artwork updatedArtwork = new Artwork(99, "Updated Title", "Updated Desc", "2025-04-09", "Acrylic Test", "updated.jpg", 2);

        // Act: Call the updateArtwork method
        boolean result = virtualArtGalleryService.updateArtwork(updatedArtwork);

        // Assert: Check if the update was successful
        assertTrue(result, "Artwork should be updated successfully.");

        // Verify: Fetch the artwork and check if details are updated
        try {
            Artwork fetchedArtwork = virtualArtGalleryService.getArtworkById(99);
            assertNotNull(fetchedArtwork);
            assertEquals("Updated Title", fetchedArtwork.getTitle(), "Title should be updated.");
            assertEquals("Updated Desc", fetchedArtwork.getDescription(), "Description should be updated.");
            assertEquals(2, fetchedArtwork.getArtistId(), "Artist ID should be updated.");
        } catch (ArtWorkNotFoundException e) {
            fail("ArtworkNotFoundException was thrown when trying to fetch the updated artwork.");
        }
    }

    @Test
    @Order(3)
    @DisplayName("Test Searching Artworks")
    void testSearchArtworks() {
        // Arrange: Ensure artworks exist that match the search term (e.g., the updated artwork with ID 99)
        String keyword = "Updated"; // Keyword based on the updated artwork

        // Act: Call the searchArtworks method
        List<Artwork> results = virtualArtGalleryService.searchArtworks(keyword);

        // Assert: Check the search results
        assertNotNull(results, "Search results list should not be null.");
        assertFalse(results.isEmpty(), "Search results should not be empty for keyword 'Updated'.");
        // Check if the artwork with ID 99 is in the results
        boolean found = results.stream().anyMatch(art -> art.getArtworkId() == 99 && art.getTitle().contains(keyword));
        assertTrue(found, "The updated artwork (ID 99) should be found.");

        // Test searching for something that doesn't exist
        List<Artwork> emptyResults = virtualArtGalleryService.searchArtworks("NonExistentKeyword123");
        assertNotNull(emptyResults, "Search results list for non-existent keyword should not be null.");
        assertTrue(emptyResults.isEmpty(), "Search results should be empty for a non-existent keyword.");
    }

    @Test
    @Order(4)
    @DisplayName("Test Getting Artwork By Non-Existent ID")
    void testGetArtworkByIdNotFound() {
        // Arrange: Choose an ID that does not exist
        int nonExistentId = 9999;

        // Act & Assert: Check if ArtWorkNotFoundException is thrown [cite: 113, 153]
        assertThrows(ArtWorkNotFoundException.class, () -> {
            virtualArtGalleryService.getArtworkById(nonExistentId);
        }, "ArtWorkNotFoundException should be thrown for a non-existent ID.");
    }


    @Test
    @Order(5) // Execute removal last to avoid affecting other tests
    @DisplayName("Test Removing Artwork")
    void testRemoveArtwork() {
        // Arrange: Use the artwork ID from previous tests (ID 99)
        int artworkIdToRemove = 99;

        // Act: Call the removeArtwork method
        boolean result = virtualArtGalleryService.removeArtwork(artworkIdToRemove);

        // Assert: Check if removal was successful
        assertTrue(result, "Artwork should be removed successfully.");

        // Verify: Try fetching the removed artwork, expect ArtWorkNotFoundException
        assertThrows(ArtWorkNotFoundException.class, () -> {
            virtualArtGalleryService.getArtworkById(artworkIdToRemove);
        }, "ArtWorkNotFoundException should be thrown after removing the artwork.");
    }

     // --- Task 10: User Favorites Tests (Examples) ---

     @Test
     @Order(6)
     @DisplayName("Test Adding Artwork to Favorites")
     void testAddArtworkToFavorite() {
         // Arrange: Use existing user ID and artwork ID from sample data [cite: Case_Study.sql]
         int userId = 1; // User 'artlover123'
         int artworkId = 3; // Artwork 'Guernica' (Assuming it wasn't removed by other tests)
         // Ensure this favourite relationship doesn't already exist before the test runs

         // Act
         boolean result = virtualArtGalleryService.addArtworkToFavorite(userId, artworkId);

         // Assert
         assertTrue(result, "Should successfully add artwork to favorites.");

         // Verify (optional)
         List<Artwork> favs = virtualArtGalleryService.getUserFavoriteArtworks(userId);
         boolean found = favs.stream().anyMatch(art -> art.getArtworkId() == artworkId);
         assertTrue(found, "Artwork ID 3 should be in user 1's favorites list after adding.");
     }

     @Test
     @Order(7)
     @DisplayName("Test Getting User Favorite Artworks")
     void testGetUserFavoriteArtworks() {
         // Arrange: User 1 should have artworks 1, 2 and 3 (from sample data + previous test)
         int userId = 1;

         // Act
         List<Artwork> favArtworks = virtualArtGalleryService.getUserFavoriteArtworks(userId);

         // Assert
         assertNotNull(favArtworks, "Favorite artworks list should not be null.");
         assertFalse(favArtworks.isEmpty(), "User 1 should have favorite artworks.");
         // Check for specific artwork IDs known to be favorites
         assertTrue(favArtworks.stream().anyMatch(a -> a.getArtworkId() == 1), "Favorite list should contain artwork ID 1.");
         assertTrue(favArtworks.stream().anyMatch(a -> a.getArtworkId() == 2), "Favorite list should contain artwork ID 2.");
         assertTrue(favArtworks.stream().anyMatch(a -> a.getArtworkId() == 3), "Favorite list should contain artwork ID 3.");
     }


     @Test
     @Order(8)
     @DisplayName("Test Removing Artwork from Favorites")
      void testRemoveArtworkFromFavorite() {
          // Arrange: Use user ID 1 and artwork ID 3 added in a previous test
          int userId = 1;
          int artworkId = 3;

          // Act
          boolean result = virtualArtGalleryService.removeArtworkFromFavorite(userId, artworkId);

          // Assert
          assertTrue(result, "Should successfully remove artwork from favorites.");

          // Verify
          List<Artwork> favs = virtualArtGalleryService.getUserFavoriteArtworks(userId);
          boolean found = favs.stream().anyMatch(art -> art.getArtworkId() == artworkId);
          assertFalse(found, "Artwork ID 3 should NOT be in user 1's favorites list after removing.");
      }

      // --- Task 10: Gallery Management Tests [cite: 158, 159] (Placeholders) ---
      // Add tests for Gallery Management here once the DAO methods are implemented.
      // @Test
      // void testCreateGallery() { fail("Gallery DAO not implemented yet."); }
      // @Test
      // void testUpdateGallery() { fail("Gallery DAO not implemented yet."); }
      // @Test
      // void testRemoveGallery() { fail("Gallery DAO not implemented yet."); }
      // @Test
      // void testSearchGalleries() { fail("Gallery DAO not implemented yet."); }

}