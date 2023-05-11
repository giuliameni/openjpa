package org.apache.openjpa.lib.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ClassUtilGetPackageTest {

    private final String input;
    private final String expectedOutput;

    public ClassUtilGetPackageTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"","" },
                {"int", ""},
                {"[I", ""},
                {"MyClass", ""},
                {"com.example.MyClass", "com.example"},
                {"com.example.MyClass$InnerClass", "com.example"},
                {null, null},
                {"[Lcom.example.MyClass;", "com.example"},
                {"com.example.MyC", "com.example"},
                
        });
    }

    @Test
    public void testGetPackageName() {
        assertEquals(expectedOutput, ClassUtil.getPackageName(input));
    }
    @Test
    public void testGetPackageNameReturnsFullNameIfEmpty() {
        String fullName = "";
        String expected = fullName;
        String result = ClassUtil.getPackageName(fullName);
        assertEquals(expected, result);
    }
    
    


    

    
    
    
    
    
    

    
    

    






    


}
