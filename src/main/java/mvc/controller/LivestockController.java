package mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mvc.entity.Livestock;
import mvc.service.LivestockService;

@RequestMapping(value = "/livestock")
@RestController
@EnableAutoConfiguration
public class LivestockController {

	@Autowired
	private LivestockService livestockService;

	// get all livestock
	@GetMapping(value = "/all")
	public List<Livestock> getAllAquariums() {
		return livestockService.getAll();
	}

	// get livestockId
	@GetMapping(value = "/{livestockId}")
	public Livestock getLivestockId(@PathVariable("livestockId") Integer livestockId) {
		return livestockService.getLivestockById(livestockId);
	}

	// getAllLivestockByFkAquariumId
	@GetMapping(value = "/aqFk/{fkAquariumId}")
	public List<Livestock> getLivestockByFkAquariumId(@PathVariable("fkAquariumId") Integer fkAquariumId) {
		return livestockService.getLivestockByFkAquariumId(fkAquariumId);
	}

	// create livestock
	@PostMapping(value = "/create")
	public Livestock createLivestock(@RequestBody Livestock livestock) {
		return livestockService.saveLivestock(livestock);
	}

	// update
	@PutMapping(value = "/update/{livestockId}")
	public Livestock updateAquarium(@PathVariable("livestockId") Integer livestockId,
			@RequestBody Livestock livestock) {
		Livestock update = livestockService.getLivestockById(livestockId);
		update.setName(livestock.getName());
		update.setSpecies(livestock.getSpecies());
		update.setGender(livestock.getGender());
		update.setNotes(livestock.getNotes());
		return livestockService.saveLivestock(update);
	}

	// delete
	@DeleteMapping(value = "/delete/{livestockId}")
	public boolean deleteLivestock(@PathVariable("livestockId") Integer aquariumId) {
		return livestockService.deleteLivestockById(aquariumId);
	}

}
