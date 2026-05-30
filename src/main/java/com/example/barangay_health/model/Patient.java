package com.example.barangay_health.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Patient {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty patientName = new SimpleStringProperty();
    private final StringProperty department = new SimpleStringProperty();
    private final StringProperty concern = new SimpleStringProperty();
    private final StringProperty date = new SimpleStringProperty();

    public Patient(int id, String patientName, String department, String concern, String date) {
        this.id.set(id);
        this.patientName.set(patientName);
        this.department.set(department);
        this.concern.set(concern);
        this.date.set(date);
    }

    public int getId() { return id.get(); }
    public IntegerProperty idProperty() { return id; }

    public String getPatientName() { return patientName.get(); }
    public StringProperty patientNameProperty() { return patientName; }

    public String getDepartment() { return department.get(); }
    public StringProperty departmentProperty() { return department; }

    public String getConcern() { return concern.get(); }
    public StringProperty concernProperty() { return concern; }

    public String getDate() { return date.get(); }
    public StringProperty dateProperty() { return date; }
}
