package org.apache.openjpa.jdbc.identifier;

import org.apache.openjpa.jdbc.identifier.DBIdentifier;
import org.apache.openjpa.jdbc.identifier.QualifiedDBIdentifier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class QualifiedDBIdentifierEqualNewTest {
    
    @Parameters
    public static Collection<Object[]> data() {
        DBIdentifier schema = DBIdentifier.newSchema("schema");
        QualifiedDBIdentifier path = QualifiedDBIdentifier.newPath(schema, DBIdentifier.newTable("table"));
        String pathString = schema.toString() + "." + DBIdentifier.newTable("table").toString();
        
        return Arrays.asList(new Object[][] {
            { path, schema, false },
            { path, pathString, true }
        });
    }
    
    private QualifiedDBIdentifier identifier1;
    private Object identifier2;
    private boolean expectedEquality;
    
    public QualifiedDBIdentifierEqualNewTest(QualifiedDBIdentifier identifier1, Object identifier2, boolean expectedEquality) {
        this.identifier1 = identifier1;
        this.identifier2 = identifier2;
        this.expectedEquality = expectedEquality;
    }
    
    @Test
    public void testEquals() {
        boolean actualEquality = identifier1.equals(identifier2);
        assertEquals(expectedEquality, actualEquality);
    }
    
}
