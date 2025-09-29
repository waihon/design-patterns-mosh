package com.waihon.designpatterns.mosh.command;

import com.waihon.designpatterns.mosh.command.fx.Button;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

public class AddCustomerTest {
    private CustomerService service;
    private AddCustomerCommand command;
    private Button button;

    @BeforeEach
    void setUp() {
        service = new CustomerService();
        command = new AddCustomerCommand(service);
        button = new Button(command);
    }

    @Test
    void shouldAddACustomer() throws Exception {
        var text = tapSystemOut(() -> {
            button.click();
        });

        assertThat(text).contains("Add customer");
    }
}
