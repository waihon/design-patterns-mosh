package com.waihon.designpatterns.mosh.factorymethod.demo.viewengine;

import java.util.Map;

public abstract class Controller {
    public void render(String viewName, Map<String, Object> context) {
        var viewEngine = createVieweEngine();
        var html = viewEngine.render(viewName, context);

        System.out.println(html);
    }

    protected ViewEngine createVieweEngine() {
        return new MatchaViewEngine();
    }
}
