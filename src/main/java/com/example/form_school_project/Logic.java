package com.example.form_school_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Logic {

    //Forms from config.txt are stored here
    private ArrayList<String[]> forms = new ArrayList<>();

    //Load forms from config.txt into forms
    public void loadForms (){

        //Checks for errors in code inside it´s brackets
        try {

            //Loads config.txt file
            File file = new File("src/main/java/com/example/form_school_project/config/config.txt");

            //Initiates scanner on file
            Scanner sc = new Scanner(file);

            //Will run untill there are more lines after current one
            while (sc.hasNextLine()){

                //Scannes whole line into string
                String line = sc.nextLine();

                //Splits whole string into proper format
                String[] form = line.trim().split(";");

                //Adds current form to all forms
                forms.add(form);
            }

            //Will print error if config.txt does not exists
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Return all forms names
    public ArrayList<String> getForms(){

        //Creates temporary arraylist for forms names
        ArrayList<String> formNames = new ArrayList<>();

        //Will run for all forms once
        for (String[] form : forms){

            //Gets name of the forms and adds them to the temporary arraylist
            formNames.add(form[0]);
        }

        //returns temporary arraylist
        return formNames;
    }

    //Returns specific form, requires string
    public String[] getForm(String value){

        //Will run for all forms in their arraylist forms
        for (String[] form:forms) {

            //Checks if the strings value matches one of the forms names
            if (form[0].equals(value)){

                //returns form from arraylist forms
                return form;
            }
        }

        //returns NULL
        return null;
    }
}
