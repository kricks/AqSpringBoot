package mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mvc.entity.Aquarium;
import mvc.repo.AquariumRepo;

@RestController
@EnableAutoConfiguration
public class AquariumController {

	@Autowired
	private AquariumRepo aquariumRepo;

	@GetMapping(value = "/getAll")
	public List<Aquarium> getAll() {
		return aquariumRepo.findAll();
	}

}
