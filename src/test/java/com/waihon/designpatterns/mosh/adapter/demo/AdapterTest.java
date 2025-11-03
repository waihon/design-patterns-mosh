package com.waihon.designpatterns.mosh.adapter.demo;

import com.waihon.designpatterns.mosh.adapter.avafilters.Caramel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AdapterTest {
    private Image image;
    private ImageView imageView;
    private VividFilter vividFilter;
    private CaramelFilter caramelFilter;
    private CaramelAdapter caramelAdapter;

    @BeforeEach
    void setUp() {
        image = new Image("Image 1");
        imageView = new ImageView(image);
        vividFilter = new VividFilter();
        caramelFilter = new CaramelFilter(new Caramel());
        caramelAdapter = new CaramelAdapter();
    }

    @Test
    void applyVividFilter() throws Exception {
        var text = tapSystemOut(() -> {
            imageView.apply(vividFilter);
        });

        assertThat(text).contains("Applying Vivid Filter to 'Image 1'");
    }

    @Test
    void applyCaramelFilter() throws Exception {
        var text = tapSystemOut(() -> {
            imageView.apply(caramelFilter);
        });

        assertThat(text).contains("Applying Caramel Filter to 'Image 1'");
    }

    @Test
    void applyCaramelAdapter() throws Exception {
        var text = tapSystemOut(() -> {
            imageView.apply(caramelAdapter);
        });

        assertThat(text).contains("Applying Caramel Filter to 'Image 1'");
    }
}
