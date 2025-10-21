package com.waihon.designpatterns.mosh.chainofresponsibility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChainOfResponsibilityTest {
    private Authenticator authenticator;
    private Logger logger;
    private Compressor compressor;
    private Encryptor encryptor;
    private WebServer webServer;
    private HttpRequest httpRequest;

    @Nested
    class AuthenticatorLoggerCompressor {
        @BeforeEach
        void setUp() {
            compressor = new Compressor(null);
            logger = new Logger(compressor);
            authenticator = new Authenticator(logger);
            webServer = new WebServer(authenticator);
        }

        @Test
        void testValidAuthentication() throws Exception {
            httpRequest = new HttpRequest("admin", "correct");

            var text = tapSystemOut(() -> {
                webServer.handle(httpRequest);
            });

            assertThat(text).contains("Authentication");
            assertThat(text).contains("Logging");
            assertThat(text).contains("Compression");
            assertThat(text).doesNotContain("Encryption");
        }

        @Test
        void testInvalidAuthentication() throws Exception {
            httpRequest = new HttpRequest("admin", "wrong");

            var text = tapSystemOut(() -> {
                webServer.handle(httpRequest);
            });

            assertThat(text).contains("Authentication");
            assertThat(text).doesNotContain("Logging");
            assertThat(text).doesNotContain("Compression");
            assertThat(text).doesNotContain("Encryption");
        }
    }

    @Nested
    class AuthenticatorCompressorEncryptor {
        @BeforeEach
        void setUp() {
            encryptor = new Encryptor(null);
            compressor = new Compressor(encryptor);
            authenticator = new Authenticator(compressor);
            webServer = new WebServer(authenticator);
        }

        @Test
        void testValidAuthentication() throws Exception {
            httpRequest = new HttpRequest("admin", "correct");

            var text = tapSystemOut(() -> {
                webServer.handle(httpRequest);
            });

            assertThat(text).contains("Authentication");
            assertThat(text).contains("Compression");
            assertThat(text).contains("Encryption");
            assertThat(text).doesNotContain("Logging");
        }

        @Test
        void testInvalidAuthentication() throws Exception {
            httpRequest = new HttpRequest("admin", "wrong");

            var text = tapSystemOut(() -> {
                webServer.handle(httpRequest);
            });

            assertThat(text).contains("Authentication");
            assertThat(text).doesNotContain("Logging");
            assertThat(text).doesNotContain("Compression");
            assertThat(text).doesNotContain("Encryption");
        }
    }
}
