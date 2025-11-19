package com.waihon.designpatterns.mosh.builder.demo;

public class Movie {
    public void addFrame(String text, int duration) {
        System.out.printf("Adding a frame to the movie: %s [%d]\n", text, duration);
    }
}
