package mvc.service;

import java.util.List;
import java.util.Optional;

import mvc.entity.Aquarium;

public interface AquariumService {

	List<Aquarium> getAll();

	Optional<Aquarium> getAquariumById(Integer aquariumId);

	Aquarium saveAquarium(Aquarium aquarium);

	Aquarium updateAquarium(Integer aquarium);

	Aquarium deleteAquariumById(Integer aquariumId);

}
