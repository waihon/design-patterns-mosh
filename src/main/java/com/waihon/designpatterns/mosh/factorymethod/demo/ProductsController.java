package com.waihon.designpatterns.mosh.factorymethod.demo;

import com.waihon.designpatterns.mosh.factorymethod.demo.viewengine.Controller;
import com.waihon.designpatterns.mosh.factorymethod.demo.viewengine.ViewEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsController extends Controller {
    public void listProducts() {
        // Simulate getting products from a database
        List<String> products = List.of("iMac", "MacBook Pro", "Mac Studio");

        Map<String, Object> context = new HashMap<>();
        context.put("products", products);

        render("products.html", context);
    }
}
