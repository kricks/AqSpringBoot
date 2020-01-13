package mvc.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.entity.Aquarium;
import mvc.repo.AquariumRepo;

@Service
public class AquariumServiceImpl implements AquariumService {

	final static Logger logger = Logger.getLogger(AquariumServiceImpl.class);

	@Autowired
	private AquariumRepo aquariumRepo;

	@Override
	public List<Aquarium> getAll() {
		return (List<Aquarium>) aquariumRepo.findAll();
	}

	@Override
	public Aquarium getAquariumById(Integer aquariumId) {
		return aquariumRepo.findById(aquariumId).get();
	}

	@Override
	public Aquarium saveAquarium(Aquarium aquarium) {
		return aquariumRepo.save(aquarium);
	}

	@Override
	public Aquarium updateAquarium(Aquarium aquarium) {
		return aquariumRepo.save(aquarium);
	}

	@Override
	public boolean deleteAquariumById(Integer aquariumId) {
		if (aquariumId != null) {
			aquariumRepo.deleteById(aquariumId);
			logger.info("Aquarium Successfully Deleted");
			return true;
		} else {
			logger.error("Delete aquarium failed");
			return false;
		}
	}

}
