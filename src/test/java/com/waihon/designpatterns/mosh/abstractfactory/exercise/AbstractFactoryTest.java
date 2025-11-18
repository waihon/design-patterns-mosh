package com.waihon.designpatterns.mosh.abstractfactory.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.Assertions.assertThat;

class AbstractFactoryTest {
    private HomePage homePage;

    @BeforeEach
    void setUp() {
        homePage = new HomePage();
    }

    @Nested
    class BuildMuscleTest {
        @Test
        void setBuildMuscleGoal() throws Exception {
            var text = tapSystemOut(() -> {
                homePage.setGoal(new BuildMuscleFactory());
            });

            assertThat(text.lines())
                    .containsExactly("Follow Build Muscle Workout Plan",
                            "Follow Build Muscle Meal Plan");
        }
    }

    @Nested
    class WeightLossTest {
        @Test
        void setWeightLossGoal() throws Exception {
            var text = tapSystemOut(() -> {
                homePage.setGoal(new WeightLossFactory());
            });

            assertThat(text.lines())
                    .containsExactly("Follow Weight Loss Workout Plan",
                            "Follow Weight Loss Meal Plan");
        }
    }
}
