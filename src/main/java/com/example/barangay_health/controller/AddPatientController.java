package com.example.barangay_health.controller;

import com.example.barangay_health.app.MainApp;
import com.example.barangay_health.repository.PatientRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class AddPatientController {

    @FXML private TextField nameField;
    @FXML private ComboBox<String> departmentComboBox;
    @FXML private TextField concernField;
    @FXML private DatePicker datePicker;

    private final PatientRepository repository = new PatientRepository();

    @FXML
    public void initialize() {
        departmentComboBox.getItems().addAll("Medical", "Dental", "Vaccination");
    }

    @FXML
    private void handleSave() {
        String name = nameField.getText().trim();
        String department = departmentComboBox.getValue();
        String concern = concernField.getText().trim();

        if (name.isEmpty() || department == null || concern.isEmpty() || datePicker.getValue() == null) {
            showAlert(Alert.AlertType.WARNING, "Please fill in all fields.");
            return;
        }

        try {
            repository.save(name, department, concern, datePicker.getValue().toString());
            showAlert(Alert.AlertType.INFORMATION, "Patient successfully added!");
            handleClear();
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Failed to save: " + e.getMessage());
        }
    }

    @FXML
    private void handleClear() {
        nameField.clear();
        departmentComboBox.setValue(null);
        concernField.clear();
        datePicker.setValue(null);
    }

    @FXML
    private void handleBack() throws IOException {
        MainApp.showDashboard();
    }

    private void showAlert(Alert.AlertType type, String msg) {
        Alert alert = new Alert(type);
        alert.setTitle(type == Alert.AlertType.INFORMATION ? "Success" : "Notice");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
