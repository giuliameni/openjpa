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
public class ClassUtilPrimitiveArrayTest {

    private final String className;
    private final Class<?> expectedClass;

    public ClassUtilPrimitiveArrayTest(String className, Class<?> expectedClass) {
        this.className = className;
        this.expectedClass = expectedClass;
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"int[]", int[].class},
                {"boolean[]", boolean[].class},
                {"long[]", long[].class},
                {"short[]", short[].class},
                {"byte[]", byte[].class},
                {"double[]", double[].class},
                {"float[]", float[].class},
                {"char[]", char[].class},
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
    public void testToClassWithPrimitiveArrayType() {
        Class<?> clazz = ClassUtil.toClass(className, false, ClassUtilGetClassNameNewTest.class.getClassLoader());
        assertEquals(expectedClass, clazz);
    }
}

/*Il test ClassUtilPrimitiveArrayTest verifica la corretta conversione del nome di un array di tipo primitivo in una classe utilizzando il metodo ClassUtil.toClass(). Il test definisce una serie di casi di test che includono diversi tipi di array di tipo primitivo e i corrispondenti tipi di classe. Ogni caso di test chiama il metodo toClass() e verifica che il risultato sia uguale al valore atteso. Il test è eseguito in modalità parametrica, utilizzando l'annotazione @RunWith(Parameterized.class) e i parametri di input sono definiti nel metodo testData().*/