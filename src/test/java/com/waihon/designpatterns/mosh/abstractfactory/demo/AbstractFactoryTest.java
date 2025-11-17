package com.waihon.designpatterns.mosh.abstractfactory.demo;

import com.waihon.designpatterns.mosh.abstractfactory.demo.ant.AntWidgetFactory;
import com.waihon.designpatterns.mosh.abstractfactory.demo.app.ContactForm;
import com.waihon.designpatterns.mosh.abstractfactory.demo.material.MaterialWidgetFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.Assertions.assertThat;

class AbstractFactoryTest {
    private WidgetFactory factory;
    private ContactForm form;

    @Nested
    class MaterialThemeTest {
        @BeforeEach
        void setUp() {
            factory = new MaterialWidgetFactory();
            form = new ContactForm();
        }

        @Test
        void renderContactForm() throws Exception {
            var text = tapSystemOut(() -> {
                form.render(factory);
            });

            assertThat(text.lines())
                    .containsExactly("Material TextBox", "Material Button");
        }

    }

    @Nested
    class AntThemeTest {
        @BeforeEach
        void setUp() {
            factory = new AntWidgetFactory();
            form = new ContactForm();
        }

        @Test
        void renderContactForm() throws Exception {
            var text = tapSystemOut(() -> {
                form.render(factory);
            });

            assertThat(text.lines())
                    .containsExactly("Ant TextBox", "Ant Button");
        }
    }
}
