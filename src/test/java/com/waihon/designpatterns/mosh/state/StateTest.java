package com.waihon.designpatterns.mosh.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StateTest {

    Canvas canvas;

    @BeforeEach
    void setUp() {
        canvas = new Canvas();
    }

    @Nested
    class GivenCurrentToolIsSelection {

        @BeforeEach
        void selectTool() {
            canvas.setCurrentTool(ToolType.SELECTION);
        }

        @Nested
        class WhenMouseDown {

            @Test
            void canvasShouldShowSelectionIcon() {
                canvas.mouseDown();

                assertThat(canvas.getCurrentIcon()).isEqualTo(IconType.SELECTION);
            }
        }

        @Nested
        class WhenMouseUp {

            @Test
            void canvasShouldDrawDashedLine() {
                canvas.mouseUp();

                assertThat(canvas.getCurrentAction()).isEqualTo(ActionType.DRAW_DASHED_RECTANGLE);
            }
        }

    }

    @Nested
    class GivenCurrentToolIsBrush {

        @BeforeEach
        void selectTool() {
            canvas.setCurrentTool(ToolType.BRUSH);
        }

        @Nested
        class WhenMouseDown {

            @Test
            void canvasShouldShowBrushIcon() {
                canvas.mouseDown();

                assertThat(canvas.getCurrentIcon()).isEqualTo(IconType.BRUSH);
            }
        }
    }

}
