module com.example.barangay_health {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires io.github.cdimascio.dotenv.java;

    opens com.example.barangay_health.controller to javafx.fxml;
    opens com.example.barangay_health.model to javafx.base;
    exports com.example.barangay_health.app;
}
