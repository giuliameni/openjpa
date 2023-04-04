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
public class QualifiedDBIdentifierUnqualifiedTest {

    private final QualifiedDBIdentifier qualifiedIdentifier;
    private final boolean expectedUnqualifiedObject;

    public QualifiedDBIdentifierUnqualifiedTest(QualifiedDBIdentifier qualifiedIdentifier, boolean expectedUnqualifiedObject) {
        this.qualifiedIdentifier = qualifiedIdentifier;
        this.expectedUnqualifiedObject = expectedUnqualifiedObject;
    }

    @Parameters
    public static Collection<Object[]> data() {
        // Test with an unqualified identifier
        DBIdentifier identifier = DBIdentifier.newColumn("my_column");
        QualifiedDBIdentifier qualifiedIdentifier = QualifiedDBIdentifier.getPath(identifier);
        Object[] testData1 = {qualifiedIdentifier, true};

        
        DBIdentifier tableIdentifier = DBIdentifier.newTable("my_table");
        DBIdentifier columnIdentifier = DBIdentifier.newColumn("my_column");
        

        // Test with a schema-qualified identifier
        DBIdentifier schemaIdentifier = DBIdentifier.newSchema("my_schema");
        tableIdentifier = DBIdentifier.newTable("my_table");
        columnIdentifier = DBIdentifier.newColumn("my_column");
        qualifiedIdentifier = QualifiedDBIdentifier.newPath(schemaIdentifier, tableIdentifier, columnIdentifier);
        Object[] testData3 = {qualifiedIdentifier, false};

        // Test with a qualified identifier starting with a schema identifier
        schemaIdentifier = DBIdentifier.newSchema("my_schema");
        tableIdentifier = DBIdentifier.newTable("my_table");
        columnIdentifier = DBIdentifier.newColumn("my_column");
        qualifiedIdentifier = QualifiedDBIdentifier.newPath(schemaIdentifier, tableIdentifier, columnIdentifier);
        Object[] testData4 = {qualifiedIdentifier, false};

        // Test with a qualified identifier starting with a table identifier
        tableIdentifier = DBIdentifier.newTable("my_table");
        columnIdentifier = DBIdentifier.newColumn("my_column");
        qualifiedIdentifier = QualifiedDBIdentifier.newPath(tableIdentifier, columnIdentifier);
        Object[] testData5 = {qualifiedIdentifier, true};

        return Arrays.asList(new Object[][]{
                testData1,
                testData3,
                testData4,
                testData5
        });
    }

    @Test
    public void testIsUnqualifiedObject() {
        assertEquals(expectedUnqualifiedObject, qualifiedIdentifier.isUnqualifiedObject());
    }
}