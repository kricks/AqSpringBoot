package mvc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mvc.entity.Aquarium;
import mvc.service.AquariumService;

@RestController
@EnableAutoConfiguration
public class AquariumController {

	@Autowired
	private AquariumService aquariumService;

	// get all
	@GetMapping(value = "/getAllAquariums")
	public List<Aquarium> getAllAquariums() {
		return aquariumService.getAll();
	}

	// get by id

	@GetMapping(value = "/getAquariumById/{aquariumId}")
	public Optional<Aquarium> getAquariumById(@PathVariable("aquariumId") Integer aquariumId) {
		return aquariumService.getAquariumById(aquariumId);
	}

	// create
	@PostMapping(value = "/create")
	public Aquarium createAquarium(@RequestBody Aquarium aquarium) {
		return aquariumService.saveAquarium(aquarium);
	}

	// update
	@PutMapping(value = "/update/{aquariumId}")
	public Aquarium updateAquarium(@PathVariable("aquariumId") Integer aquariumId) {
		return aquariumService.updateAquarium(aquariumId);
	}

	// delete
	@DeleteMapping(value = "/delete/{aquariumId}")
	public Aquarium deleteAquarium(@PathVariable("aquariumId") Integer aquariumId) {
		return aquariumService.deleteAquariumById(aquariumId);
	}
}
