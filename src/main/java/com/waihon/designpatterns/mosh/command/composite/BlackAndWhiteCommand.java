package com.waihon.designpatterns.mosh.command.composite;

import com.waihon.designpatterns.mosh.command.fx.Command;

public class BlackAndWhiteCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Black and White");
    }
}
