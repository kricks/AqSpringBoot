package LivestockTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import mvc.entity.livestock.LivestockImpl;
import mvc.entity.livestock.LivestockView;
import mvc.manager.livestock.LivestockManagerImpl;
import mvc.service.livestock.LivestockServiceImpl;

public class LivestockMockitoTest {
	@Mock
	LivestockServiceImpl lsService;

	@InjectMocks
	LivestockManagerImpl lsManager;

	@BeforeTest
	public void beforeTest() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAll() {
		List<LivestockImpl> lsImplList = livestockDummyData();
		Mockito.when(lsService.getAll()).thenReturn(lsImplList);
		List<LivestockView> lsViewList = lsManager.findAllLivestock();
		assertEquals(lsViewList.size(), lsImplList.size());
	}

	@Test
	public void testGetLivestockById() {
		LivestockImpl lsImplItem = lsImplSingleItem();
		Integer livestockId = lsImplItem.getLivestockId();
		Mockito.when(lsService.getLivestockById(livestockId)).thenReturn(lsImplItem);
		LivestockView lsViewItem = lsManager.findById(livestockId);
		assertEquals(lsViewItem.getName(), "Peach");
	}

	@Test
	public void testGetLivestockListByFkAquariumId() {
		List<LivestockImpl> lsList = livestockDummyData();
		LivestockImpl lsImplItem = lsImplSingleItem();
		Integer fkAquariumId = lsImplItem.getFkAquariumId();
		Mockito.when(lsService.getLivestockByFkAquariumId(fkAquariumId)).thenReturn(lsList);
		List<LivestockView> lsViewList = lsManager.findLivestockByFkAquariumId(fkAquariumId);
		assertEquals(lsViewList.get(1).getFkAquariumId(), lsList.get(1).getFkAquariumId());
	}

	@Test
	public void testSaveLivestock() {
		LivestockImpl lsImplItem = lsImplSingleItem();
		Integer livestockId = lsImplItem.getLivestockId();
		Mockito.when(lsService.saveLivestock(Mockito.any(LivestockImpl.class))).thenReturn(lsImplItem);
		lsService.saveLivestock(lsImplItem);
		LivestockView lsViewItem = lsManager.findById(livestockId);
		assertEquals(lsViewItem.getName(), "Peach");
	}

	@Test
	public void testDeleteLivestockById() {
		LivestockImpl lsImplItem = lsImplSingleItem();
		Integer livestockId = lsImplItem.getLivestockId();
		lsService.deleteLivestockById(livestockId);
		verify(lsService, times(1)).deleteLivestockById(livestockId);
	}

	private List<LivestockImpl> livestockDummyData() {
		List<LivestockImpl> lsImplList = new ArrayList<>();
		lsImplList.add(new LivestockImpl(1, "Dory", "Blue Tang", "Female", "Forgetful", 200));
		lsImplList.add(new LivestockImpl(2, "Merlin", "Clown Fish", "Male", "Nemo's Dad", 200));
		lsImplList.add(new LivestockImpl(3, "Nemo", "Clown Fish", "Male", "Always lost", 200));
		return lsImplList;
	}

	private LivestockImpl lsImplSingleItem() {
		LivestockImpl lsImplItem = new LivestockImpl(1, "Peach", "Star Fish", "Female", "Cute", 200);
		return lsImplItem;
	}

	@AfterTest
	public void afterTest() {
	}

}
