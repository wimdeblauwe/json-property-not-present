package com.example.jsonpropertynotpresent;

import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestObject {
    private final Boolean testProperty;

    public TestObject(Boolean testProperty) {
        this.testProperty = testProperty;
    }

    public Boolean getTestProperty() {
        return testProperty;
    }
}
