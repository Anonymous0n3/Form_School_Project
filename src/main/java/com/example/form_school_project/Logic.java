package com.example.form_school_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Logic {
    private ArrayList<String[]> forms = new ArrayList<>();

    public void loadForms (){
        try {
            File file = new File("src/main/java/com/example/form_school_project/config/config.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] form = line.trim().split(";");
                forms.add(form);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getForms(){
        ArrayList<String> formNames = new ArrayList<>();

        for (String[] form : forms){
            formNames.add(form[0]);
        }
        return formNames;
    }
}
