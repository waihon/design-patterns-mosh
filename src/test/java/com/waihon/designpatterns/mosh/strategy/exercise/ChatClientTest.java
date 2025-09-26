package com.waihon.designpatterns.mosh.strategy.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChatClientTest {
    private ChatClient chatClient;

    @Nested
    class WhenSendingMessage {

        @Nested
        class WithEncryptor {

            @Nested
            class SetToDes {
                @BeforeEach
                void setUp() {
                    chatClient = new ChatClient(new DesEncryptor());
                }

                @Test
                void shouldEncryptUsingDesAlgorithm() throws Exception {
                    var text = tapSystemOut(() -> {
                        chatClient.send("Hello World");
                    });

                    assertThat(text).contains("Encrypting message using DES");
                    assertThat(text).contains("Sending the encrypted message...");
                }
            }

            @Nested
            class SetToAes {
                @BeforeEach
                void setUp() {
                    chatClient = new ChatClient(new AesEncryptor());
                }

                @Test
                void shouldEncryptUsingAesAlgorithm() throws Exception {
                    var text = tapSystemOut(() -> {
                        chatClient.send("Hello World");
                    });

                    assertThat(text).contains("Encrypting message using AES");
                    assertThat(text).contains("Sending the encrypted message...");
                }
            }
        }
    }
}
