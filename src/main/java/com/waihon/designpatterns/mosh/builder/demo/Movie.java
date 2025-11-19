package com.waihon.designpatterns.mosh.builder.demo;

public class Movie {
    private int frames = 0;

    public void addFrame(String text, int duration) {
        frames++;
        System.out.printf("Adding a frame to the movie: %s [%d]\n", text, duration);
    }

    public int getFrames() {
        return frames;
    }
}
