package mvc.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mvc.entity.image.ImageImpl;

@Repository
public interface ImageRepo extends JpaRepository<ImageImpl, Integer> {

	@Query(value = "SELECT * FROM images im WHERE im.category = :category", nativeQuery = true)
	List<ImageImpl> getByCategory(@Param("category") String imageCategory);

	@Modifying
	@Query(value = "DELETE FROM images im WHERE im.image_id = :imageId", nativeQuery = true)
	Integer deleteByImId(@Param("imageId") Integer imageId);

}
