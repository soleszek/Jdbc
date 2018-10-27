package pl.sdacademy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

    public static void main(String[] args) throws SQLException {
        System.out.println("test");

        String dbPassword = "Samsunge1080";
        String dbUser = "root";
        String connectionString = "jdbc:mysql://localhost:3306/baza_testowa";
        String connectionOptions = "?serverTimezone=UTC&useSSL=false&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true";

        Properties prop = new Properties();
        prop.put("password", dbPassword);
        prop.put("user", dbUser);

        Connection connection = DriverManager.getConnection(connectionString+connectionOptions, prop);



    }

}
