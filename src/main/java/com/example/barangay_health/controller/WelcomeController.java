package com.example.barangay_health.controller;

import com.example.barangay_health.app.MainApp;
import javafx.fxml.FXML;

import java.io.IOException;

public class WelcomeController {

    @FXML
    private void handleEnter() throws IOException {
        MainApp.showDashboard();
    }
}
