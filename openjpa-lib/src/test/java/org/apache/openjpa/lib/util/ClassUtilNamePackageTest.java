package org.apache.openjpa.lib.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ClassUtilNamePackageTest {

    private final String input;
    private final String expectedOutput;

    public ClassUtilNamePackageTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"", ""},
                {"int", ""},
                {"[I", ""},
                {"MyClass", ""},
                {"com.example.MyClass", "com.example"},
                {"com.example.MyClass$InnerClass", "com.example"}
        });
    }

    @Test
    public void testGetPackageName() {
        assertEquals(expectedOutput, ClassUtil.getPackageName(input));
    }
}
