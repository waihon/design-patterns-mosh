package com.waihon.designpatterns.mosh.builder.demo;

public class Movie {
    private int frameCount = 0;

    public void addFrame(String text, int duration) {
        frameCount++;
        System.out.printf("Adding a frame to the movie: %s [%d]\n", text, duration);
    }

    public int getFrameCount() {
        return frameCount;
    }
}
