package com.waihon.designpatterns.mosh.visitor;

public class HeadingNode implements HtmlNode {
    @Override
    public void execute(Operation operation) {
        operation.apply(this);
    }
}
