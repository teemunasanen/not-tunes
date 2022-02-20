package hutnas.nottunes.data_access;

import hutnas.nottunes.models.Customer;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;


public class CustomerRepository {
    // Setting up the connection object
    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;


    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            // Open Connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook SQLite established.");

            // Prepare Statement
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email from Customer");
            // Execute Statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process Results
            while (resultSet.next()) {
                customers.add(
                        new Customer(
                                resultSet.getString("CustomerID"),
                                resultSet.getString("FirstName"),
                                resultSet.getString("LastName"),
                                resultSet.getString("Country"),
                                resultSet.getString("PostalCode"),
                                resultSet.getString("Phone"),
                                resultSet.getString("Email")
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
        return customers;
    }

}
