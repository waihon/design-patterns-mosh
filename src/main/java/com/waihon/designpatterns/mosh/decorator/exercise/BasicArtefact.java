package com.waihon.designpatterns.mosh.decorator.exercise;

public class BasicArtefact implements Artefact {
    private String name;

    public BasicArtefact(String name) {
        this.name = name;
    }

    @Override
    public String render() {
        return name;
    }
}
