package com.waihon.designpatterns.mosh.builder.exercise.text;

import com.waihon.designpatterns.mosh.builder.exercise.Element;
import com.waihon.designpatterns.mosh.builder.exercise.Text;

import java.util.List;

public class TextDocument {
    private StringBuilder builder = new StringBuilder();

    public void append(String text) {
        String str;
        if (builder.length() == 0) {
            str = text;
        } else {
            str = "\n" + text;
        }

        builder.append(str);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
