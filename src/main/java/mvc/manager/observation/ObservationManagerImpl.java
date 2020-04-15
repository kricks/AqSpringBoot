package mvc.manager.observation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.entity.livestock.LivestockImpl;
import mvc.entity.livestock.LivestockView;
import mvc.entity.observation.ObservationImpl;
import mvc.entity.observation.ObservationView;
import mvc.service.observation.ObservationService;


@Service
public class ObservationManagerImpl implements ObservationManager{
	
	@Autowired
	private ObservationService observationService;

	@Override
	public List<ObservationView> getAll() {
		List<ObservationView> observationView = new ArrayList<>();
		for (ObservationImpl obImpl : observationService.getAll()) {
			ObservationView obView = new ObservationView(obImpl);
			observationView.add(obView);
		}
		return observationView;
	}
	
	@Override
	public List<ObservationView> getByObAqFk(Integer obAqFk) {
		List<ObservationView> observationView = new ArrayList<>();
		for (ObservationImpl obImpl : observationService.getByObAqFk(obAqFk)) {
			ObservationView obView = new ObservationView(obImpl);
			observationView.add(obView);
		}
		return observationView;
	}

	@Override
	public ObservationView getObservationById(Integer observationId) {
		ObservationImpl obImpl = observationService.getObservationById(observationId);
		ObservationView obView = new ObservationView(obImpl);
		return obView;
	}

	@Override
	public ObservationView saveAquarium(ObservationView observation) {
		ObservationImpl obImpl = new ObservationImpl(observation);
		observationService.saveObservation(obImpl);
		ObservationView obView = new ObservationView(obImpl);
		System.out.println("hello from mananger");
		return obView;
	}

	@Override
	public Integer deleteObservationById(Integer observationId) {
		return observationService.deleteObservationById(observationId);
	}
}
