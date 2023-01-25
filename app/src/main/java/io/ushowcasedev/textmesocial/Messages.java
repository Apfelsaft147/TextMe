package io.ushowcasedev.textmesocial;

public class Messages {

    // string variable for
    // storing employee name.
    private String userName;

    // string variable for storing
    // employee contact number
    private String text;

    // an empty constructor is
    // required when using
    // Firebase Realtime Database.
    public Messages() {

    }

    // created getter and setter methods
    // for all our variables.
    public String getuserName() {
        return userName;
    }

    public static void setuserName(String userName) {
        userName = userName;
    }

    public static void setText(String text) {
        text = text;
    }
}
