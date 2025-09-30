package com.waihon.designpatterns.mosh.command.composite;

import com.waihon.designpatterns.mosh.command.fx.Command;

public class ResizeCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Resize");
    }
}
