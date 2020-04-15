package mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mvc.entity.observation.ObservationView;
import mvc.manager.observation.ObservationManager;

@RequestMapping(value = "/observation")
@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = { "http://localhost:4200" })
public class ObservationController {
	
	@Autowired
	private ObservationManager observationManager;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<ObservationView>> getAllObservation() {
	List<ObservationView> observation = observationManager.getAll();
	if (observation.isEmpty()) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<>(observation, HttpStatus.OK);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<ObservationView> createObservation(@RequestBody ObservationView observation) {
		ObservationView obView = observationManager.saveAquarium(observation);
		System.out.println("hello from controller");
		return new ResponseEntity<>(obView, HttpStatus.CREATED);
	}
}
