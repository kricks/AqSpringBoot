package mvc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mvc.entity.log.LogImpl;

public interface LogRepo extends JpaRepository<LogImpl, Integer> {

	@Query(value = "SELECT * FROM logs lo WHERE lo.log_fk = :logFk", nativeQuery = true)
	List<LogImpl> findByLogFk(@Param("logFk") Integer logFk);

	@Modifying
	@Query(value = "DELETE FROM logs lo WHERE lo.log_id = :logId", nativeQuery = true)
	Integer deleteLogById(@Param("logId") Integer logId);
	
}
