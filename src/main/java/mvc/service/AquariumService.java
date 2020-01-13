package mvc.service;

import java.util.List;

import mvc.entity.Aquarium;

public interface AquariumService {

	List<Aquarium> getAll();

	Aquarium getAquariumById(Integer aquariumId);

	Aquarium saveAquarium(Aquarium aquarium);

	boolean deleteAquariumById(Integer aquariumId);

}
