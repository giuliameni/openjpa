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
public class ClassUtilGetClassNameTest {

    private final Class<?> inputClass;
    private final String expectedOutput;

    public ClassUtilGetClassNameTest(Class<?> inputClass, String expectedOutput) {
        this.inputClass = inputClass;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {null, null},
                {String[][].class, "String[][]"},
                {List.class, "List"},
                {Object.class, "Object"},
                {Map.Entry.class, "Map$Entry"}
        });
    }

    @Test
    public void testGetClassNameFromClass() {
        assertEquals(expectedOutput, ClassUtil.getClassName(inputClass));
    }

    
}

/*Il secondo test (ClassUtilGetClassNameTest), invece, testa 
 * il metodo getClassName(Class<?> clazz) della stessa classe 
 * ClassUtil, che ha il compito di estrarre il nome della classe 
 * a partire dalla classe stessa (clazz), restituendo solo il nome 
 * della classe senza il package. Il test utilizza l'annotazione 
 * @RunWith(Parameterized.class) per eseguire lo stesso test 
 * su una serie di input diversi, passati come parametri nella
 *  collezione restituita dal metodo testData().
 */

