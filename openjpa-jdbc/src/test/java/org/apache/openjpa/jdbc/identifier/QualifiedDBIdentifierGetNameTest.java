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
public class QualifiedDBIdentifierGetNameTest {
    private final QualifiedDBIdentifier identifier;
    private final String expectedName;

    public QualifiedDBIdentifierGetNameTest(QualifiedDBIdentifier identifier, String expectedName) {
        this.identifier = identifier;
        this.expectedName = expectedName;
    }

    @Parameters(name = "{index}: getName({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {QualifiedDBIdentifier.newPath(DBIdentifier.newColumn("id")), "id"},
                {QualifiedDBIdentifier.newPath(DBIdentifier.newSchema("public"), DBIdentifier.newColumn("id")), "public.id"},
                {QualifiedDBIdentifier.newPath(DBIdentifier.newTable("users"), DBIdentifier.newColumn("id")), "users.id"},
                {QualifiedDBIdentifier.newPath(DBIdentifier.newSchema("public"), DBIdentifier.newTable("users"), DBIdentifier.newColumn("id")), "public.users.id"}
        });
    }

    @Test
    public void testGetName() {
        String name = identifier.getName();
        assertEquals(expectedName, name);
    }
}