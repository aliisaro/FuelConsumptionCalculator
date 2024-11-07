module app.fuelconsumptioncalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens app.fuelconsumptioncalculator to javafx.fxml;
    exports app.fuelconsumptioncalculator;
}