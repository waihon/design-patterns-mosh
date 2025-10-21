package com.waihon.designpatterns.mosh.visitor;

public class PlainTextOperation implements Operation {
    @Override
    public void apply(HeadingNode heading) {
        System.out.println("plaintext-heading");
    }

    @Override
    public void apply(AnchorNode anchor) {
        System.out.println("plaintext-anchor");
    }
}
