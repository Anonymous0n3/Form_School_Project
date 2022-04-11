package com.example.form_school_project.controller;

import com.example.form_school_project.HelloApplication;
import com.example.form_school_project.Logic;
import com.example.form_school_project.Values;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private ComboBox<String> formBox;

    @FXML
    private Button fill;

    public void disableOff(ActionEvent event) {
        fill.setDisable(false);
    }

    public void switchToFillClass(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Fill_Screen.fxml"));
        Parent parent = fxmlLoader.load();


        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    private Logic logic = Values.getLogic();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (String s: logic.getForms()) {
            formBox.getItems().add(s);
        }
    }
}