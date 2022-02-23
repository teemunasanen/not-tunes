package hutnas.nottunes.data_access;

import hutnas.nottunes.models.Artist;
import hutnas.nottunes.models.Genre;
import hutnas.nottunes.models.Track;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NotTunesRepository {

    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;


    public ArrayList<Track> getRandomTracks() {
        ArrayList<Track> tracks = new ArrayList<>();
        try {
            // Open Connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook SQLite established.");


            List<Integer> usedRands = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                int rand = (int)(Math.random() * 3503);
                while(usedRands.contains(rand)){
                    rand = (int)(Math.random() * 3503);
                }
                usedRands.add(rand);
                // Prepare Statement
                PreparedStatement preparedStatement =
                        conn.prepareStatement("SELECT Track.TrackId, Track.Name, Artist.Name as Artist, Album.Title, Genre.Name as Genre FROM Track JOIN Album ON Track.AlbumId=Album.AlbumId JOIN Genre ON Track.GenreId=Genre.GenreId JOIN Artist ON Artist.ArtistId=Album.ArtistId LIMIT 1 OFFSET ?");
                preparedStatement.setInt(1, rand);
                // Execute Statement
                ResultSet resultSet = preparedStatement.executeQuery();

                // Process Results
                while (resultSet.next()) {
                    tracks.add(
                            new Track(
                                    resultSet.getInt("TrackId"),
                                    resultSet.getString("Name"),
                                    resultSet.getString("Artist"),
                                    resultSet.getString("Title"),
                                    resultSet.getString("Genre")
                            )
                    );
                }
            }
            } catch(Exception ex){
                System.out.println("Something went wrong...");
                System.out.println(ex.toString());
            } finally{
                try {
                    // Close Connection
                    conn.close();
                } catch (Exception ex) {
                    System.out.println("Something went wrong while closing the connection.");
                    System.out.println(ex.toString());
                }
            }
            return tracks;
    }

    public ArrayList<Artist> getRandomArtists() {
        ArrayList<Artist> artists = new ArrayList<>();
        try {
            // Open Connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook SQLite established.");

            List<Integer> usedRands = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                int rand = (int)(Math.random() * 275);
                while(usedRands.contains(rand)){
                    rand = (int)(Math.random() * 275);
                }
                usedRands.add(rand);
                // Prepare Statement
                PreparedStatement preparedStatement =
                        conn.prepareStatement("SELECT Name FROM Artist LIMIT 1 OFFSET ?");
                preparedStatement.setInt(1, rand);
                // Execute Statement
                ResultSet resultSet = preparedStatement.executeQuery();

                // Process Results
                while (resultSet.next()) {
                    artists.add(
                            new Artist(
                                    resultSet.getString("Name")
                            )
                    );
                }
            }
        } catch(Exception ex){
            System.out.println("Something went wrong...");
            System.out.println(ex.toString());
        } finally{
            try {
                // Close Connection
                conn.close();
            } catch (Exception ex) {
                System.out.println("Something went wrong while closing the connection.");
                System.out.println(ex.toString());
            }
        }
        return artists;
    }

    public ArrayList<Genre> getRandomGenres() {
        ArrayList<Genre> genres = new ArrayList<>();
        try {
            // Open Connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook SQLite established.");

            List<Integer> usedRands = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                int rand = (int)(Math.random() * 25);
                while(usedRands.contains(rand)){
                    rand = (int)(Math.random() * 25);
                }
                usedRands.add(rand);
                // Prepare Statement
                PreparedStatement preparedStatement =
                        conn.prepareStatement("SELECT Name FROM Genre LIMIT 1 OFFSET ?");
                preparedStatement.setInt(1, rand);
                // Execute Statement
                ResultSet resultSet = preparedStatement.executeQuery();

                // Process Results
                while (resultSet.next()) {
                    genres.add(
                            new Genre(
                                    resultSet.getString("Name")
                            )
                    );
                }
            }
        } catch(Exception ex){
            System.out.println("Something went wrong...");
            System.out.println(ex.toString());
        } finally{
            try {
                // Close Connection
                conn.close();
            } catch (Exception ex) {
                System.out.println("Something went wrong while closing the connection.");
                System.out.println(ex.toString());
            }
        }
        return genres;
    }
}
