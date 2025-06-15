package com.waihon.designpatterns.mosh.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
            void canvasShouldShowSelectionIcon() {
                canvas.mouseDown();

                assertThat(canvas.getCurrentIconType()).isEqualTo(IconType.SELECTION);
            }
        }

        @Nested
        class WhenMouseUp {

            @Test
            void canvasShouldDrawDashedLine() {
                canvas.mouseUp();

                assertThat(canvas.getCurrentActionType()).isEqualTo(ActionType.DRAW_DASHED_RECTANGLE);
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
            void canvasShouldShowBrushIcon() {
                canvas.mouseDown();

                assertThat(canvas.getCurrentIconType()).isEqualTo(IconType.BRUSH);
            }
        }

        @Nested
        class WhenMouseUp {

            @Test
            void canvasShouldDrawALine() {
                canvas.mouseUp();

                assertThat(canvas.getCurrentActionType()).isEqualTo(ActionType.DRAW_LINE);
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
            void canvasShouldShowEraserIcon() {
                canvas.mouseDown();

                assertThat(canvas.getCurrentIconType()).isEqualTo(IconType.ERASER);
            }
        }

        @Nested
        class WhenMouseUp {

            @Test
            void canvasShouldEraseSomething() {
                canvas.mouseUp();

                assertThat(canvas.getCurrentActionType()).isEqualTo(ActionType.ERASE_SOMETHING);
            }
        }
    }

}
