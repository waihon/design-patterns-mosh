package com.waihon.designpatterns.mosh.iterator;

import java.util.ArrayList;
import java.util.List;

public class OpenBrowserHistory {

    private List<String> urls = new ArrayList<>();

    public void push(String url) {
        urls.add(url);
    }

    public int getSize() {
        return urls.size();
    }

    public String pop() {
        if (getSize() == 0) {
            return null;
        }

        return urls.removeLast(); // Java 21
    }

}
