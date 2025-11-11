package com.waihon.designpatterns.mosh.proxy.solution;

public class ProductProxy extends Product {
    private DbContext dbContext;

    public ProductProxy(int id, DbContext dbContext) {
        super(id);
        this.dbContext = dbContext;
    }

    @Override
    public void setName(String name) {
        super.setName(name);

        dbContext.markAsChanged(this);
    }
}
