package mvc.manager;

import java.util.List;

import mvc.entity.AquariumImpl;

public interface AquariumManager {

	List<AquariumImpl> getAll();

	AquariumImpl getAquariumById(Integer aquariumId);

	AquariumImpl saveAquarium(AquariumImpl aquarium);

	boolean deleteAquariumById(Integer aquariumId);

}
