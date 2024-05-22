package me.ballagas;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Database db = new Database();

            db.InitDatabase();
            db.InitTable();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}