package org.formation.model;

import java.util.List;
import junit.framework.TestCase;


public class FormationTest extends TestCase {
	public void testToString()
	{     
        assertEquals(
        	"Formation;20210528;NULL;1;300;Active;Original;NULL",
        	(new Formation(
        		"20210528", 
        		null, 
        		null,
        		300,
        		"Active",
        		"Original",
        		1
        	)).toString()
        );
    }
	
	public void testGetAll() {
		// What we are mainly testing here is that the method call doesn't raise
		// an error
		assertTrue(Formation.getAll() instanceof List<?>);
	}
	

	public void testhasFormateurRemplace() {
		 
		Formation test = new Formation();
		assertTrue(test.hasFormateurRemplace("Annulé"));
		
	
}
	
}
