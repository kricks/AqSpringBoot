package mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mvc.entity.Aquarium;
import mvc.repo.AquariumRepo;

@Service
@Transactional
public class AquariumServiceImpl implements AquariumService {

	@Autowired
	private AquariumRepo aquariumRepo;

	@Override
	public List<Aquarium> findAll() {
		return (List<Aquarium>) aquariumRepo.findAll();
	}

}
