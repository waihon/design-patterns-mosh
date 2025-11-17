package com.waihon.designpatterns.mosh.abstractfactory.demo.ant;

import com.waihon.designpatterns.mosh.abstractfactory.demo.Button;
import com.waihon.designpatterns.mosh.abstractfactory.demo.TextBox;
import com.waihon.designpatterns.mosh.abstractfactory.demo.WidgetFactory;

public class AntWidgetFactory implements WidgetFactory {
    @Override
    public Button createButton() {
        return new AntButton();
    }

    @Override
    public TextBox createTextBox() {
        return new AntTextBox();
    }
}
