package app.fuelconsumptioncalculator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ResourceBundle;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load the resource bundle (assuming you have a properties file 'messages.properties')
        ResourceBundle bundle = ResourceBundle.getBundle("messages");

        // Load the FXML file and pass the bundle
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("View.fxml"), bundle);
        Scene scene = new Scene(fxmlLoader.load(), 320, 500);
        stage.setTitle("Aliisa Rokala!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
