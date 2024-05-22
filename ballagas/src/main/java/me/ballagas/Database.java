package me.ballagas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection != null) return connection;

        String url = "jdbc:mysql://localhost/";
        String user = "root";
        String password = "";

        this.connection = DriverManager.getConnection(url, user, password);

        return this.connection;
    }

    public void InitDatabase() throws SQLException {
        Statement createDB = getConnection().createStatement();

        String createDbSql = "CREATE DATABASE graduation";

        createDB.execute(createDbSql);
        createDB.close();

        System.out.println("graduation -> Database created");
    }

    public void InitTable() throws SQLException {
        Statement createTableProducts = getConnection().createStatement();

        String createTableProductsSql = "CREATE TABLE IF NOT EXISTS `graduation`.`products` (`schoolName` VARCHAR(100) NOT NULL , `className` VARCHAR(20) NOT NULL , `classYears` VARCHAR(50) NOT NULL , `message` VARCHAR(255) NOT NULL , `id` INT NOT NULL AUTO_INCREMENT , PRIMARY KEY (`id`))";

        createTableProducts.execute(createTableProductsSql);
        createTableProducts.close();

        System.out.println("products -> Table created");
    }


}
