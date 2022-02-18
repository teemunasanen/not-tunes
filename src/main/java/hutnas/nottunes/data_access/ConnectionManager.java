package hutnas.nottunes.data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    //Setup
    static final String URL = "jdbc:sqlite::resource:Chinook_Sqlite.sqlite";
    static private ConnectionManager instance;
    private Connection connection;

    static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;

    }

    private ConnectionManager() {
        try {
            connection = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
