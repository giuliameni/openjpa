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
public class QualifiedDBIIdentifierDelimitedTest {

    private final DBIdentifier dbIdentifier;
    private final boolean expectedDelimited;

    public QualifiedDBIIdentifierDelimitedTest(DBIdentifier dbIdentifier, boolean expectedDelimited) {
        this.dbIdentifier = dbIdentifier;
        this.expectedDelimited = expectedDelimited;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {DBIdentifier.newTable("my_table"), false},
                {DBIdentifier.newTable("my_schema.my_table"), false},
                {DBIdentifier.newTable("\"my_schema\".\"my_table\""), true},
                {DBIdentifier.newTable("[my_schema].[my_table]"), true}
        });
    }

    @Test
    public void testIsDelimited() {
        assertEquals(expectedDelimited, QualifiedDBIdentifier.getPath(dbIdentifier).isDelimited());
    }
}
