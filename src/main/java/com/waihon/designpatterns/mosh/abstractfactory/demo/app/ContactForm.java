package com.waihon.designpatterns.mosh.abstractfactory.demo.app;

import com.waihon.designpatterns.mosh.abstractfactory.demo.WidgetFactory;

public class ContactForm {
    public void render(WidgetFactory factory) {
        factory.createTextBox().render();
        factory.createButton().render();
    }
}
