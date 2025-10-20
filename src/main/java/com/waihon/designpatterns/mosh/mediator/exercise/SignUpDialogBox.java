package com.waihon.designpatterns.mosh.mediator.exercise;

public class SignUpDialogBox {
    private TextBox usernameTextBox = new TextBox();
    private TextBox passwordTextBox = new TextBox();
    private CheckBox termsCheckBox = new CheckBox();
    private Button signUpButton = new Button();

    public SignUpDialogBox() {
        usernameTextBox.attach(this::controlChanged);
        passwordTextBox.attach(this::controlChanged);
        termsCheckBox.attach(this::controlChanged);
    }

    public void simulateAllControlsAreEmpty() {
        usernameTextBox.setContent("");
        passwordTextBox.setContent("");
        termsCheckBox.setChecked(false);

        printControlInfo();
    }

    public void simulateAllControlsAreValid() {
        usernameTextBox.setContent("username@example.com");
        passwordTextBox.setContent("Pas$w0rd");
        termsCheckBox.setChecked(true);

        printControlInfo();
    }

    private void controlChanged() {
        var isDisabled = (usernameTextBox.getContent() != null && usernameTextBox.getContent().isEmpty()) ||
                (passwordTextBox.getContent() != null && passwordTextBox.getContent().isEmpty()) ||
                !termsCheckBox.isChecked();

        signUpButton.setEnabled(!isDisabled);
    }

    private void printControlInfo() {
        System.out.println("usernameTextBox: " + usernameTextBox.getContent());
        System.out.println("passwordTextBox: " + passwordTextBox.getContent());
        System.out.println("termsCheckBox: " + termsCheckBox.isChecked());
        System.out.println("signUpButton: " + signUpButton.isEnabled());
    }
}
