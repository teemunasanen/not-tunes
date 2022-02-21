package hutnas.nottunes.data_access;

import hutnas.nottunes.models.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerRepository {
    // Setting up the connection object
    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    //GET ALL CUSTOMERS
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

    //GET CUSTOMER BY ID
    public Customer getCustomerById(String id) {
        Customer customer = null;
        try {
            // Open Connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook SQLite established.");

            // Prepare Statement
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email from Customer WHERE CustomerId=?");
            preparedStatement.setString(1, id);
            // Execute Statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process Results
            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getString("CustomerID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Country"),
                        resultSet.getString("PostalCode"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email")
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
        return customer;
    }

    //GET CUSTOMER BY NAME
    public Customer getCustomerByName(String name) {
        Customer customer = null;
        try {
            // Open Connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook SQLite established.");
            // Prepare Statement
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email from Customer WHERE FirstName || LastName LIKE ? ");
            preparedStatement.setString(1, "%" + name + "%");
            // Execute Statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process Results
            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getString("CustomerID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Country"),
                        resultSet.getString("PostalCode"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email")
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
        return customer;
    }

    //GET CUSTOMERS BY LIMIT AND OFFSET
    public ArrayList<Customer> getCustomersByLimitAndOffset(String limit, String offset) {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            // Open Connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook SQLite established.");

            // Prepare Statement
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email from Customer ORDER BY CustomerId LIMIT ? OFFSET ?");
            preparedStatement.setString(1, limit);
            preparedStatement.setString(2, offset);
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

    //ADD NEW CUSTOMER
    public Boolean addCustomer(Customer customer){
        Boolean success = false;
        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook SQLite established.");

            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO Customer(CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email ) VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setString(1, customer.getCustomerId());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getCountry());
            preparedStatement.setString(5, customer.getPostalCode());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());

            // Execute Query
            int result = preparedStatement.executeUpdate();
            success = (result != 0);
            System.out.println("New customer added successfully.");
        }
        catch (Exception ex) {
            System.out.println("Something went wrong...");
            System.out.println(ex.toString());
        }  finally {
            try {
                // Close Connection
                conn.close();
            } catch (Exception ex) {
                System.out.println("Something went wrong while closing the connection.");
                System.out.println(ex.toString());
            }
        }
        return success;
    }

    //UPDATE EXISTING CUSTOMER
    public Boolean updateExistingCustomer(Customer customer){
        Boolean success = false;
        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook SQLite established.");

            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("UPDATE Customer SET FirstName = ?, LastName = ?, Country = ?, PostalCode = ?, Phone = ?, Email= ? WHERE CustomerId = ?");
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getCountry());
            preparedStatement.setString(4, customer.getPostalCode());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getCustomerId());

            // Execute Query
            int result = preparedStatement.executeUpdate();
            success = (result != 0);
            System.out.println("Customer updated successfully.");
        }
        catch (Exception ex) {
            System.out.println("Something went wrong...");
            System.out.println(ex.toString());
        }  finally {
            try {
                // Close Connection
                conn.close();
            } catch (Exception ex) {
                System.out.println("Something went wrong while closing the connection.");
                System.out.println(ex.toString());
            }
        }
        return success;
    }




}

