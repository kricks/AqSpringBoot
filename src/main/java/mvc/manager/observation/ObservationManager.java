package mvc.manager.observation;

import java.util.List;

import mvc.entity.observation.ObservationView;

public interface ObservationManager {

	List<ObservationView> getAll();
	
	List<ObservationView> getByObAqFk(Integer obAqFk);
	
	ObservationView getObservationById(Integer observationId);
	
	ObservationView saveAquarium(ObservationView observation);
	
	Integer deleteObservationById(Integer observationId);
	
}
