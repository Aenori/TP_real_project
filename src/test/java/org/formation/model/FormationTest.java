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

	public void testIsRemboursee() {
		assertTrue(new Formation("20210601",null, null, 250, "Remboursee","Original", 666).isRemboursee());
		assertFalse(new Formation("20210602",null, null, 700, "Annulee","Original", 333).isRemboursee());

	
	public void testIsFusionnee() {
		assertFalse(new Formation("20210528",  null, null,300,"Active","Original",1).isFusionnee());
		assertTrue(new Formation("20210528",  null, null,300,"Fusionnee","Original",1).isFusionnee());
	}

	public void testIsAnnulee() {
		assertFalse(new Formation("20210528",  null, null,300,"Active","Original",1).isAnnulee());
		assertTrue(new Formation("20210528",  null, null,300,"Annulee","Original",1).isAnnulee());
	}
}
