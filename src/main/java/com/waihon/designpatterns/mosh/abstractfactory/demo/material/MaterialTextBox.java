package com.waihon.designpatterns.mosh.abstractfactory.demo.material;

import com.waihon.designpatterns.mosh.abstractfactory.demo.TextBox;

public class MaterialTextBox implements TextBox {
    @Override
    public void render() {
        System.out.println("Material TextBox");
    }
}
