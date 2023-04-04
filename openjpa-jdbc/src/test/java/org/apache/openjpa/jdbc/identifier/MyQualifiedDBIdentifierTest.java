package org.apache.openjpa.jdbc.identifier;

import org.apache.openjpa.jdbc.identifier.DBIdentifier.DBIdentifierType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MyQualifiedDBIdentifierTest {

    private boolean output;
    private DBIdentifier identifier ;

    @Parameters
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][]{
        	{ false , null },
            { true  , DBIdentifier.newTable("Schema.Table")},
            { false , QualifiedDBIdentifier.newPath( DBIdentifier.NULL )  }
        });
    }

    public MyQualifiedDBIdentifierTest(boolean output , DBIdentifier identifier ){
        this.output = output;
        this.identifier = identifier;    
    }
    
   


    @Test
    public void splitPathTest() {
        DBIdentifier[] path = QualifiedDBIdentifier.splitPath(identifier);
        int expectedLength = output ? 2 : 0;
        assertEquals(expectedLength, path.length);
    }
    
   
    
    
   
    
    @Test
    public void testCompareTo() {
        DBIdentifier id1 = DBIdentifier.newTable("id1");
        DBIdentifier id2 = DBIdentifier.newTable("id2");
        QualifiedDBIdentifier qid1 = QualifiedDBIdentifier.newPath(id1);
        QualifiedDBIdentifier qid2 = QualifiedDBIdentifier.newPath(id2);
        QualifiedDBIdentifier qid3 = QualifiedDBIdentifier.newPath(id1, id2);

        // Compare same object
        assertEquals(0, qid1.compareTo(qid1));

        // Compare different objects
        assertNotEquals(0, qid1.compareTo(qid2));
        assertNotEquals(0, qid1.compareTo(qid3));
    }

    
    
    @Test
    public void testLengthWithNull() {
        QualifiedDBIdentifier qualifiedDBIdentifier = QualifiedDBIdentifier.newPath(null);
        assertEquals(0, qualifiedDBIdentifier.length());
    }
    
    

    
    
   

    
    
    
    
}