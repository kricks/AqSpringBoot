package mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.entity.Aquarium;
import mvc.repo.AquariumRepo;

@Service
public class AquariumServiceImpl implements AquariumService {

	@Autowired
	private AquariumRepo aquariumRepo;

	@Override
	public List<Aquarium> getAll() {
		return (List<Aquarium>) aquariumRepo.findAll();
	}

}
