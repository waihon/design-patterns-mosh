package com.waihon.designpatterns.mosh.chainofresponsibility;

public class Authenticator extends Handler {
    public Authenticator(Handler next) {
        super(next);
    }

    @Override
    public boolean doHandle(HttpRequest request) {
        if (request == null) return true;

        System.out.println("Authentication");

        var isValid = request.getUsername().equals("admin") &&
                request.getPassword().equals("correct");

        // To continue with the processing pipeline if credentials is valid
        return !isValid;
    }
}
