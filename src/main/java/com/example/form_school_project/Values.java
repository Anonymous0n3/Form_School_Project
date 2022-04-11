package com.example.form_school_project;

public class Values {
    public static Logic logic = new Logic();

    public static Logic getLogic() {
        return logic;
    }
    public static void loadForms(){
        logic.loadForms();
    }
}
