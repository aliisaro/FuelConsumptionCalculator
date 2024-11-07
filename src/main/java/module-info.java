module app.fuelconsumptioncalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens app.fuelconsumptioncalculator to javafx.fxml;
    exports app.fuelconsumptioncalculator;
}