package com.waihon.designpatterns.mosh.decorator.demo;

public class EncryptedStream implements Stream {
    private Stream stream;

    public EncryptedStream(Stream stream) {
        this.stream = stream;
    }

    @Override
    public void write(String data) {
        var encrypted = encrypt(data);

        stream.write(encrypted);
    }

    private String encrypt(String data) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            c = (char)(c + 11);
            sb.append(c);
        }

        return sb.toString();
    }
}
