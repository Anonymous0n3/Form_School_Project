package com.example.form_school_project.controller;

import com.example.form_school_project.Logic;
import com.example.form_school_project.Values;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.EventListener;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private boolean run = true;


    @FXML
    private ComboBox<String> formBox;

    @FXML
    private Button fill;

    @FXML
    private TextField fillField;

    @FXML
    private Label question;

    @FXML
    private Button submit;

    @FXML
    private Label staticLabel;

    @FXML
    private Button end;

    //Enables Fill Form button
    public void disableOff(ActionEvent event) {
        fill.setDisable(false);
    }

    public void submitPressed(){
        run = false;
    }

    private void switchSceneFill(){
        formBox.setVisible(false);
        fill.setVisible(false);
        staticLabel.setVisible(false);
        end.setVisible(false);

        fillField.setVisible(true);
        question.setVisible(true);
        submit.setVisible(true);
    }

    private void switchSceneMain(){
        formBox.setVisible(true);
        fill.setVisible(true);
        staticLabel.setVisible(true);
        end.setVisible(true);

        fillField.setVisible(false);
        question.setVisible(false);
        submit.setVisible(false);
    }

    public void doForm(ActionEvent event) throws IOException, InterruptedException {

        switchSceneFill();

        String[] formWhole = Values.getForm(formBox.getValue());

        File file = new File("placeholder.txt");
        FileWriter fileWriter = new FileWriter("placeholder.txt");

        for (int i = 1; i <formWhole.length; i++) {
            question.setText(formWhole[i]);



            fileWriter.write(formWhole[i] + ": " + fillField.getText() + "\n");
        }
        fileWriter.flush();
        fileWriter.close();
        switchSceneMain();
    }

    private Logic logic = Values.getLogic();



    //What happens at the start
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (String s: logic.getForms()) {
            formBox.getItems().add(s);
        }

        fillField.setVisible(false);
        question.setVisible(false);
        submit.setVisible(false);
    }
}