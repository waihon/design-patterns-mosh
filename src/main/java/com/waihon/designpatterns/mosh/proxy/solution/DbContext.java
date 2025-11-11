package com.waihon.designpatterns.mosh.proxy.solution;

import java.util.HashMap;
import java.util.Map;

public class DbContext {
    private Map<Integer, Product> updatedProducts = new HashMap<>();

    public Product getProduct(int id) {
        // Automatically generate SQL statements to read the product
        // with the given ID.
        System.out.printf("SELECT * FROM products WHERE product_id = %d\n", id);

        // Simulate reading a product object from a database.
        var product = new ProductProxy(id, this);
        product.setName("Product 1");

        return product;
    }

    public void saveChanges() {
        // Automatically generate SQL statements to update the database.
        for (var updatedProduct : updatedProducts.values()) {
            System.out.printf("UPDATE products SET name = '%s' WHERE product_id = %d\n",
                    updatedProduct.getName(), updatedProduct.getId());
        }

        updatedProducts.clear();
    }

    public void markAsChanged(Product product) {
        updatedProducts.put(product.getId(), product);
    }
}
