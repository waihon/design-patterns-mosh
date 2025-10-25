package com.waihon.designpatterns.mosh.iterator.exercise;

import java.util.ArrayList;
import java.util.List;

public class ProductCollection implements Aggregate<Product> {
    private List<Product> products = new ArrayList<>();

    @Override
    public void push(Product product) {
        products.add(product);
    }

    @Override
    public Product pop() {
        return products.removeLast();
    }

    @Override
    public int getSize() {
        return products.size();
    }

    public Iterator<Product> createIterator() {
        return new ListIterator(this);
    }

    class ListIterator implements Iterator<Product> {
        private ProductCollection collection;
        private int index = 0;

        public ListIterator(ProductCollection collection) {
            this.collection = collection;
        }

        @Override
        public boolean hasNext() {
            return index < collection.products.size();
        }

        @Override
        public Product current() {
            return collection.products.get(index);
        }

        @Override
        public void next() {
            index++;
        }
    }
}
