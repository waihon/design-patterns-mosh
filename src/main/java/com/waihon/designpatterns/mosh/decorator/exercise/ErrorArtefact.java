package com.waihon.designpatterns.mosh.decorator.exercise;

public class ErrorArtefact extends AbstractArtefact {
    public ErrorArtefact(Artefact artefact) {
        super(artefact);
    }

    @Override
    public String render() {
        return String.format("%s%s", artefact.render(), " [Error]");
    }
}
