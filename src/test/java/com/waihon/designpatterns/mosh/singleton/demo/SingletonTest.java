package com.waihon.designpatterns.mosh.singleton.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SingletonTest {
    private ConfigManager manager1;
    private ConfigManager manager2;
    private final String NAME = "John Doe";

    @BeforeEach
    void setUp() {
        manager1 = ConfigManager.getInstance();
        manager2 = ConfigManager.getInstance();
    }

    @Test
    void setAndGetUsingDifferentManger() {
        manager1.set("name", NAME);

        assertThat(manager2.get("name")).isEqualTo(NAME);
    }
}
