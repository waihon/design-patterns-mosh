package com.waihon.designpatterns.mosh.abstractfactory.demo.ant;


import com.waihon.designpatterns.mosh.abstractfactory.demo.TextBox;

public class AntTextBox implements TextBox {
    @Override
    public void render() {
        System.out.println("Ant TextBox");
    }
}
