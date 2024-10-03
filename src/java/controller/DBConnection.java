package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.SleepRecord;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/sleeptracker";
    private static final String USER = "root";
    private static final String PASSWORD = "UBU_12345678";

    private Connection connection;

    public DBConnection() {
        try {
            // Initialize the database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insertSleepData(SleepRecord sleepRecord) {
        String sql = "INSERT INTO sleep_data (user_id, name, after_day, before_day, sleep_time, wake_time) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, sleepRecord.getUserId());
            stmt.setString(2, sleepRecord.getName());
            stmt.setString(3, sleepRecord.getDayOfSleep());
            stmt.setString(4, sleepRecord.getDayOfWake());
            stmt.setString(5, sleepRecord.getSleepTime());
            stmt.setString(6, sleepRecord.getWakeTime());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Close the connection
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
