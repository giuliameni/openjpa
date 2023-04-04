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
public class ClassUtilObjectTest {
    
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { "java.lang.String", false },
            { "java.lang.Integer", true }
        });
    }
    
    private String className;
    private boolean initialize;
    
    public ClassUtilObjectTest(String className, boolean initialize) {
        this.className = className;
        this.initialize = initialize;
    }
    
    @Test
    public void testToClassWithObject() {
        Class<?> clazz = ClassUtil.toClass(className, initialize, getClass().getClassLoader());
        assertEquals(className, clazz.getName());
    }
}