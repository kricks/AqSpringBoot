package mvc.manager.livestock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mvc.entity.livestock.LivestockImpl;
import mvc.entity.livestock.LivestockView;
import mvc.service.livestock.LivestockService;

public class LivestockManagerImpl implements LivestockManager {

	@Autowired
	private LivestockService livestockService;

	@Override
	public List<LivestockView> findAllLivestock() {
		List<LivestockView> livestockView = new ArrayList<>();
		for (LivestockImpl lsImpl : livestockService.getAll()) {
			LivestockView lsView = new LivestockView(lsImpl);
			livestockView.add(lsView);
		}
		return livestockView;
	}

	@Override
	public LivestockView findById(Integer livestockId) {
		LivestockImpl lsImpl = livestockService.getLivestockById(livestockId);
		LivestockView lsView = new LivestockView(lsImpl);
		return lsView;
	}

	@Override
	public List<LivestockView> findLivestockByFkAquariumId(Integer fkAquariumId) {
		List<LivestockView> livestockView = new ArrayList<>();
		for (LivestockImpl lsImpl : livestockService.getLivestockByFkAquariumId(fkAquariumId)) {
			LivestockView lsView = new LivestockView(lsImpl);
			livestockView.add(lsView);
		}
		return livestockView;
	}

	@Override
	public LivestockView saveLivestock(LivestockImpl livestock) {
		LivestockImpl lsImpl = livestockService.saveLivestock(livestock);
		LivestockView lsView = new LivestockView(lsImpl);
		return lsView;
	}

	@Override
	public boolean deleteLivestockById(Integer livestockId) {
		return livestockService.deleteLivestockById(livestockId);
	}
}
