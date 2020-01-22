package mvc.manager.livestock;

import java.util.List;

import mvc.entity.livestock.LivestockView;

public interface LivestockManager {

	List<LivestockView> findAllLivestock();

	LivestockView findById(Integer livestockId);

	List<LivestockView> findLivestockByFkAquariumId(Integer fkAquariumId);

	LivestockView saveLivestock(LivestockView livestock);

	Integer deleteLivestockById(Integer livestockId);
}
