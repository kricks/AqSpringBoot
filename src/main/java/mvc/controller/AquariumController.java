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

import mvc.entity.AquariumView;
import mvc.manager.AquariumManager;

@RequestMapping(value = "/aquarium")
@RestController
@EnableAutoConfiguration
public class AquariumController {

	@Autowired
	private AquariumManager aquariumManager;

	// get all
	@GetMapping(value = "/all")
	public ResponseEntity<List<AquariumView>> getAllAquariums() {
		List<AquariumView> aquariums = aquariumManager.getAll();
		if (aquariums.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(aquariums, HttpStatus.OK);
	}

	// get by id

	@GetMapping(value = "/{aquariumId}")
	public AquariumView getAquariumById(@PathVariable("aquariumId") Integer aquariumId) {
		return aquariumManager.getAquariumById(aquariumId);
	}

	// create
	@PostMapping(value = "/create")
	public AquariumView createAquarium(@RequestBody AquariumView aquarium) {
		return aquariumManager.saveAquarium(aquarium);
	}

	// TODO: figure out how to update better
	@PutMapping(value = "/update/{aquariumId}")
	public AquariumView updateAquarium(@PathVariable("aquariumId") Integer aquariumId,
			@RequestBody AquariumView aquarium) {

		AquariumView update = aquariumManager.getAquariumById(aquariumId);
		// if it finds the id it triggers the merge. merge then. jparepository doesnt
		// have merge hibernate does have merge
		update.setName(aquarium.getName());
		update.setType(aquarium.getType());
		update.setGallon(aquarium.getGallon());
		update.setNotes(aquarium.getNotes());
		update.setDate(aquarium.getDate());
		return aquariumManager.saveAquarium(update);
	}

	// delete
	@DeleteMapping(value = "/delete/{aquariumId}")
	public AquariumView deleteAquarium(@PathVariable("aquariumId") Integer aquariumId) {
		return aquariumManager.deleteAquariumById(aquariumId);
	}
}
