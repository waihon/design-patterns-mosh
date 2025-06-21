package com.waihon.designpatterns.mosh.iterator;

import java.util.ArrayList;
import java.util.List;

public class OpenBrowserHistory {

    private String[] urls = new String[10];
    private int count = 0;

    public void push(String url) {
        count++;
        urls[count - 1] = url;
    }

    public int getSize() {
        return count;
    }

    public String pop() {
        if (getSize() == 0) {
            return null;
        }

        String lastItem = urls[count - 1];
        count--;
        return lastItem;
    }

    public Iterator<String> createIterator() {
        return new ArrayIterator(this);
    }

    public class ArrayIterator implements Iterator<String> {

        private OpenBrowserHistory history;
        private int index;

        public ArrayIterator(OpenBrowserHistory history) {
            this.history = history;
        }

        @Override
        public boolean hasNext() {
            return (index < history.getSize());
        }

        @Override
        public String current() {
            return history.urls[index];
        }

        @Override
        public void next() {
            index++;
        }
    }

}
