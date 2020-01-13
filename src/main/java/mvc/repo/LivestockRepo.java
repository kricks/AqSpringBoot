package mvc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mvc.entity.Livestock;

public interface LivestockRepo extends JpaRepository<Livestock, Integer> {

	@Query(value = "SELECT * FROM livestock ls WHERE ls.fk_aquarium_id = :fkAquariumId", nativeQuery = true)
	List<Livestock> findFkAquariumId(@Param("fkAquariumId") Integer fkAquariumId);
}
