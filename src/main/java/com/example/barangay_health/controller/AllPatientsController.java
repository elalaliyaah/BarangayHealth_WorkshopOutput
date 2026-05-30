package com.example.barangay_health.controller;

import com.example.barangay_health.app.MainApp;
import com.example.barangay_health.model.Patient;
import com.example.barangay_health.repository.PatientRepository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AllPatientsController {

    @FXML private TableView<Patient> patientTable;
    @FXML private TableColumn<Patient, Integer> idColumn;
    @FXML private TableColumn<Patient, String> nameColumn;
    @FXML private TableColumn<Patient, String> departmentColumn;
    @FXML private TableColumn<Patient, String> concernColumn;
    @FXML private TableColumn<Patient, String> dateColumn;

    private final PatientRepository repository = new PatientRepository();

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(data -> data.getValue().idProperty().asObject());
        nameColumn.setCellValueFactory(data -> data.getValue().patientNameProperty());
        departmentColumn.setCellValueFactory(data -> data.getValue().departmentProperty());
        concernColumn.setCellValueFactory(data -> data.getValue().concernProperty());
        dateColumn.setCellValueFactory(data -> data.getValue().dateProperty());
        loadPatients();
    }

    private void loadPatients() {
        try {
            List<Patient> patients = repository.findAll();
            patientTable.setItems(FXCollections.observableArrayList(patients));
        } catch (SQLException e) {
            showError("Could not load patients: " + e.getMessage());
        }
    }

    @FXML
    private void handleDelete() {
        Patient selected = patientTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "Please select a patient to delete.");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirm Delete");
        confirm.setHeaderText(null);
        confirm.setContentText("Delete record for " + selected.getPatientName() + "?");
        confirm.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    repository.delete(selected.getId());
                    loadPatients();
                } catch (SQLException e) {
                    showError("Failed to delete: " + e.getMessage());
                }
            }
        });
    }

    @FXML
    private void handleRefresh() {
        loadPatients();
    }

    @FXML
    private void handleBack() throws IOException {
        MainApp.showDashboard();
    }

    private void showError(String msg) {
        showAlert(Alert.AlertType.ERROR, msg);
    }

    private void showAlert(Alert.AlertType type, String msg) {
        Alert alert = new Alert(type);
        alert.setTitle("Notice");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
