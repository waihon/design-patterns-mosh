package com.waihon.designpatterns.mosh.mediator.solution;

public class SignUpDialogBox {
    private TextBox usernameTextBox = new TextBox();
    private TextBox passwordTextBox = new TextBox();
    private CheckBox agreeToTermsCheckBox = new CheckBox();
    private Button singUpButton = new Button();

    public SignUpDialogBox() {
        usernameTextBox.addEventHandler(this::controlChanged);
        passwordTextBox.addEventHandler(this::controlChanged);
        agreeToTermsCheckBox.addEventHandler(this::controlChanged);
    }

    private void controlChanged() {
        singUpButton.setEnabled(isInputValid());
    }

    private boolean isInputValid() {
        return !usernameTextBox.isBlank() && !passwordTextBox.isBlank() && agreeToTermsCheckBox.isChecked();
    }
}
