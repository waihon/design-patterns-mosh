package com.waihon.designpatterns.mosh.decorator.exercise;

public class MainArtefact extends AbstractArtefact {
    public MainArtefact(Artefact artefact) {
        super(artefact);
    }

    @Override
    public String render() {
        return String.format("%s%s", artefact.render(), " [Main]");
    }
}
