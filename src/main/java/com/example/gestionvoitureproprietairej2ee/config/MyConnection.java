package  com.example.gestionvoitureproprietairej2ee.config;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    private static Connection connection ;

    DataSource dataSource = MyDataSourceFactory.getMySQLDataSource();

    private MyConnection() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection()  {
        if (connection == null){
            new MyConnection();
        }
        return connection;
    }

}
