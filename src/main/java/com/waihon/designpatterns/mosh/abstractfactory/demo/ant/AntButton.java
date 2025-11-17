package com.waihon.designpatterns.mosh.abstractfactory.demo.ant;

import com.waihon.designpatterns.mosh.abstractfactory.demo.Button;

public class AntButton implements Button {
    @Override
    public void render() {
        System.out.println("Ant Button");
    }
}
