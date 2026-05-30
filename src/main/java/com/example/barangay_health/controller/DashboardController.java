package com.example.barangay_health.controller;

import com.example.barangay_health.app.MainApp;
import com.example.barangay_health.repository.PatientRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.SQLException;

public class DashboardController {

    @FXML private Label medicalCountLabel;
    @FXML private Label dentalCountLabel;
    @FXML private Label vaccinationCountLabel;

    private final PatientRepository repository = new PatientRepository();

    @FXML
    public void initialize() {
        loadCounts();
    }

    private void loadCounts() {
        try {
            medicalCountLabel.setText(String.valueOf(repository.countByDepartment("Medical")));
            dentalCountLabel.setText(String.valueOf(repository.countByDepartment("Dental")));
            vaccinationCountLabel.setText(String.valueOf(repository.countByDepartment("Vaccination")));
        } catch (SQLException e) {
            showError("Could not load counts: " + e.getMessage());
        }
    }

    @FXML
    private void handleAddPatient() throws IOException {
        MainApp.showAddPatient();
    }

    @FXML
    private void handleViewAll() throws IOException {
        MainApp.showAllPatients();
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
