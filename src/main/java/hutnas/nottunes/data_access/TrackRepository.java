package hutnas.nottunes.data_access;

import hutnas.nottunes.models.Customer;
import hutnas.nottunes.models.Track;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class TrackRepository {

    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    public Track getTrackByName(String name) {
        Track track = null;
        try {
            // Open Connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook SQLite established.");

            // Prepare Statement
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT TrackId, Name, AlbumId, GenreId FROM Track WHERE Name=?");
            preparedStatement.setString(1, name);
            // Execute Statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process Results
            while (resultSet.next()) {
                track = new Track (
                                resultSet.getInt("TrackId"),
                                resultSet.getString("Name"),
                                resultSet.getInt("AlbumId"),
                                resultSet.getInt("GenreId")
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
        return track;
    }
}
