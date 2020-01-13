package mvc.service;

import java.util.List;

import mvc.entity.Livestock;

public interface LivestockService {

	List<Livestock> getAll();

	Livestock getLivestockById(Integer livestockId);

	List<Livestock> getLivestockByFkAquariumId(Integer fkAquariumId);

	Livestock saveLivestock(Livestock livestock);

	boolean deleteLivestockById(Integer livestockId);

}
