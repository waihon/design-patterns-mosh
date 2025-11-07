package com.waihon.designpatterns.mosh.decorator.exercise;

public class AbstractArtefact implements Artefact {
    protected Artefact artefact;

    public AbstractArtefact(Artefact artefact) {
        this.artefact = artefact;
    }

    @Override
    public String render() {
        return artefact.render();
    }
}
