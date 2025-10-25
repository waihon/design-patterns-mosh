package com.waihon.designpatterns.mosh.iterator.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IteratorTest {
    ProductCollection collection;
    Iterator<Product> iterator;

    @BeforeEach
    void setUp() {
        collection = new ProductCollection();
        collection.push(new Product(1, "Product One"));
        collection.push(new Product(2, "Product Two"));
        collection.push(new Product(3, "Product Three"));
        iterator = collection.createIterator();
    }

    @Test
    void canIterateOverProductCollection() {
        List<String> productNames = new ArrayList<>();
        while (iterator.hasNext()) {
            Product product = iterator.current();
            productNames.add(product.getName());
            iterator.next();
        }

        assertThat(productNames).isEqualTo(Arrays.asList("Product One", "Product Two", "Product Three"));
    }
}
