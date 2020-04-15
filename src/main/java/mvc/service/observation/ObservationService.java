package mvc.service.observation;

import java.util.List;

import mvc.entity.observation.ObservationImpl;

public interface ObservationService {

	List<ObservationImpl> getAll();
	
	List<ObservationImpl> getByObAqFk(Integer obAqFk);
	
	ObservationImpl getObservationById(Integer observationId);
	
	ObservationImpl saveObservation(ObservationImpl observation);
	
	Integer deleteObservationById(Integer observationId);
	
}
