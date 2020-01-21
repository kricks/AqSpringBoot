package mvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mvc.entity.aquarium.AquariumImpl;

@Repository
public interface AquariumRepo extends JpaRepository<AquariumImpl, Integer> {

}
