package mvc.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mvc.entity.AquariumImpl;
import mvc.service.AquariumService;

public class AquariumManagerImpl implements AquariumManager {

	@Autowired
	private AquariumService aquariumService;

	@Override
	public List<AquariumImpl> getAll() {
		return aquariumService.getAll();
	}

	@Override
	public AquariumImpl getAquariumById(Integer aquariumId) {
		return aquariumService.getAquariumById(aquariumId);
	}

	@Override
	public AquariumImpl saveAquarium(AquariumImpl aquarium) {
		return aquariumService.saveAquarium(aquarium);
	}

	@Override
	public boolean deleteAquariumById(Integer aquariumId) {
		return aquariumService.deleteAquariumById(aquariumId);
	}

}
