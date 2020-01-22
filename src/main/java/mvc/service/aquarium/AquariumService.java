package mvc.service.aquarium;

import java.util.List;

import mvc.entity.aquarium.AquariumImpl;

public interface AquariumService {

	List<AquariumImpl> getAll();

	AquariumImpl getAquariumById(Integer aquariumId);

	AquariumImpl saveAquarium(AquariumImpl aquarium);

	Integer deleteAquariumById(Integer aquariumId);
}
