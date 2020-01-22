package mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mvc.entity.aquarium.AquariumView;
import mvc.manager.aquarium.AquariumManager;

@RequestMapping(value = "/aquarium")
@RestController
@EnableAutoConfiguration
public class AquariumController {

	@Autowired
	private AquariumManager aquariumManager;

	@GetMapping(value = "/all")
	public ResponseEntity<List<AquariumView>> getAllAquariums() {
		List<AquariumView> aquariums = aquariumManager.getAll();

		if (aquariums.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(aquariums, HttpStatus.OK);
	}

	@GetMapping(value = "/{aquariumId}")
	public ResponseEntity<AquariumView> getAquariumById(@PathVariable("aquariumId") Integer aquariumId) {
		AquariumView aqView = aquariumManager.getAquariumById(aquariumId);
		if (aquariumId == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(aqView, HttpStatus.OK);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<AquariumView> createAquarium(@RequestBody AquariumView aquarium) {
		Integer aquariumId = aquarium.getAquariumId();
		if (aquariumId != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		AquariumView aqView = aquariumManager.saveAquarium(aquarium);
		return new ResponseEntity<>(aqView, HttpStatus.CREATED);
	}

	@PutMapping(value = "/update/{aquariumId}")
	public ResponseEntity<AquariumView> updateAquarium(@RequestBody AquariumView aquarium) {
		if (aquarium.getAquariumId() == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		AquariumView aqView = aquariumManager.saveAquarium(aquarium);
		return new ResponseEntity<>(aqView, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{aquariumId}")
	public ResponseEntity<Integer> deleteAquarium(@PathVariable("aquariumId") Integer aquariumId) {
		if (aquariumId == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		Integer delete = aquariumManager.deleteAquariumById(aquariumId);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}
}
