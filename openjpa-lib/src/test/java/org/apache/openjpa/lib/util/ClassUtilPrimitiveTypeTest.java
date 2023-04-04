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
public class ClassUtilPrimitiveTypeTest {

    private final String className;
    private final Class<?> expectedClass;

    public ClassUtilPrimitiveTypeTest(String className, Class<?> expectedClass) {
        this.className = className;
        this.expectedClass = expectedClass;
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"int", int.class},
                {"boolean", boolean.class},
                {"long", long.class},
                {"short", short.class},
                {"byte", byte.class},
                {"double", double.class},
                {"float", float.class},
                {"char", char.class}
        });
    }

    @Test
    public void testToClassWithPrimitiveType() {
        Class<?> clazz = ClassUtil.toClass(className, false, MyClassUtilTest.class.getClassLoader());
        assertEquals(expectedClass, clazz);
    }
}