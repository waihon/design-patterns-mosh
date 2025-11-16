package com.waihon.designpatterns.mosh.factorymethod.demo.viewengine;

public class SharpController extends Controller {
    @Override
    protected ViewEngine createVieweEngine() {
        return new SharpViewEngine();
    }
}
