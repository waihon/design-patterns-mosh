package com.waihon.designpatterns.mosh.strategy.open;

public class BlackAndWhiteFilter implements Filter {
    @Override
    public void apply() {
        System.out.println("Filtering using Black and White.");
    }
}
