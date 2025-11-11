package com.waihon.designpatterns.mosh.proxy.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.Assertions.assertThat;

class ProductProxyTest {
    private DbContext dbContext;
    private Product product;

    @BeforeEach
    void setUp() {
        dbContext = new DbContext();
        product = dbContext.getProduct(1);
    }

    @Test
    void updateProductName() throws Exception {
        var text = tapSystemOut(() -> {
            product.setName("Updated Name");
            dbContext.saveChanges();

            product.setName("Another Name");
            dbContext.saveChanges();
        });

        assertThat(text.lines())
                .contains(
                        "UPDATE products SET name = 'Updated Name' WHERE product_id = 1",
                        "UPDATE products SET name = 'Another Name' WHERE product_id = 1"
                );
    }
}
