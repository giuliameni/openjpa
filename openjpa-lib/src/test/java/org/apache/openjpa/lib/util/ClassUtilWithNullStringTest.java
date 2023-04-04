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
public class ClassUtilWithNullStringTest {

    private final ClassLoader classLoader;

    public ClassUtilWithNullStringTest(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Parameters
    public static Collection<ClassLoader> testData() {
        return Arrays.asList(
                null,
                ClassUtil.class.getClassLoader()
        );
    }

    @Test
    public void testToClassWithNullString() {
        try {
            ClassUtil.toClass(null, false, classLoader);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            assertEquals("str == null", e.getMessage());
        }
    }
}