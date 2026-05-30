package com.example.barangay_health.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        showWelcome();
        stage.setTitle("Barangay Health Appointment System");
        stage.setResizable(false);
        stage.show();
    }

    public static void showWelcome() throws IOException {
        loadScene("welcome-view.fxml", 520, 380);
    }

    public static void showDashboard() throws IOException {
        loadScene("dashboard-view.fxml", 620, 420);
    }

    public static void showAddPatient() throws IOException {
        loadScene("add-patient-view.fxml", 520, 440);
    }

    public static void showAllPatients() throws IOException {
        loadScene("all-patients-view.fxml", 820, 520);
    }

    private static void loadScene(String fxml, int width, int height) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                MainApp.class.getResource("/com/example/barangay_health/" + fxml)
        );
        Scene scene = new Scene(loader.load(), width, height);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
