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
                {ClassUtilGetClassNameNewTest.class, "org.apache.openjpa.lib.util"},
                {int.class, ""}
        });
    }

    @Test
    public void testGetPackageNameFromClass() {
        assertEquals(expectedOutput, ClassUtil.getPackageName(input));
    }
}

/*Questo test verifica il comportamento del metodo ClassUtil.getPackageName() della classe org.apache.openjpa.lib.util.ClassUtil. Il test utilizza l'annotazione @RunWith(Parameterized.class) per eseguire lo stesso test su diversi input passati come parametri nella collezione restituita dal metodo testData().

Ogni elemento della collezione è un array di due oggetti: una classe Class<?> e una stringa contenente il nome del package atteso. Il test verifica che, per ciascun input, il metodo getPackageName() restituisca il nome atteso del package a cui appartiene la classe.

In altre parole, il test verifica che il metodo ClassUtil.getPackageName() sia in grado di estrarre il nome del package a partire dalla classe passata come input.*/