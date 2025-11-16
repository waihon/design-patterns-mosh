package com.waihon.designpatterns.mosh.factorymethod.demo;

import com.waihon.designpatterns.mosh.factorymethod.demo.viewengine.SharpController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SharpProductsController extends SharpController {
    public void listProducts() {
        // Simulate getting products from a database
        List<String> products = List.of("iPhone", "iWatch", "iPad");

        Map<String, Object> context = new HashMap<>();
        context.put("products", products);

        render("products.html", context);
    }
}
