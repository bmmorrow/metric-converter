package com.brandon;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Unit Converter");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        Label convertLabel = new Label("Conversion:");
        GridPane.setConstraints(convertLabel, 0, 0);

        ComboBox<String> conversionOptions = new ComboBox<>();
        conversionOptions.getItems().addAll(
                "km to Mi",
                "Mi to km",
                "ft to m",
                "in to cm",
                "in to mm"
        );
        conversionOptions.setPromptText("Select Conversion");
        GridPane.setConstraints(conversionOptions, 1, 0);

        Label valueLabel = new Label("Value:");
        GridPane.setConstraints(valueLabel, 0, 1);

        TextField valueInput = new TextField();
        valueInput.setPromptText("Enter Value");
        GridPane.setConstraints(valueInput, 1, 1);

        Button convertButton = new Button("Convert");
        GridPane.setConstraints(convertButton, 1, 2);

        Label resultLabel = new Label();
        GridPane.setConstraints(resultLabel, 1, 3);

        grid.getChildren().addAll(convertLabel, conversionOptions, valueLabel, valueInput, convertButton, resultLabel);

        convertButton.setOnAction(e -> {
            String conversion = conversionOptions.getValue();
            String valueStr = valueInput.getText();
            if (conversion != null && !valueStr.isEmpty()) {
                double value = Double.parseDouble(valueStr);
                double result = 0;
                switch (conversion) {
                    case "km to Mi":
                        result = value / 1.6093445;
                        break;
                    case "Mi to km":
                        result = value / 0.62137;
                        break;
                    case "ft to m":
                        result = value / 3.28084;
                        break;
                    case "in to cm":
                        result = value * 2.54;
                        break;
                    case "in to mm":
                        result = value * 25.4;
                        break;
                }
                resultLabel.setText(String.format("%.2f", result));
            } else {
                resultLabel.setText("Invalid input");
            }
        });

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}