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
public class ClassUtilGetPackageFromClassTest {

    private final Class<?> input;
    private final String expectedOutput;

    public ClassUtilGetPackageFromClassTest(Class<?> input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {String.class, "java.lang"},
                {MyClassUtilTest.class, "org.apache.openjpa.lib.util"},
                {int.class, ""}
        });
    }

    @Test
    public void testGetPackageNameFromClass() {
        assertEquals(expectedOutput, ClassUtil.getPackageName(input));
    }
}