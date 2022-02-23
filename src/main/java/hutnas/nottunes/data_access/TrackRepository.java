package hutnas.nottunes.data_access;

import hutnas.nottunes.models.Track;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class TrackRepository {

    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    public ArrayList<Track> getTracksByName(String name) {
        ArrayList<Track> tracks = new ArrayList<>();
        try {
            // Open Connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook SQLite established.");

            // Prepare Statement
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT Track.TrackId, Track.Name, Artist.Name as Artist, Album.Title, Genre.Name as Genre FROM Track JOIN Album ON Track.AlbumId=Album.AlbumId JOIN Genre ON Track.GenreId=Genre.GenreId JOIN Artist ON Artist.ArtistId=Album.ArtistId WHERE Track.Name LIKE ?");
            preparedStatement.setString(1, name);
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
        } catch (Exception ex) {
            System.out.println("Something went wrong...");
            System.out.println(ex.toString());
        } finally {
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
}

