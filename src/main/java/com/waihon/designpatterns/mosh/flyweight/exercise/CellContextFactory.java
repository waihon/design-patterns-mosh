package com.waihon.designpatterns.mosh.flyweight.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CellContextFactory {
    private Map<Integer, CellContext> contexts = new HashMap<>();

    public CellContext getContext(String fontFamily, int fontSize, boolean bold) {
        // Generate a unique key for the combination of fontFamily, fontSize, and bold
        var hash = Objects.hash(fontFamily, fontSize, bold);

        if (!contexts.containsKey(hash)) {
            contexts.put(hash, new CellContext(fontFamily, fontSize, bold));
        }

        return contexts.get(hash);
    }
}
