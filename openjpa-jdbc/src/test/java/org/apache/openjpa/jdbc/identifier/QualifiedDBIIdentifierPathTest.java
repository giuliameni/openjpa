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
public class QualifiedDBIIdentifierPathTest {
    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            // Test case 1: Non-qualified DBIdentifier
            { DBIdentifier.newTable("my_table"), QualifiedDBIdentifier.newPath(DBIdentifier.newTable("my_table")) },
            // Test case 2: Qualified DBIdentifier
            { QualifiedDBIdentifier.newTable("my_schema"), QualifiedDBIdentifier.newTable("my_schema") },
            // Test case 3: Non-qualified DBIdentifier with schema name
            { DBIdentifier.newTable("table"), QualifiedDBIdentifier.newPath(DBIdentifier.newTable("table")) },
            // Test case 4: Qualified DBIdentifier with dot in name
            { QualifiedDBIdentifier.newTable("my.schema.table"), QualifiedDBIdentifier.newTable("my.schema.table") },
            // Test case 5: Non-qualified DBIdentifier with empty name
            { DBIdentifier.newTable(""), QualifiedDBIdentifier.newPath(DBIdentifier.newTable("")) },
            // Test case 6: Qualified DBIdentifier with empty name
            { QualifiedDBIdentifier.newTable(""), QualifiedDBIdentifier.newTable("") },
            // Test case 7: Non-qualified DBIdentifier with null name
            { DBIdentifier.newTable(null), QualifiedDBIdentifier.newPath(DBIdentifier.newTable(null)) }
        });
    }
    
    private DBIdentifier input;
    private QualifiedDBIdentifier expected;
    
    public QualifiedDBIIdentifierPathTest(DBIdentifier input, QualifiedDBIdentifier expected) {
        this.input = input;
        this.expected = expected;
    }
    
    @Test
    public void testGetPath() {
        QualifiedDBIdentifier result = QualifiedDBIdentifier.getPath(input);
        assertEquals(expected, result);
    }
    
}
