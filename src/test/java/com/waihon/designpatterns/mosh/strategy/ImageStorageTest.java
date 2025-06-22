package com.waihon.designpatterns.mosh.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ImageStorageTest {

    private ImageStorage imageStorage;
    private String fileName;

    @BeforeEach
    void setUp() {
        imageStorage = new ImageStorage();
    }

    @Nested
    class WhenStoringAnImage {

        @Nested
        class WithCompressor {

            @Nested
            class SetToJpeg {

                @BeforeEach
                void selectCompressor() {
                    imageStorage.setCompressor(CompressorType.JPEG);
                }

                @Test
                void imageStorageShouldCompressUsingJpeg() throws Exception {
                    String text = tapSystemOut(() -> {
                        imageStorage.store(fileName);
                    });

                    assertThat(text).contains("Compressing using JPEG.");

                }
            }

            @Nested
            class SetToPng {

                @BeforeEach
                void selectCompressor() {
                    imageStorage.setCompressor(CompressorType.PNG);
                }

                @Test
                void imageStorageShouldCompressUsingPng() throws Exception {
                    String text = tapSystemOut(() -> {
                        imageStorage.store(fileName);
                    });

                    assertThat(text).contains("Compressing using PNG.");

                }
            }

        }

    }

}
