package org.apache.openjpa.lib.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(Parameterized.class)
public class ClassUtilGetClassNameStringTest {

    private final String input;
    private final String expectedOutput;

    public ClassUtilGetClassNameStringTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, null},
                {"", ""},
                {"int", "int"},
                {"java.lang.String", "String"},
                {"[Lorg.example.MyClass;", "MyClass[]"},
                {"[Lorg.example.MyClass[][]", "MyClass[][][]"},
                {"[Ljava.lang.Object;", "Object[]"},
                {"[B", "byte[]"},
                {"[C", "char[]"},
                {"[D", "double[]"},
                {"[F", "float[]"},
                {"[I", "int[]"},
                {"[J", "long[]"},
                {"[S", "short[]"},
                { "java.util.Map.Entry", "Entry" },
                { "[[[I", "int[][][]" },
                { "[[[Ljava.util.Map.Entry;", "Entry[][][]" },
        });
    }

    @Test
    public void testGetClassName() {
        assertEquals(expectedOutput, ClassUtil.getClassName(input));
        String test = null;
        assertNull(ClassUtil.getClassName(test));
    }
    

    
}
