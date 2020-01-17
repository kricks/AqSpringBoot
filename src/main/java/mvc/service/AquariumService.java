package mvc.service;

import java.util.List;

import mvc.entity.AquariumImpl;

public interface AquariumService {

	List<AquariumImpl> getAll();

	AquariumImpl getAquariumById(Integer aquariumId);

	AquariumImpl saveAquarium(AquariumImpl aquarium);

	AquariumImpl deleteAquariumById(Integer aquariumId);

}
