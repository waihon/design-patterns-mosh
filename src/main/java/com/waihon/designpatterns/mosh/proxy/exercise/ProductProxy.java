package com.waihon.designpatterns.mosh.proxy.exercise;

public class ProductProxy implements Product {
    private int id;
    private String name;
    private RealProduct product;
    private DbContext dbContext;

    public ProductProxy(int id, DbContext dbContext) {
        this.id = id;
        this.dbContext = dbContext;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return CurrentProduct().getName();
    }

    @Override
    public void setName(String name) {
        var product = CurrentProduct();
        product.setName(name);
        CurrentContext().markAsChanged(product);
    }

    private DbContext CurrentContext() {
        if (dbContext == null) {
            dbContext = new DbContext();
        }

        return dbContext;
    }

    private RealProduct CurrentProduct() {
        if (product == null) {
            product = CurrentContext().getProduct(id);
        }

        return product;
    }
}
