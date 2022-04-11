package com.example.form_school_project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FillController implements Initializable {

    @FXML
    private Label question;

    @FXML
    private TextField fillField;

    @FXML
    private Button submit;



    public void onSubmit() throws IOException {
        FileWriter fileWriter = new FileWriter("placeholder.txt");

        fileWriter.write(question.getText() + ": " + fillField.getText());

        fileWriter.flush();
        fileWriter.close();

        close();
    }

    public void close(){
        Stage stageIn  = (Stage) question.getScene().getWindow();
        stageIn.close();
    }

    public void start(ActionEvent event){
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        question.setText((String)stage.getUserData());

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
