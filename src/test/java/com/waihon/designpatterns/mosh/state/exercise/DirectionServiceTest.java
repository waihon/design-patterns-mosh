package com.waihon.designpatterns.mosh.state.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DirectionServiceTest {
    private DirectionService directionService;

    @BeforeEach
    void setUp() {
        directionService = new DirectionService();
    }

    @Nested
    class GivenTravelModeIsDriving {
        @BeforeEach
        void selectTravelMode() {
            directionService.setTravel(new Driving());
        }

        @Nested
        class whenGetEta {
            @Test
            void shouldReturnEta() throws Exception {
                var eta = new AtomicReference<Object>();
                var text = tapSystemOut(() -> {
                    eta.set(directionService.getEta());
                });

                assertThat(text).contains("Calculating ETA (driving)");
                assertThat(eta.get()).isEqualTo(1);

            }
        }

        @Nested
        class whenGetDirection {
            @Test
            void shouldReturnDirection() throws Exception  {
                var direction = new AtomicReference<Object>();
                var text = tapSystemOut(() -> {
                    direction.set(directionService.getDirection());
                });

                assertThat(text).contains("Calculating Direction (driving)");
                assertThat(direction.get()).isEqualTo(1);
            }
        }
    }

    @Nested
    class GivenTravelModeIsBicycling {
        @BeforeEach
        void selectTravelMode() {
            directionService.setTravel(new Bicycling());
        }

        @Nested
        class whenGetEta {
            @Test
            void shouldReturnEta() throws Exception {
                var eta = new AtomicReference<Object>();
                var text = tapSystemOut(() -> {
                    eta.set(directionService.getEta());
                });

                assertThat(text).contains("Calculating ETA (bicycling)");
                assertThat(eta.get()).isEqualTo(2);

            }
        }

        @Nested
        class whenGetDirection {
            @Test
            void shouldReturnDirection() throws Exception  {
                var direction = new AtomicReference<Object>();
                var text = tapSystemOut(() -> {
                    direction.set(directionService.getDirection());
                });

                assertThat(text).contains("Calculating Direction (bicycling)");
                assertThat(direction.get()).isEqualTo(2);
            }
        }
    }

    @Nested
    class GivenTravelModeIsTransit {
        @BeforeEach
        void selectTravelMode() {
            directionService.setTravel(new Transit());
        }

        @Nested
        class whenGetEta {
            @Test
            void shouldReturnEta() throws Exception {
                var eta = new AtomicReference<Object>();
                var text = tapSystemOut(() -> {
                    eta.set(directionService.getEta());
                });

                assertThat(text).contains("Calculating ETA (transit)");
                assertThat(eta.get()).isEqualTo(3);

            }
        }

        @Nested
        class whenGetDirection {
            @Test
            void shouldReturnDirection() throws Exception  {
                var direction = new AtomicReference<Object>();
                var text = tapSystemOut(() -> {
                    direction.set(directionService.getDirection());
                });

                assertThat(text).contains("Calculating Direction (transit)");
                assertThat(direction.get()).isEqualTo(3);
            }
        }
    }

    @Nested
    class GivenTravelModeIsWalking {
        @BeforeEach
        void selectTravelMode() {
            directionService.setTravel(new Walking());
        }

        @Nested
        class whenGetEta {
            @Test
            void shouldReturnEta() throws Exception {
                var eta = new AtomicReference<Object>();
                var text = tapSystemOut(() -> {
                    eta.set(directionService.getEta());
                });

                assertThat(text).contains("Calculating ETA (walking)");
                assertThat(eta.get()).isEqualTo(4);

            }
        }

        @Nested
        class whenGetDirection {
            @Test
            void shouldReturnDirection() throws Exception  {
                var direction = new AtomicReference<Object>();
                var text = tapSystemOut(() -> {
                    direction.set(directionService.getDirection());
                });

                assertThat(text).contains("Calculating Direction (walking)");
                assertThat(direction.get()).isEqualTo(4);
            }
        }
    }
}
