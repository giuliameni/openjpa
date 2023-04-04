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
public class ClassUtilInvalidClassNameTest {

    private final String className;
    private final ClassLoader classLoader;

    public ClassUtilInvalidClassNameTest(String className, ClassLoader classLoader) {
        this.className = className;
        this.classLoader = classLoader;
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"com.example.DoesNotExist", MyClassUtilTest.class.getClassLoader()},
                {"nonexistent.package.NonexistentClass", null},
                {"", MyClassUtilTest.class.getClassLoader()}
        });
    }

    @Test
    public void testToClassWithInvalidClassName() {
        try {
            ClassUtil.toClass(className, false, classLoader);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains(className));
        }
    }
}