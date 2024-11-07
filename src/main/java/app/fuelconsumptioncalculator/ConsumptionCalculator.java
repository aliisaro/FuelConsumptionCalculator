package app.fuelconsumptioncalculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsumptionCalculator {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/fuelconsumptionapp";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public double calculateConsumption(double distance, double fuel) {
        if (distance <= 0 || fuel <= 0) {
            throw new IllegalArgumentException("Distance and fuel must be greater than zero.");
        }
        return (fuel / distance) * 100;
    }

    public void saveConsumption(double distance, double fuel, double consumption, String language) {
        String insertQuery = "INSERT INTO fuel_consumption_records (distance, fuel, consumption, language) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {

            preparedStatement.setDouble(1, distance);
            preparedStatement.setDouble(2, fuel);
            preparedStatement.setDouble(3, consumption);
            preparedStatement.setString(4, language);
            preparedStatement.executeUpdate();

            System.out.println("Record saved successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to save the record.");
            e.printStackTrace();
        }
    }


}
