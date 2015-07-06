package nl.rsvier.icaras.service.relatiebeheer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.AdresType;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:icarastestdb-context.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class AdresTypeServiceTest {

	@Autowired
	private AdresTypeService service;
	
	private List<AdresType> lijst;
	
	@Before
	public void setUp() {
		lijst = service.getAllTypes();
	}
	@Test
	@Transactional
	public void testGetAllTypes() {
		List<AdresType> lijst2 = service.getAllTypes();
		
		assertTrue("lijst is niet null", (lijst2.size() > 0));
	}
	
	@Test
	@Transactional
	public void testSave() {
		AdresType type = new AdresType();
		type.setType("test");
		service.save(type);
		
		assertFalse("test niet in lijst", lijst.contains(type));
		List<AdresType> lijst2 = service.getAllTypes();
		assertTrue("test is toegevoegd", lijst2.contains(type));
	}
	
	@Test
	@Transactional
	public void testSaveAll() {
		int oldSize = lijst.size();
		AdresType type = new AdresType();
		type.setType("test");
		
		AdresType type2 = new AdresType();
		type.setType("test2");
		
		lijst.add(type);
		lijst.add(type2);
		
		service.updateList(lijst);
		
		List<AdresType> lijst2 = service.getAllTypes();
		assertTrue("lijst2 is langer dan lijst1", lijst.size() > oldSize);
		assertTrue("test1 is toegevoegd", lijst2.contains(type));
		assertTrue("test2 is toegevoegd", lijst2.contains(type2));
		
	}

}
