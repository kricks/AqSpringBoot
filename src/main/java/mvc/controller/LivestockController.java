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

import mvc.entity.livestock.LivestockImpl;
import mvc.service.livestock.LivestockService;

@RequestMapping(value = "/livestock")
@RestController
@EnableAutoConfiguration
public class LivestockController {

	@Autowired
	private LivestockService livestockService;

	@GetMapping(value = "/all")
	public List<LivestockImpl> getAllAquariums() {
		return livestockService.getAll();
	}

	@GetMapping(value = "/{livestockId}")
	public LivestockImpl getLivestockId(@PathVariable("livestockId") Integer livestockId) {
		return livestockService.getLivestockById(livestockId);
	}

	@GetMapping(value = "/aqFk/{fkAquariumId}")
	public List<LivestockImpl> getLivestockByFkAquariumId(@PathVariable("fkAquariumId") Integer fkAquariumId) {
		return livestockService.getLivestockByFkAquariumId(fkAquariumId);
	}

	@PostMapping(value = "/create")
	public LivestockImpl createLivestock(@RequestBody LivestockImpl livestock) {
		return livestockService.saveLivestock(livestock);
	}

	@PutMapping(value = "/update/{livestockId}")
	public LivestockImpl updateAquarium(@PathVariable("livestockId") Integer livestockId,
			@RequestBody LivestockImpl livestock) {
		LivestockImpl update = livestockService.getLivestockById(livestockId);
		update.setName(livestock.getName());
		update.setSpecies(livestock.getSpecies());
		update.setGender(livestock.getGender());
		update.setNotes(livestock.getNotes());
		return livestockService.saveLivestock(update);
	}

	@DeleteMapping(value = "/delete/{livestockId}")
	public boolean deleteLivestock(@PathVariable("livestockId") Integer aquariumId) {
		return livestockService.deleteLivestockById(aquariumId);
	}

}
