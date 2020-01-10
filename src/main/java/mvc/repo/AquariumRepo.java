package mvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mvc.entity.Aquarium;

@Repository
public interface AquariumRepo extends JpaRepository<Aquarium, Integer> {

}
