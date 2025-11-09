package com.waihon.designpatterns.mosh.bridge.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    @Nested
    class GivenRemoteControl {
        private RemoteControl remote;

        @Nested
        class ForSonyTv {
            private Device device;

            @BeforeEach
            void setUp() {
                device = new SonyTv();
                remote = new RemoteControl(device);
            }

            @Test
            void turnOnRemoteControl() throws Exception {
                var text = tapSystemOut(() -> {
                    remote.turnOn();
                });

                assertThat(text.lines()).containsExactly("Sony TV: turnOn");
            }


            @Test
            void turnOffRemoteControl() throws Exception {
                var text = tapSystemOut(() -> {
                    remote.turnOff();
                });

                assertThat(text.lines()).containsExactly("Sony TV: turnOff");
            }
        }

        @Nested
        class ForSamsungTv {
            private Device device;

            @BeforeEach
            void setUp() {
                device = new SamsungTv();
                remote = new RemoteControl(device);
            }

            @Test
            void turnOnRemoteControl() throws Exception {
                var text = tapSystemOut(() -> {
                    remote.turnOn();
                });

                assertThat(text.lines()).containsExactly("Samsung TV: turnOn");
            }

            @Test
            void turnOffRemoteControl() throws Exception {
                var text = tapSystemOut(() -> {
                    remote.turnOff();
                });

                assertThat(text.lines()).containsExactly("Samsung TV: turnOff");
            }
        }
    }

    @Nested
    class GivenAdvancedRemoteControl {
        private AdvancedRemoteControl advancedRemote;

        @Nested
        class ForSonyTv {
            private Device device;

            @BeforeEach
            void setUp() {
                device = new SonyTv();
                advancedRemote = new AdvancedRemoteControl(device);
            }

            @Test
            void turnOnAdvancedRemoteControl() throws Exception {
                var text = tapSystemOut(() -> {
                    advancedRemote.turnOn();
                });

                assertThat(text.lines()).containsExactly("Sony TV: turnOn");
            }


            @Test
            void turnOffAdvancedRemoteControl() throws Exception {
                var text = tapSystemOut(() -> {
                    advancedRemote.turnOff();
                });

                assertThat(text.lines()).containsExactly("Sony TV: turnOff");
            }

            @Test
            void setChannelAdvancedRemoteControl() throws Exception {
                var text = tapSystemOut(() -> {
                    advancedRemote.setChannel(811);
                });

                assertThat(text.lines()).containsExactly("Sony TV: setChannel(811)");
            }
        }

        @Nested
        class ForSamsungTv {
            private Device device;

            @BeforeEach
            void setUp() {
                device = new SamsungTv();
                advancedRemote = new AdvancedRemoteControl(device);
            }

            @Test
            void turnOnAdvancedRemoteControl() throws Exception {
                var text = tapSystemOut(() -> {
                    advancedRemote.turnOn();
                });

                assertThat(text.lines()).containsExactly("Samsung TV: turnOn");
            }

            @Test
            void turnOffAdvancedRemoteControl() throws Exception {
                var text = tapSystemOut(() -> {
                    advancedRemote.turnOff();
                });

                assertThat(text.lines()).containsExactly("Samsung TV: turnOff");
            }

            @Test
            void setChannelAdvancedRemoteControl() throws Exception {
                var text = tapSystemOut(() -> {
                    advancedRemote.setChannel(813);
                });

                assertThat(text.lines()).containsExactly("Samsung TV: setChannel(813)");
            }
        }
    }
}
