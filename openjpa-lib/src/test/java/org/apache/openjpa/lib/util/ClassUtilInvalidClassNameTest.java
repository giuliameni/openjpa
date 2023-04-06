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
                {"com.example.DoesNotExist", ClassUtilGetClassNameNewTest.class.getClassLoader()},
                {"nonexistent.package.NonexistentClass", null},
                {"", ClassUtilGetClassNameNewTest.class.getClassLoader()}
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

/*Questo test verifica il comportamento del metodo toClass della classe ClassUtil quando viene passato un nome di classe non valido come parametro. Il test utilizza l'annotazione @RunWith(Parameterized.class) per eseguire il test con più set di dati, specificati nel metodo testData(). Per ogni set di dati, il test crea un'istanza di ClassUtilInvalidClassNameTest con il nome della classe e il ClassLoader specificati, e poi chiama il metodo toClass passando tali valori. Infine, il test verifica se viene sollevata un'eccezione IllegalArgumentException come previsto e se il messaggio di errore contiene il nome della classe non valida.*/