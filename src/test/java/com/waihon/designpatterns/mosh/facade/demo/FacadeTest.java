package com.waihon.designpatterns.mosh.facade.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.Assertions.assertThat;

class FacadeTest {
    private NotificationService service;
    private final String TARGET = "target";

    @BeforeEach
    void setUp() {
        service = new NotificationService();
    }

    @Test
    void sendMessage1() throws Exception {
        var message = "Hello, World!";
        var text = tapSystemOut(() -> {
            service.send(message, TARGET);
        });

        assertThat(text.lines()).containsExactly(formattedMessage(message, TARGET));
    }

    @Test
    void sendMessage2() throws Exception {
        var message = "You'll Never Walk Alone";
        var text = tapSystemOut(() -> {
            service.send(message, TARGET);
        });

        assertThat(text.lines()).containsExactly(formattedMessage(message, TARGET));
    }

    private String formattedMessage(String message, String target) {
        return String.format("Sending message '%s' to target '%s'...", message, TARGET);
    }
}
