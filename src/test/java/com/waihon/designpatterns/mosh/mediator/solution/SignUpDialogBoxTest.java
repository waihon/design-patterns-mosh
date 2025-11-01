package com.waihon.designpatterns.mosh.mediator.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SignUpDialogBoxTest {
    private TextBox usernameTextBox;
    private TextBox passwordTextBox;
    private CheckBox agreeToTermsCheckBox;
    private Button signUpButton;

    @BeforeEach
    void setUp() {
        usernameTextBox = new TextBox();
        passwordTextBox = new TextBox();
        agreeToTermsCheckBox = new CheckBox();
        signUpButton = new Button();
    }

    @Nested
    class SignUpButton {
        @Test
        void shouldBeDisabledInitially() {
            assertThat(signUpButton.isEnabled()).isFalse();
        }

        @Test
        void shouldBeDisabledWhenUserNameIsEntered() {
            usernameTextBox.setContent("johndoe");

            assertThat(signUpButton.isEnabled()).isFalse();
        }

        @Test
        void shouldBeDisabledWhenUserNameAndPassowrdAreEntered() {
            usernameTextBox.setContent("johndoe");
            passwordTextBox.setContent("Pas$w0rd");

            assertThat(signUpButton.isEnabled()).isFalse();
        }

        void shouldBeEnabledWhenAllRequiredControlsAreEntered() {
            usernameTextBox.setContent("johndoe");
            passwordTextBox.setContent("Pas$w0rd");
            agreeToTermsCheckBox.setChecked(true);

            assertThat(signUpButton.isEnabled()).isTrue();
        }

        void shouldBeDisabledAfterPasswordIsRmoved() {
            usernameTextBox.setContent("johndoe");
            passwordTextBox.setContent("Pas$w0rd");
            agreeToTermsCheckBox.setChecked(true);

            assertThat(signUpButton.isEnabled()).isTrue();

            passwordTextBox.setContent("");

            assertThat(signUpButton.isEnabled()).isFalse();
        }

    }
}
