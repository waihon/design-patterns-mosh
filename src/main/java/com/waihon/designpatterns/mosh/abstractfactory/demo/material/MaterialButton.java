package com.waihon.designpatterns.mosh.abstractfactory.demo.material;

import com.waihon.designpatterns.mosh.abstractfactory.demo.Button;

public class MaterialButton implements Button {
    @Override
    public void render() {
        System.out.println("Material Button");
    }
}
