package com.waihon.designpatterns.mosh.factorymethod.demo.viewengine;

import java.util.Map;

public interface ViewEngine {
    String render(String viewName, Map<String, Object> context);
}
