package com.waihon.designpatterns.mosh.factorymethod.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.Assertions.assertThat;

class FactoryMethodTest {
    private Scheduler scheduler;
    private Event event;
    private final String EVENT_NAME = "Java User Group #11";

    @Nested
    class CalenderScheduler {
        @BeforeEach
        void setUp() {
            scheduler = new Scheduler();
            event = new Event(EVENT_NAME);
        }

        @Test
        void useGregorianCalender() throws Exception {
            var text = tapSystemOut(() -> {
                scheduler.schedule(event);
            });

            assertThat(text).contains("Adding event '" + EVENT_NAME + "' on " + new GregorianCalendar().formattedToday());
        }
    }

    @Nested
    class HijrahCalenderScheduler {
        @BeforeEach
        void setUp() {
            scheduler = new HijrahScheduler();
            event = new Event(EVENT_NAME);
        }

        @Test
        void useHijrahCalender() throws Exception {
            var text = tapSystemOut(() -> {
                scheduler.schedule(event);
            });

            assertThat(text).contains("Adding event '" + EVENT_NAME + "' on " + new HijrahCalendar().formattedToday());
        }
    }
}
