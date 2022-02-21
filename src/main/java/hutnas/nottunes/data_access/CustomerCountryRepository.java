package hutnas.nottunes.data_access;

import hutnas.nottunes.models.CustomerCountry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerCountryRepository {

    // Setting up the connection object
    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    //GET ALL COUNTRIES
    public ArrayList<CustomerCountry> getAllCustomerCountries() {
        ArrayList<CustomerCountry> countries = new ArrayList<>();
        try {
            // Open Connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook SQLite established.");

            // Prepare Statement
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT Country, COUNT(Country) as NumberOfCountries from Customer GROUP BY Country ORDER BY NumberOfCountries DESC");
            // Execute Statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process Results
            while (resultSet.next()) {
                countries.add(
                        new CustomerCountry(
                                resultSet.getString("Country"),
                                resultSet.getString("NumberOfCountries")
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
        return countries;
    }
}
