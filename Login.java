package com.mycompany.quickchat_part2;

public class Login {

    private String username;
    private String password;
    private String cellphoneNumber;
    private String firstName;
    private String lastName;

    public Login(String firstName,
                 String lastName,
                 String username,
                 String password,
                 String cellphoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellphoneNumber = cellphoneNumber;
    }

    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {

        if (password.length() < 8) return false;

        boolean upper = false;
        boolean digit = false;
        boolean special = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) upper = true;
            else if (Character.isDigit(c)) digit = true;
            else if (!Character.isLetterOrDigit(c)) special = true;
        }

        return upper && digit && special;
    }

    public boolean checkCellphoneNumber() {
        return cellphoneNumber.startsWith("+27")
                && cellphoneNumber.length() == 12;
    }

    public String registerUser() {

        if (!checkUserName()) {
            return "Username is not correctly formatted. It must contain an underscore and be no more than 5 characters.";
        }

        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted. It must contain at least 8 characters, a capital letter, a number and a special character.";
        }

        if (!checkCellphoneNumber()) {
            return "Cellphone number is incorrect. It must start with +27 and be 12 characters long.";
        }

        return "User is registered successfully.";
    }

    public boolean loginUser(String inputUsername, String inputPassword) {
        return inputUsername.equals(username)
                && inputPassword.equals(password);
    }

    public String returnLoginStatus(boolean loginStatus) {

        if (loginStatus) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}