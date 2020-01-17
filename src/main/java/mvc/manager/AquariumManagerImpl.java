package mvc.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.entity.AquariumImpl;
import mvc.entity.AquariumView;
import mvc.service.AquariumService;

@Service
public class AquariumManagerImpl implements AquariumManager {

	@Autowired
	private AquariumService aquariumService;

	@Override
	public List<AquariumView> getAll() {
		List<AquariumView> aqView = new ArrayList<>();
		for (AquariumImpl aqImpl : aquariumService.getAll()) {
			AquariumView v = new AquariumView(aqImpl);
			aqView.add(v);
		}
		return aqView;
	}

	@Override
	public AquariumView getAquariumById(Integer aquariumId) {
		AquariumImpl aqI = aquariumService.getAquariumById(aquariumId);
		AquariumView aq = new AquariumView(aqI);
		return aq;
	}

	@Override
	public AquariumView saveAquarium(AquariumView aquarium) {
		AquariumImpl aqI = new AquariumImpl(aquarium);
		aquariumService.saveAquarium(aqI);
		AquariumView aq = new AquariumView(aqI);
		return aq;
	}

	@Override
	public AquariumView deleteAquariumById(Integer aquariumId) {
		AquariumImpl aqI = aquariumService.deleteAquariumById(aquariumId);
		AquariumView aqV = new AquariumView(aqI);
		return aqV;
	}

}
