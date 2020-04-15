package mvc.service.observation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.entity.observation.ObservationImpl;
import mvc.repo.ObservationRepo;

@Service
@Transactional
public class ObservationServiceImpl implements ObservationService {
	
	@Autowired
	private ObservationRepo observationRepo;

	@Override
	public List<ObservationImpl> getAll() {
		return observationRepo.findAll();
	}

	@Override
	public List<ObservationImpl> getByObAqFk(Integer obAqFk) {
		return observationRepo.findObAqFkId(obAqFk);
	}

	@Override
	public ObservationImpl getObservationById(Integer observationId) {
		return observationRepo.findById(observationId).get();
	}

	@Override
	public ObservationImpl saveObservation(ObservationImpl observation) {
		System.out.println("hello from service");
		return observationRepo.save(observation);
	}

	@Override
	public Integer deleteObservationById(Integer observationId) {
		return observationRepo.deleteObById(observationId);
	}	
	
}
