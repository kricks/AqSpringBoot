package mvc.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mvc.entity.Livestock;
import mvc.repo.LivestockRepo;

@Service
@Transactional
public class LivestockServiceImpl implements LivestockService {

	final static Logger logger = Logger.getLogger(AquariumServiceImpl.class);

	@Autowired
	private LivestockRepo livestockRepo;

	@Override
	public List<Livestock> getAll() {
		return (List<Livestock>) livestockRepo.findAll();
	}

	@Override
	public Livestock getLivestockById(Integer livestockId) {
		return livestockRepo.findById(livestockId).get();
	}

	@Override
	public List<Livestock> getLivestockByFkAquariumId(Integer fkAquariumId) {
		return livestockRepo.findFkAquariumId(fkAquariumId);
	}

	@Override
	public Livestock saveLivestock(Livestock livestock) {
		return livestockRepo.save(livestock);
	}

	@Override
	public boolean deleteLivestockById(Integer livestockId) {
		if (livestockId != null) {
			livestockRepo.deleteById(livestockId);
			logger.info("Livestock Delete successful");
			return true;
		} else {
			logger.error("Delete livestock failed");
			return false;
		}
	}
}
