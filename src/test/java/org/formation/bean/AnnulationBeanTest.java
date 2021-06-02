package org.formation.bean;

import java.util.ArrayList;
import java.util.List;

import org.formation.model.Formation;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class AnnulationBeanTest extends TestCase {
	
	public void testGetAllAnnulee() {
		assertEquals(1, AnnulationBean.selectAnnulation().size());
	}
	
	public void testMockGetAllAnnulee(){     
		// NRO-example : mocking static method
        try (MockedStatic<Formation> utilities = Mockito.mockStatic(Formation.class)) {
        	List<Formation> formationsAnnulees = new ArrayList<Formation>();
        	formationsAnnulees.add(new Formation("20211031",null,null,10,"Annulee","Original",3));
        	formationsAnnulees.add(new Formation("20211221",null,null,10,"Annulee","Original",7));
        	utilities.when(Formation::getAll).thenReturn(formationsAnnulees);
            
            assertEquals(2, AnnulationBean.selectAnnulation().size());
        }
	}

}