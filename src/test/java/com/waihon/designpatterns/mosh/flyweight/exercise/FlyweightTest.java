package com.waihon.designpatterns.mosh.flyweight.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.Assertions.assertThat;

class FlyweightTest {
    private CellContextFactory contextFactory;
    private Spreadsheet sheet;

    @BeforeEach
    void setUp() {
        contextFactory = new CellContextFactory();
        sheet = new Spreadsheet(contextFactory);
    }

    @Test
    void renderDefaultSpreadsheet() throws Exception {
        var text = tapSystemOut(() -> {
            sheet.render();
        });

        assertThat(text.lines())
                .containsExactly(
                        "(0, 0): null [Times New Roman, 12, false]",
                        "(0, 1): null [Times New Roman, 12, false]",
                        "(0, 2): null [Times New Roman, 12, false]",
                        "(1, 0): null [Times New Roman, 12, false]",
                        "(1, 1): null [Times New Roman, 12, false]",
                        "(1, 2): null [Times New Roman, 12, false]",
                        "(2, 0): null [Times New Roman, 12, false]",
                        "(2, 1): null [Times New Roman, 12, false]",
                        "(2, 2): null [Times New Roman, 12, false]"
                );
    }

    @Test
    void renderCustomizedSpreadsheet() throws Exception {
        // (0, 0)
        sheet.setContent(0, 0, "Hello");
        sheet.setFontFamily(0, 0, "Arial");
        // (1, 0)
        sheet.setContent(1, 0, "World");
        sheet.setFontSize(1, 0, 14);
        // (1, 2)
        sheet.setContent(1, 2, "Happy");
        sheet.setBold(1, 2, true);
        // (2, 1)
        sheet.setContent(2, 1, "Friday");
        sheet.setFontFamily(2, 1, "Consolas");
        sheet.setFontSize(2, 1, 16);
        sheet.setBold(2, 1, true);

        var text = tapSystemOut(() -> {
            sheet.render();
        });

        assertThat(text.lines())
                .containsExactly(
                    "(0, 0): Hello [Arial, 12, false]",
                        "(0, 1): null [Times New Roman, 12, false]",
                        "(0, 2): null [Times New Roman, 12, false]",
                        "(1, 0): World [Times New Roman, 14, false]",
                        "(1, 1): null [Times New Roman, 12, false]",
                        "(1, 2): Happy [Times New Roman, 12, true]",
                        "(2, 0): null [Times New Roman, 12, false]",
                        "(2, 1): Friday [Consolas, 16, true]",
                        "(2, 2): null [Times New Roman, 12, false]"
                );
    }
}
