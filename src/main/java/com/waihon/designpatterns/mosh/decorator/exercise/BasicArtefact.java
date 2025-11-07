package com.waihon.designpatterns.mosh.decorator.exercise;

public class Artefact {
    private String name;
    private boolean hasError;
    private boolean main;

    public Artefact(String name) {
        this.name = name;
    }

    public String render() {
        String errorIcon = hasError ? " [Error]" : "";
        String mainIcon = main ? " [Main]" : "";

        return String.format("%s%s%s", name, errorIcon, mainIcon);
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public void setMain(boolean main) {
        this.main = main;
    }
}
