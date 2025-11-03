package com.waihon.designpatterns.mosh.adapter.avafilters;

import com.waihon.designpatterns.mosh.adapter.demo.Image;

public class Caramel {
    public void init() {
        System.out.println("Initializing Caramel filter");
    }

    public void render(Image image) {
        System.out.println("Applying Caramel Filter to '" + image.getName() + "'");
    }
}
