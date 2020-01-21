package mvc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mvc.entity.livestock.LivestockImpl;

public interface LivestockRepo extends JpaRepository<LivestockImpl, Integer> {

	@Query(value = "SELECT * FROM livestock ls WHERE ls.fk_aquarium_id = :fkAquariumId", nativeQuery = true)
	List<LivestockImpl> findFkAquariumId(@Param("fkAquariumId") Integer fkAquariumId);
}
