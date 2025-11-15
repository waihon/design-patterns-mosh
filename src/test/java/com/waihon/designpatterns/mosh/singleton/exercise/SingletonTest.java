package com.waihon.designpatterns.mosh.singleton.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SingletonTest {
    private Logger logger1;
    private Logger logger2;
    private Logger logger3;
    private final String FILENAME1 = "app1.log";
    private final String FILENAME2 = "app2.log";
    private final String FIRST_MESSAGE = "First log message";
    private final String SECOND_MESSAGE = "Second log message";

    @BeforeEach
    void setUp() {
        logger1 = Logger.getInstance(FILENAME1);
        logger2 = Logger.getInstance(FILENAME1);
        logger3 = Logger.getInstance(FILENAME2);
    }

    @Test
    void testEquality() {
        assertThat(logger1).isEqualTo(logger2);

        assertThat(logger1).isNotEqualTo(logger3);
    }

    @Test
    void writeToSameLogFileUsingDifferentLogger() {
        logger1.write(FIRST_MESSAGE);
        logger2.write(SECOND_MESSAGE);

        assertThat(logger1.getContent().lines())
                .containsExactly(FIRST_MESSAGE, SECOND_MESSAGE);
    }
}
