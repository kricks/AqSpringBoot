package mvc.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mvc.entity.aquarium.AquariumImpl;

@Repository
public interface AquariumRepo extends JpaRepository<AquariumImpl, Integer> {

	@Modifying
	@Query(value = "DELETE FROM aquarium aq WHERE aq.aquarium_id = :aquariumId", nativeQuery = true)
	Integer deleteAqById(@Param("aquariumId") Integer aquariumId);
}
