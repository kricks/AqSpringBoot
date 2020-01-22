package mvc.manager.aquarium;

import java.util.List;

import mvc.entity.aquarium.AquariumView;

public interface AquariumManager {

	List<AquariumView> getAll();

	AquariumView getAquariumById(Integer aquariumId);

	AquariumView saveAquarium(AquariumView aquarium);

	Integer deleteAquariumById(Integer aquariumId);
}
