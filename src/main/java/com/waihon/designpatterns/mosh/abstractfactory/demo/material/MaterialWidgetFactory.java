package com.waihon.designpatterns.mosh.abstractfactory.demo.material;

import com.waihon.designpatterns.mosh.abstractfactory.demo.Button;
import com.waihon.designpatterns.mosh.abstractfactory.demo.TextBox;
import com.waihon.designpatterns.mosh.abstractfactory.demo.WidgetFactory;

public class MaterialWidgetFactory implements WidgetFactory {
    @Override
    public Button createButton() {
        return new MaterialButton();
    }

    @Override
    public TextBox createTextBox() {
        return new MaterialTextBox();
    }
}
