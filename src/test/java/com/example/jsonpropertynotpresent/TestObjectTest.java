package com.example.jsonpropertynotpresent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class TestObjectTest {

    @Autowired
    private JacksonTester<TestObject> tester;

    @Test
    void testJsonWithNull_hasEmptyJsonPathValue() throws IOException {
        JsonContent<TestObject> content = tester.write(new TestObject(null));
        assertThat(content).hasEmptyJsonPathValue("testProperty");
    }

    @Test
    void testJsonWithNull_doesNotContain() throws IOException {
        JsonContent<TestObject> content = tester.write(new TestObject(null));
        assertThat(content.toString()).doesNotContain("testProperty");
    }

    @Test
    void testJsonWithTrue() throws IOException {
        JsonContent<TestObject> content = tester.write(new TestObject(true));
        assertThat(content).hasJsonPathBooleanValue("testProperty", true);
    }

    @Test
    void testJsonWithFalse() throws IOException {
        JsonContent<TestObject> content = tester.write(new TestObject(false));
        assertThat(content).hasJsonPathBooleanValue("testProperty", false);
    }
}
