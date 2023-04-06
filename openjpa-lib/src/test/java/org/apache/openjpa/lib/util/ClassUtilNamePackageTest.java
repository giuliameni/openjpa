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
public class ClassUtilNamePackageTest {

    private final String input;
    private final String expectedOutput;

    public ClassUtilNamePackageTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"", ""},
                {"int", ""},
                {"[I", ""},
                {"MyClass", ""},
                {"com.example.MyClass", "com.example"},
                {"com.example.MyClass$InnerClass", "com.example"}
        });
    }

    @Test
    public void testGetPackageName() {
        assertEquals(expectedOutput, ClassUtil.getPackageName(input));
    }
}


/*Questo test definisce una serie di casi di test per il metodo ClassUtil.getPackageName(String) che verifica che il metodo restituisca correttamente il nome del package di una classe data in input.

Il test definisce un array bidimensionale di oggetti, dove ogni riga rappresenta un caso di test specifico e ha due elementi: il primo è una stringa che rappresenta il nome della classe di input, il secondo è una stringa che rappresenta il nome del package atteso per la classe di input.

Il metodo testGetPackageName() esegue il test effettivo, chiamando il metodo ClassUtil.getPackageName() con l'input specificato e verificando che l'output sia uguale all'output atteso. Il test viene eseguito per ogni caso di test definito nell'array di dati.*/