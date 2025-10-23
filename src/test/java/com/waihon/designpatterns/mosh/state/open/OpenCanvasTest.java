package com.waihon.designpatterns.mosh.state.open;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OpenCanvasTest {

    OpenCanvas canvas;

    @BeforeEach
    void setUp() {
        canvas = new OpenCanvas();
    }

    @Nested
    class GivenCurrentToolIsSelection {

        @BeforeEach
        void selectTool() {
            canvas.setCurrentTool(new SelectionTool(canvas));
        }

        @Nested
        class WhenMouseDown {

            @Test
            void canvasShouldShowSelectionIcon() throws Exception {
                var text = tapSystemOut(() -> {
                    canvas.mouseDown();
                });

                assertThat(text).contains("Selection icon");
            }
        }

        @Nested
        class WhenMouseUp {

            @Test
            void canvasShouldDrawDashedLine() throws Exception {
                var text = tapSystemOut(() -> {
                    canvas.mouseUp();
                });

                assertThat(text).contains("Draw dashed rectangle");
            }
        }

    }

    @Nested
    class GivenCurrentToolIsBrush {

        @BeforeEach
        void selectTool() {
            canvas.setCurrentTool(new BrushTool(canvas));
        }

        @Nested
        class WhenMouseDown {

            @Test
            void canvasShouldShowBrushIcon() throws Exception {
                var text = tapSystemOut(() -> {
                    canvas.mouseDown();
                });

                assertThat(text).contains("Brush icon");
            }
        }

        @Nested
        class WhenMouseUp {

            @Test
            void canvasShouldDrawALine() throws Exception {
                var text = tapSystemOut(() -> {
                    canvas.mouseUp();
                });

                assertThat(text).contains("Draw a line");
            }
        }
    }

    @Nested
    class GivenCurrentToolIsEraser {

        @BeforeEach
        void selectTool() {
            canvas.setCurrentTool(new EraserTool(canvas));
        }

        @Nested
        class WhenMouseDown {

            @Test
            void canvasShouldShowEraserIcon() throws Exception {
                var text = tapSystemOut(() -> {
                    canvas.mouseDown();
                });

                assertThat(text).contains("Eraser icon");
            }
        }

        @Nested
        class WhenMouseUp {

            @Test
            void canvasShouldEraseSomething() throws Exception {
                var text = tapSystemOut(() -> {
                    canvas.mouseUp();
                });

                assertThat(text).contains("Erase something");
            }
        }
    }

}
