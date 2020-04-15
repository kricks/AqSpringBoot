package mvc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mvc.entity.observation.ObservationImpl;

public interface ObservationRepo extends JpaRepository<ObservationImpl, Integer> {

	@Query(value = "SELECT * FROM obaservation ob WHERE ob.ob_aqFK = :obAqFk", nativeQuery = true)
	List<ObservationImpl> findObAqFkId(@Param("obAqFk") Integer obAqFk);

	@Modifying
	@Query(value = "DELETE FROM observation ob WHERE ob.observation_id = :observationId", nativeQuery = true)
	Integer deleteObById(@Param("observationId") Integer observationId);
	
}
