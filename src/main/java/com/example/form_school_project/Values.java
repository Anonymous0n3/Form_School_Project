package com.example.form_school_project;

public class Values {
    public static Logic logic = new Logic();

    public static Logic getLogic() {
        return logic;
    }
    public static void loadForms(){
        logic.loadForms();
    }
    public static String[] getForm(String value){
        for (String[] form:logic.getFormsWhole()) {
            form[0].equals(value);
            return form;
        }
        return null;
    }
}
