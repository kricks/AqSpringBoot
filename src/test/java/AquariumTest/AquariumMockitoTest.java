package AquariumTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import mvc.entity.aquarium.AquariumImpl;
import mvc.entity.aquarium.AquariumView;
import mvc.manager.aquarium.AquariumManagerImpl;
import mvc.service.aquarium.AquariumServiceImpl;

public class AquariumMockitoTest {
	@Mock
	AquariumServiceImpl aqService;

	@InjectMocks
	AquariumManagerImpl aqManager;

	@BeforeTest
	public void beforeTest() {
		MockitoAnnotations.initMocks(this);
	}

	private Date date = new Date();

	@Test
	public void testGetAllAquariums() {
		List<AquariumImpl> aqImplList = aqImplDummyData();
		Mockito.when(aqService.getAll()).thenReturn(aqImplList);
		List<AquariumView> aqViewList = aqManager.getAll();
		assertEquals(aqViewList.size(), aqImplList.size());
	}

	@Test
	public void testGetAquariumById() {
		AquariumImpl aqImplItem = aqImplSingleItem();
		Integer aquariumId = aqImplItem.getAquariumId();
		Mockito.when(aqService.getAquariumById(aquariumId)).thenReturn(aqImplItem);
		AquariumView aqViewItem = aqManager.getAquariumById(aquariumId);
		assertEquals(aqViewItem.getName(), "Clown Tank");
	}

	@Test
	public void testSaveAquarium() {
		AquariumImpl aqImpl = aqImplSingleItem();
		Integer aquariumId = aqImpl.getAquariumId();
		Mockito.when(aqService.saveAquarium(Mockito.any(AquariumImpl.class))).thenReturn(aqImpl);
		aqService.saveAquarium(aqImpl);
		AquariumView aqViewItem = aqManager.getAquariumById(aquariumId);
		assertEquals(aqViewItem.getName(), "Clown Tank");
	}

	@Test
	public void testDeleteAquariumById() {
		AquariumImpl aqImplItem = aqImplSingleItem();
		Integer aquariumId = aqImplItem.getAquariumId();
		Mockito.when(aqService.deleteAquariumById(aquariumId)).thenReturn(aquariumId);
		aqService.deleteAquariumById(aquariumId);
		verify(aqService, times(1)).deleteAquariumById(aquariumId);
	}

	private List<AquariumImpl> aqImplDummyData() {
		List<AquariumImpl> aqImplList = new ArrayList<>();
		aqImplList.add(new AquariumImpl(200, "Clown Tank", "Salt Water", 50, "Living Room", date));
		aqImplList.add(new AquariumImpl(201, "Coral Reef", "Salt Water", 75, "Study", date));
		aqImplList.add(new AquariumImpl(202, "Pico Tank", "Fresh Water", 5, "Kitchen", date));
		return aqImplList;
	}

	private AquariumImpl aqImplSingleItem() {
		AquariumImpl aqImplItem = new AquariumImpl();
		aqImplItem.setAquariumId(200);
		aqImplItem.setName("Clown Tank");
		aqImplItem.setType("Salt Water");
		aqImplItem.setGallon(50);
		aqImplItem.setNotes("Living Room");
		aqImplItem.setDate(date);
		return aqImplItem;
	}

	@AfterTest
	public void afterTest() {

	}
}
