package org.formation.model;

import junit.framework.TestCase;

public class SujetTest extends TestCase {
	public void testToString()
	{     
        assertEquals(
        	"Sujet;1;Java",
        	(new Sujet("Java",Long.valueOf(1))).toString()
        );
    }
}
