package com.waihon.designpatterns.mosh.template;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GenerateReportTaskTest {
    private Task task;

    @BeforeEach
    void setUp() {
        task = new GenerateReportTask();
    }

    @Test
    void shouldAudit() throws Exception {
        String text = tapSystemOut(() -> {
            task.execute();
        });

        assertThat(text).contains("Audit");
    }

    @Test
    void shouldGenerateReport() throws Exception {
        String text = tapSystemOut(() -> {
            task.execute();
        });

        assertThat(text).contains("Generate Report");
    }
}
