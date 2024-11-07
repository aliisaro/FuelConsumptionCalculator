package app.fuelconsumptioncalculator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private Label distanceLabel;
    @FXML private TextField distanceField;
    @FXML private Label fuelLabel;
    @FXML private TextField fuelField;
    @FXML private Button calculateButton;
    @FXML private Label resultLabel;

    @FXML private Button en, fr, ir, jp;

    private ResourceBundle bundle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.bundle = resources;
        updateLabels();
    }

    private void updateLabels() {
        distanceLabel.setText(bundle.getString("distanceLabel.label"));
        fuelLabel.setText(bundle.getString("fuel.label"));
        calculateButton.setText(bundle.getString("calculate.button"));
        resultLabel.setText("");
    }

    @FXML
    public void handleCalculate(ActionEvent event) {
        try {
            double distance = Double.parseDouble(distanceField.getText());
            double fuel = Double.parseDouble(fuelField.getText());

            ConsumptionCalculator calculator = new ConsumptionCalculator();
            double consumption = calculator.calculateConsumption(distance, fuel);

            // Get the current language
            String currentLanguage = bundle.getLocale().getLanguage();

            // Save the consumption data to the database
            calculator.saveConsumption(distance, fuel, consumption, currentLanguage);

            // Display the result
            resultLabel.setText(String.format(bundle.getString("result.label"), consumption));
        } catch (NumberFormatException e) {
            resultLabel.setText(bundle.getString("invalid.input"));
        }
    }

    @FXML
    public void handleLanguageChange(ActionEvent event) {
        String languageCode = "";
        if (event.getSource() == en) {
            languageCode = "en";
        } else if (event.getSource() == fr) {
            languageCode = "fr";
        } else if (event.getSource() == ir) {
            languageCode = "ir";
        } else if (event.getSource() == jp) {
            languageCode = "jp";
        }

        bundle = ResourceBundle.getBundle("Messages", new Locale(languageCode));
        updateLabels();
    }
}
