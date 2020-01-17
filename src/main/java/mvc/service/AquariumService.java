package mvc.service;

import java.util.List;

import mvc.entity.AquariumImpl;

public interface AquariumService {

	List<AquariumImpl> getAll();

//	List<AquariumView> convertViewToImpl();

	AquariumImpl getAquariumById(Integer aquariumId);

	AquariumImpl saveAquarium(AquariumImpl aquarium);

	boolean deleteAquariumById(Integer aquariumId);

}
