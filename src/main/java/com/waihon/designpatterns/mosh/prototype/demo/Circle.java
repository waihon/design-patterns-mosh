package com.waihon.designpatterns.mosh.prototype.demo;

public class Circle implements Component {
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void render() {
        System.out.printf("Rendering a circle with a radius of %d...\n", radius);
    }

    @Override
    public Component clone() {
        var newCircle = new Circle();
        newCircle.setRadius(radius);

        return newCircle;
    }
}
