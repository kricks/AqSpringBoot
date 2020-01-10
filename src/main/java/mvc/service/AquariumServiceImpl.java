package mvc.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Optional<Aquarium> getAquariumById(Integer aquariumId) {
		return aquariumRepo.findById(aquariumId);
	}

	@Override
	public Aquarium saveAquarium(Aquarium aquarium) {
		return aquariumRepo.save(aquarium);
	}

	@Override
	public Aquarium updateAquarium(Integer aquarium) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aquarium deleteAquariumById(Integer aquariumId) {
		// TODO Auto-generated method stub
		return null;
	}

}
