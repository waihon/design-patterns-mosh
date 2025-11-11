package com.waihon.designpatterns.mosh.proxy.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.Assertions.assertThat;

class ProductProxyTest {
    private DbContext dbContext;
    private ProductProxy productProxy;

    @BeforeEach
    void setUp() {
        dbContext = new DbContext();
        productProxy = new ProductProxy(1, dbContext);
    }

    @Test
    void updateProductName() throws Exception {
        var text = tapSystemOut(() -> {
            productProxy.setName("Updated Name");
            dbContext.saveChanges();

            productProxy.setName("Another Name");
            dbContext.saveChanges();
        });

        assertThat(text.lines())
                .contains(
                        "SELECT * FROM products WHERE product_id = 1",
                        "UPDATE products SET name = 'Updated Name' WHERE product_id = 1",
                        "UPDATE products SET name = 'Another Name' WHERE product_id = 1"
                );
    }
}
