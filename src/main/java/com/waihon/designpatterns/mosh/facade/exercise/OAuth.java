package com.waihon.designpatterns.mosh.facade.exercise;

public class OAuth {
    public String requestToken(String appKey, String appsecret) {
        System.out.println("Getting a request token...");

        return "requestToken";
    }

    public String accessToken(String requestToken) {
        System.out.println("Getting an access token...");

        return "accessToken";
    }
}
