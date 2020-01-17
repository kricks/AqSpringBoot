package mvc.controller;

import java.awt.Image;
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

import mvc.entity.AquariumImpl;
import mvc.service.AquariumService;

/**
 * 
 *
 * @param url  an absolute URL giving the base location of the image
 * @param name the location of the image, relative to the url argument
 * @return the image at the specified URL
 * @see Image
 */
@RequestMapping(value = "/aquarium")
@RestController
@EnableAutoConfiguration
public class AquariumController {

	@Autowired
	private AquariumService aquariumService;

	// get all
	@GetMapping(value = "/all")
	public ResponseEntity<List<AquariumImpl>> getAllAquariums() {
		List<AquariumImpl> aquariums = aquariumService.getAll();
		if (aquariums.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(aquariums, HttpStatus.OK);
	}

//	public List<Aquarium> getAllAquariums() {
//		return aquariumService.getAll();
//	}

	// get by id

	@GetMapping(value = "/{aquariumId}")
	public AquariumImpl getAquariumById(@PathVariable("aquariumId") Integer aquariumId) {
		return aquariumService.getAquariumById(aquariumId);
	}

	// create
	@PostMapping(value = "/create")
	public AquariumImpl createAquarium(@RequestBody AquariumImpl aquarium) {
		return aquariumService.saveAquarium(aquarium);
	}

	// TODO: figure out how to update better
	@PutMapping(value = "/update/{aquariumId}")
	public AquariumImpl updateAquarium(@PathVariable("aquariumId") Integer aquariumId,
			@RequestBody AquariumImpl aquarium) {

		AquariumImpl update = aquariumService.getAquariumById(aquariumId);
		// if it finds the id it triggers the merge. merge then. jparepository doesnt
		// have merge hibernate does have merge
		update.setName(aquarium.getName());
		update.setType(aquarium.getType());
		update.setGallon(aquarium.getGallon());
		update.setNotes(aquarium.getNotes());
		update.setDate(aquarium.getDate());
		return aquariumService.saveAquarium(update);
	}

	// delete
	@DeleteMapping(value = "/delete/{aquariumId}")
	public boolean deleteAquarium(@PathVariable("aquariumId") Integer aquariumId) {
		return aquariumService.deleteAquariumById(aquariumId);
	}
}
