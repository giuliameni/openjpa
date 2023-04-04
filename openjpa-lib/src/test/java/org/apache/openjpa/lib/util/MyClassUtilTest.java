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
public class MyClassUtilTest {
    
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { null, null },
            { "", "" },
            { "int", "int" },
            { "java.lang.String", "String" },
            { "com.example.MyClass", "MyClass" }
        });
    }
    
    private String classPath;
    private String expectedName;
    
    public MyClassUtilTest(String classPath, String expectedName) {
        this.classPath = classPath;
        this.expectedName = expectedName;
    }
    
    @Test
    public void getClassNameTest() {
        String className = ClassUtil.getClassName(classPath);
        assertEquals(expectedName, className);
    }
}

    
    
    
    


    
    




    
    
