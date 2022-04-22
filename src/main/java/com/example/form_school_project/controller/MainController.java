package com.example.form_school_project.controller;

import com.example.form_school_project.Logic;
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
import java.util.ResourceBundle;

public class MainController implements Initializable {
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

    //Variables needed for whole Controller
    int fileNum = 0;
    int currentRound = 0;
    String[] formWhole;
    FileWriter fileWriter;
    private Logic logic;

    //Enables fillForm button
    public void disableOff(ActionEvent event) {
        fill.setDisable(false);
    }

    //"Switches" to screen where you fill selected form
    private void switchSceneFill(){

        //Makes unneeded componets invisible
        formBox.setVisible(false);
        fill.setVisible(false);
        staticLabel.setVisible(false);
        end.setVisible(false);

        //Makes needed componets visible
        fillField.setVisible(true);
        question.setVisible(true);
        submit.setVisible(true);
    }

    //"Switches" to select form screen
    private void switchSceneMain(){

        //Makes needed componets visible
        formBox.setVisible(true);
        fill.setVisible(true);
        staticLabel.setVisible(true);
        end.setVisible(true);

        //Makes unneeded componets invisible
        fillField.setVisible(false);
        question.setVisible(false);
        submit.setVisible(false);
    }

    //Loads form filling
    public void doForm(ActionEvent event) throws IOException, InterruptedException {

        switchSceneFill();

        //gets selected form
        formWhole = logic.getForm(formBox.getValue());

        //Creates name for file
        boolean run = true;

        //runs until name is found
        while (run) {

            //Creates file to which answers will be saved, saved on Desktop
            File file = new File(System.getProperty("user.home") + "/Desktop/" + formBox.getValue() + " (" + fileNum + ")" + ".txt");

            //Checks if file already exists
            if (!file.createNewFile()) {

                //Increase number for fileName
                fileNum++;
            } else {

                //Shuts down while loop
                run = false;
            }
        }

        //sets current round
        currentRound = 1;

        //sets screen state
        setFormData();
    }

    //sets screen state
    private void setFormData() {

        //Checks for formFill Process completion
        if (currentRound < formWhole.length) {

            //Sets text for question label
            question.setText(formWhole[currentRound]);

            //Clears answer field
            fillField.setText("");
        } else {
            //Resets currentRound
            currentRound = 0;

            //"Switches" to select form screen
            switchSceneMain();
        }
    }

    //writes users response from fill field
    public void submitPressed() throws IOException {

        //Sets which file fileWriter writes into, saved on Desktop
        fileWriter = new FileWriter(System.getProperty("user.home") + "/Desktop/" + formBox.getValue() + " (" + fileNum + ")" + ".txt", true);

        //Writes answers from user (can be NULL)
        fileWriter.write(formWhole[currentRound] + ": " + fillField.getText() + "\n");

        //Writer writes all data to files and closes
        fileWriter.flush();
        fileWriter.close();

        //adds +1 to round to signify turn end
        currentRound++;

        //sets screen state
        setFormData();
    }



    //What happens at the start
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Initiates logic
        logic = new Logic();

        //loads all forms from config.txt to logics internal variable
        logic.loadForms();

        //Adds all forms names to comboBox
        for (String s : logic.getForms()) {
            formBox.getItems().add(s);
        }

        //Makes unneeded componets invisible
        fillField.setVisible(false);
        question.setVisible(false);
        submit.setVisible(false);

    }

    //Terminates application
    public void endMyLife(ActionEvent actionEvent) {
        System.exit(-1);
    }
}