package com.waihon.designpatterns.mosh.decorator.exercise;

public class Editor {
    public void openProject(String path) {
        Artefact[] artefacts = {
                new MainArtefact(new BasicArtefact("Main")),
                new BasicArtefact("Demo"),
                new ErrorArtefact (new BasicArtefact("EmailClient")),
                new MainArtefact(new ErrorArtefact(new BasicArtefact("EmailProvider")))
        };

        for (var artefact : artefacts) {
            System.out.println(artefact.render());
        }
    }
}
