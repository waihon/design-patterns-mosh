package com.waihon.designpatterns.mosh.strategy.simple;

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
                void shouldCompressUsingJpeg() throws Exception {
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
                void shouldCompressUsingPng() throws Exception {
                    String text = tapSystemOut(() -> {
                        imageStorage.store(fileName);
                    });

                    assertThat(text).contains("Compressing using PNG.");

                }
            }

        }

        @Nested
        class WithFilter {

            @Nested
            class SetToBlackAndWhite {

                @BeforeEach
                void selectFilter() {
                    imageStorage.setFilter(FilterType.BLACK_AND_WHITE);
                }

                @Test
                void shouldFilterUsingBlackAndWhite() throws Exception {
                    String text = tapSystemOut(() -> {
                        imageStorage.store(fileName);
                    });

                    assertThat(text).contains("Filtering using Black and White.");

                }

            }

            @Nested
            class SetToHighContrast {

                @BeforeEach
                void selectFilter() {
                    imageStorage.setFilter(FilterType.HIGH_CONTRAST);
                }

                @Test
                void shouldFilterUsingHighContrast () throws Exception {
                    String text = tapSystemOut(() -> {
                        imageStorage.store(fileName);
                    });

                    assertThat(text).contains("Filtering using High Contrast.");

                }

            }
        }

    }

}
