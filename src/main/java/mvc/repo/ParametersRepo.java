package mvc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mvc.entity.parameters.ParametersImpl;

public interface ParametersRepo extends JpaRepository<ParametersImpl, Integer> {

	@Query(value = "SELECT * FROM parameter par WHERE par.aqFk_id = :aqFk", nativeQuery = true)
	List<ParametersImpl> findByAqFk(@Param("aqFk") Integer aqFk);

	@Modifying
	@Query(value = "DELETE FROM parameter par WHERE par.parameter_id = :parameterId", nativeQuery = true)
	Integer deleteParameterById(@Param("parameterId") Integer parameterId);
	
}
