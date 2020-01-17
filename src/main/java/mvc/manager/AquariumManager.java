package mvc.manager;

import java.util.List;

import mvc.entity.AquariumView;

public interface AquariumManager {

	List<AquariumView> getAll();

	AquariumView getAquariumById(Integer aquariumId);

	AquariumView saveAquarium(AquariumView aquarium);

	AquariumView deleteAquariumById(Integer aquariumId);

}
