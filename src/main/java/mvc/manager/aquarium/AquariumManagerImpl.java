package mvc.manager.aquarium;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.entity.aquarium.AquariumImpl;
import mvc.entity.aquarium.AquariumView;
import mvc.service.aquarium.AquariumService;

@Service
public class AquariumManagerImpl implements AquariumManager {

	@Autowired
	private AquariumService aquariumService;

	@Override
	public List<AquariumView> getAll() {
		List<AquariumView> aquariumView = new ArrayList<>();
		for (AquariumImpl aqImpl : aquariumService.getAll()) {
			AquariumView aqView = new AquariumView(aqImpl);
			aquariumView.add(aqView);
		}
		return aquariumView;
	}

	@Override
	public AquariumView getAquariumById(Integer aquariumId) {
		AquariumImpl aqImpl = aquariumService.getAquariumById(aquariumId);
		AquariumView aqView = new AquariumView(aqImpl);
		return aqView;
	}

	@Override
	public AquariumView saveAquarium(AquariumView aquarium) {
		AquariumImpl aqImpl = new AquariumImpl(aquarium);
		aquariumService.saveAquarium(aqImpl);
		AquariumView aqView = new AquariumView(aqImpl);
		return aqView;
	}

	@Override
	public Integer deleteAquariumById(Integer aquariumId) {
		return aquariumService.deleteAquariumById(aquariumId);
	}
}
