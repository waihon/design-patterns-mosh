package com.waihon.designpatterns.mosh.strategy.open;

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
                    imageStorage.setCompressor(new JpegCompressor());
                    imageStorage.setFilter(new BlackAndWhiteFilter());
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
                    imageStorage.setCompressor(new PngCompressor());
                    imageStorage.setFilter(new BlackAndWhiteFilter());
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
                    imageStorage.setFilter(new BlackAndWhiteFilter());
                    imageStorage.setCompressor(new JpegCompressor());
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
                    imageStorage.setFilter(new HighContrastFilter());
                    imageStorage.setCompressor(new JpegCompressor());
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
