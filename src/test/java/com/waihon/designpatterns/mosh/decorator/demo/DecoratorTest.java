package com.waihon.designpatterns.mosh.decorator.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DecoratorTest {
    private final String data = "1234-5678-9012-3456";

    @BeforeEach
    void setUp() {
    }

    @Test
    void cloudStream() throws Exception {
        var stream = new CloudStream();

        var text = tapSystemOut(() -> {
            stream.write(data);
        });

        assertThat(text).contains("Storing " + data);
    }

    @Test
    void encryptedCloudStream() throws Exception {
        var stream = new EncryptedStream(new CloudStream());

        var text = tapSystemOut(() -> {
            stream.write(data);
        });

        assertThat(text).contains("Storing <=>?8@ABC8D;<=8>?@A");
    }

    @Test
    void compressedCloudStream() throws Exception {
        var stream = new CompressedStream(new CloudStream());

        var text = tapSystemOut(() -> {
            stream.write(data);
        });

        assertThat(text).contains("Storing 1234-5678");
    }

    @Test
    void compressedEncryptedCloudStream() throws Exception {
        var stream = new CompressedStream(new EncryptedStream(new CloudStream()));

        var text = tapSystemOut(() -> {
            stream.write(data);
        });

        assertThat(text).contains("Storing <=>?8@ABC");
    }

    @Test
    void encryptedCompressedCloudStream() throws Exception {
        var stream = new EncryptedStream(new CompressedStream(new CloudStream()));

        var text = tapSystemOut(() -> {
            stream.write(data);
        });

        assertThat(text).contains("Storing <=>?8@ABC");
    }
}
