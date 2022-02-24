package hutnas.nottunes.data_access;

import hutnas.nottunes.models.CustomerSpender;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerSpenderRepository {

    // Setting up the connection object
    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    //GET ALL COUNTRIES
    public ArrayList<CustomerSpender> getCustomersByTotalInvoice() {
        ArrayList<CustomerSpender> spenders = new ArrayList<>();
        try {
            // Open Connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook SQLite established.");

            // Prepare Statement
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT Invoice.CustomerId, Customer.FirstName, Customer.LastName, Invoice.Total from Invoice JOIN Customer ON Invoice.CustomerId=Customer.CustomerId GROUP BY Invoice.Total ORDER BY Invoice.Total DESC");
            // Execute Statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process Results
            while (resultSet.next()) {
                spenders.add(
                        new CustomerSpender(
                                resultSet.getInt("CustomerId"),
                                resultSet.getString("FirstName"),
                                resultSet.getString("LastName"),
                                resultSet.getString("Total")
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
        return spenders;
    }
}
