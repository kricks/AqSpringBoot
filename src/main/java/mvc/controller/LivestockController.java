package mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mvc.entity.livestock.LivestockView;
import mvc.manager.livestock.LivestockManager;

@RequestMapping(value = "/livestock")
@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = { "http://localhost:4200" })
public class LivestockController {

	@Autowired
	private LivestockManager livestockManager;

	@GetMapping(value = "/all")
	public ResponseEntity<List<LivestockView>> getAllAquariums() {
		List<LivestockView> livestock = livestockManager.findAllLivestock();
		if (livestock.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(livestock, HttpStatus.OK);
	}

	@GetMapping(value = "/{livestockId}")
	public ResponseEntity<LivestockView> getLivestockId(@PathVariable("livestockId") Integer livestockId) {
		LivestockView lsView = livestockManager.findById(livestockId);
		if (livestockId == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lsView, HttpStatus.OK);
	}

	@GetMapping(value = "/aqFk/{fkAquariumId}")
	public List<LivestockView> getLivestockByFkAquariumId(@PathVariable("fkAquariumId") Integer fkAquariumId) {
		System.out.println("controller " + fkAquariumId);
		return livestockManager.findLivestockByFkAquariumId(fkAquariumId);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<LivestockView> createLivestock(@RequestBody LivestockView livestock) {
		Integer livestockId = livestock.getLivestockId();
		if (livestockId != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		LivestockView lsView = livestockManager.saveLivestock(livestock);
		return new ResponseEntity<>(lsView, HttpStatus.CREATED);
	}

	@PutMapping(value = "/update/{livestockId}")
	public ResponseEntity<LivestockView> updateAquarium(@RequestBody LivestockView livestock) {
		if (livestock.getLivestockId() == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		LivestockView lsView = livestockManager.saveLivestock(livestock);
		return new ResponseEntity<>(lsView, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{livestockId}")
	public ResponseEntity<Integer> deleteLivestock(@PathVariable("livestockId") Integer livestockId) {
		if (livestockId == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		Integer delete = livestockManager.deleteLivestockById(livestockId);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}
}
