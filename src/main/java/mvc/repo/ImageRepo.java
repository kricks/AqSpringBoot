package mvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mvc.entity.image.ImageImpl;

@Repository
public interface ImageRepo extends JpaRepository<ImageImpl, Integer> {

	@Query(value = "SELECT * FROM image im WHERE im.name = :name", nativeQuery = true)
	ImageImpl getByName(@Param("name") String imageName);

//	@Modifying
//	@Query(value = "DELETE FROM livestock ls WHERE ls.livestock_id = :livestockId", nativeQuery = true)
//	Integer deleteLsById(@Param("livestockId") Integer livestockId);

}
