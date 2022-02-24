package hutnas.nottunes.data_access;

import hutnas.nottunes.models.CustomerGenre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerGenreRepository {

    // Setting up the connection object
    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    //GET FAVORITE GENRE(S)
    public ArrayList<CustomerGenre> getCustomerFavoriteGenre(String id) {
        ArrayList<CustomerGenre> results = new ArrayList<>();
        try {
            // Open Connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook SQLite established.");

            // Prepare Statement
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Name, AmountOfSongs FROM (SELECT Invoice.CustomerId, Customer.FirstName, Customer.LastName, Genre.Name, COUNT(Genre.Name) as AmountOfSongs FROM Invoice JOIN Customer ON Invoice.CustomerId=Customer.CustomerId JOIN InvoiceLine ON Invoice.InvoiceId=InvoiceLine.InvoiceId JOIN Track ON InvoiceLine.TrackId=Track.TrackId JOIN Genre ON Track.GenreId=Genre.GenreId WHERE Customer.CustomerId = ? GROUP BY Genre.Name) WHERE AmountOfSongs = (SELECT MAX(AmountOfSongs) FROM (SELECT Invoice.CustomerId, Customer.FirstName, Customer.LastName, Genre.Name, COUNT(Genre.Name) as AmountOfSongs FROM Invoice JOIN Customer ON Invoice.CustomerId=Customer.CustomerId JOIN InvoiceLine ON Invoice.InvoiceId=InvoiceLine.InvoiceId JOIN Track ON InvoiceLine.TrackId=Track.TrackId JOIN Genre ON Track.GenreId=Genre.GenreId WHERE Customer.CustomerId = ? GROUP BY Genre.Name)) ");

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, id);
            // Execute Statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process Results
            while (resultSet.next()) {
                results.add(
                        new CustomerGenre(
                        resultSet.getInt("CustomerId"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Name"),
                        resultSet.getString("AmountOfSongs")
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
        return results;
    }
}
