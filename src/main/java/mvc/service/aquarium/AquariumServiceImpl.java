package mvc.service.aquarium;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mvc.entity.aquarium.AquariumImpl;
import mvc.repo.AquariumRepo;

@Service
@Transactional
public class AquariumServiceImpl implements AquariumService {

	static final Logger logger = Logger.getLogger(AquariumServiceImpl.class);

	@Autowired
	private AquariumRepo aquariumRepo;

	@Override
	public List<AquariumImpl> getAll() {
		return aquariumRepo.findAll();
	}

	@Override
	public AquariumImpl getAquariumById(Integer aquariumId) {
		return aquariumRepo.findById(aquariumId).get();
	}

	@Override
	public AquariumImpl saveAquarium(AquariumImpl aquarium) {
		return aquariumRepo.save(aquarium);
	}

	@Override
	public Integer deleteAquariumById(Integer aquariumId) {
		return aquariumRepo.deleteAqById(aquariumId);
	}
}
