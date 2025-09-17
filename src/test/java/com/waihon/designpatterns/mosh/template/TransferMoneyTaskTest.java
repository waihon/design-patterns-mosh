package com.waihon.designpatterns.mosh.template;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TransferMoneyTaskTest {
    private TransferMoneyTask task;

    @BeforeEach
    void setUp() {
        task = new TransferMoneyTask();
    }

    @Test
    void shouldAudit() throws Exception {
        String text = tapSystemOut(() -> {
            task.execute();
        });

        assertThat(text).contains("Audit");

    }

    @Test
    void shouldTransferMoney() throws Exception {
        String text = tapSystemOut(() -> {
            task.execute();
        });

        assertThat(text).contains("Transfer Money");
    }
}
