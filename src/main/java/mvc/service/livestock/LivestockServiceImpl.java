package mvc.service.livestock;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mvc.entity.livestock.LivestockImpl;
import mvc.entity.repo.LivestockRepo;

@Service
@Transactional
public class LivestockServiceImpl implements LivestockService {

	static final Logger logger = Logger.getLogger(LivestockServiceImpl.class);

	@Autowired
	private LivestockRepo livestockRepo;

	@Override
	public List<LivestockImpl> getAll() {
		return livestockRepo.findAll();
	}

	@Override
	public LivestockImpl getLivestockById(Integer livestockId) {
		return livestockRepo.findById(livestockId).get();
	}

	@Override
	public List<LivestockImpl> getLivestockByFkAquariumId(Integer fkAquariumId) {
		return livestockRepo.findFkAquariumId(fkAquariumId);
	}

	@Override
	public LivestockImpl saveLivestock(LivestockImpl livestock) {
		return livestockRepo.save(livestock);
	}

	@Override
	public Integer deleteLivestockById(Integer livestockId) {
		return livestockRepo.deleteLsById(livestockId);
	}
}
