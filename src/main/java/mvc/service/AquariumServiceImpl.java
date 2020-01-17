package mvc.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.entity.AquariumImpl;
import mvc.repo.AquariumRepo;

@Service
public class AquariumServiceImpl implements AquariumService {

	final static Logger logger = Logger.getLogger(AquariumServiceImpl.class);

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
	public AquariumImpl deleteAquariumById(Integer aquariumId) {
		if (aquariumId == null) {
			logger.error("Delete aquarium failed");
		}
		aquariumRepo.deleteById(aquariumId);
		logger.info("Aquarium Successfully Deleted");
		return null;
	}
}
