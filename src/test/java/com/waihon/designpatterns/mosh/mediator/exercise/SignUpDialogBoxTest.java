package com.waihon.designpatterns.mosh.mediator.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SignUpDialogBoxTest {
    private SignUpDialogBox signUpDialogBox;

    @BeforeEach
    void setUp() {
        signUpDialogBox = new SignUpDialogBox();
    }

    @Test
    void testAllControlsAreEmpty() throws Exception {
        var text = tapSystemOut(() -> {
            signUpDialogBox.simulateAllControlsAreEmpty();
        });

        assertThat(text).contains("usernameTextBox: ");
        assertThat(text).contains("passwordTextBox: ");
        assertThat(text).contains("termsCheckBox: false");
        assertThat(text).contains("signUpButton: false");
    }

    @Test
    void testAllControlsAreValid() throws Exception {
        var text = tapSystemOut(() -> {
            signUpDialogBox.simulateAllControlsAreValid();
        });

        assertThat(text).contains("usernameTextBox: username@example.com");
        assertThat(text).contains("passwordTextBox: Pas$w0rd");
        assertThat(text).contains("termsCheckBox: true");
        assertThat(text).contains("signUpButton: true");
    }
}
