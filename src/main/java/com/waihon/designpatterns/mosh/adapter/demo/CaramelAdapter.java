package com.waihon.designpatterns.mosh.adapter.demo;

import com.waihon.designpatterns.mosh.adapter.avafilters.Caramel;

public class CaramelAdapter extends Caramel implements Filter {
    @Override
    public void apply(Image image) {
        init();
        render(image);
    }
}
