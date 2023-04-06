package org.apache.openjpa.lib.util;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.apache.openjpa.lib.util.ClassUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ClassUtilGetClassNameNewTest {
	
    private final String fullName;
    private final String expectedClassName;

    public ClassUtilGetClassNameNewTest(String fullName, String expectedClassName) {
        this.fullName = fullName;
        this.expectedClassName = expectedClassName;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
            { "java.lang.String", "String" },
            { "java.util.Map.Entry", "Entry" },
            { "[Ljava.lang.String;", "String[]" },
            { "[[[I", "int[][][]" },
            { "[[[Ljava.util.Map.Entry;", "Entry[][][]" },
            { "", "" },
            { null, null },
            { "int", "int" },
            { "com.example.MyClass", "MyClass"}
            
        });
    }

    @Test
    public void testGetClassName() {
        assertEquals(expectedClassName, ClassUtil.getClassName(fullName));
    }

}
/*Questo è un test della classe ClassUtil della libreria OpenJPA. 
 * In particolare, si testa il metodo getClassName(String fullName) della classe. Il test utilizza l'annotazione @RunWith(Parameterized.class) per eseguire lo stesso test su una serie di input diversi, passati come parametri nella collezione restituita dal metodo data().

Ogni elemento della collezione è un array di due oggetti: 
una stringa rappresentante il nome completo della classe e 
una stringa contenente il nome atteso della classe (senza il package).
 Il test verifica che, per ciascun input, il metodo getClassName() restituisca il nome atteso
  della classe. In altre parole, il test verifica che il metodo ClassUtil.getClassName() sia 
  in grado di estrarre il nome della classe a partire dal suo nome completo 
(fullName) restituendo solo il nome della classe (expectedClassName) senza il package.*/