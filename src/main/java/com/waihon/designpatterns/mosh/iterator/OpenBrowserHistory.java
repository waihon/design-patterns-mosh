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

    public Iterator<String> createIterator() {
        return new ListIterator(this);
    }

    public class ListIterator implements Iterator<String> {

        private OpenBrowserHistory history;
        private int index;

        public ListIterator(OpenBrowserHistory history) {
            this.history = history;
        }

        @Override
        public boolean hasNext() {
            return (index < history.getSize());
        }

        @Override
        public String current() {
            return history.urls.get(index);
        }

        @Override
        public void next() {
            index++;
        }
    }

}
