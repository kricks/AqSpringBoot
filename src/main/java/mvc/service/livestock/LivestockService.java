package mvc.service.livestock;

import java.util.List;

import mvc.entity.livestock.LivestockImpl;

public interface LivestockService {

	List<LivestockImpl> getAll();

	LivestockImpl getLivestockById(Integer livestockId);

	List<LivestockImpl> getLivestockByFkAquariumId(Integer fkAquariumId);

	LivestockImpl saveLivestock(LivestockImpl livestock);

	boolean deleteLivestockById(Integer livestockId);

}
