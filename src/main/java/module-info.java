module com.example.form_school_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.form_school_project to javafx.fxml;
    exports com.example.form_school_project;
    exports com.example.form_school_project.controller;
    opens com.example.form_school_project.controller to javafx.fxml;
}