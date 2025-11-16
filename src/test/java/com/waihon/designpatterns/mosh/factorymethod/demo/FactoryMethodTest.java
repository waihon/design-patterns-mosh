package com.waihon.designpatterns.mosh.factorymethod.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.Assertions.assertThat;

class FactoryMethodTest {
    @Nested
    class UseController {
        private ProductsController controller;

        @BeforeEach
        void setUp() {
            controller = new ProductsController();
        }

        @Test
        void useMatchaViewEngine() throws Exception {
            var text = tapSystemOut(() -> {
                controller.listProducts();
            });

            assertThat(text).contains("View rendered by Matcha");
        }
    }

    @Nested
    class UseSharpController {
        private SharpProductsController controller;

        @BeforeEach
        void setUp() {
            controller = new SharpProductsController();
        }

        @Test
        void useSharpViewEngine() throws Exception {
            var text = tapSystemOut(() -> {
                controller.listProducts();
            });

            assertThat(text).contains("View rendered by Sharp");
        }
    }
}
