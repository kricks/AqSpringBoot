package mvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mvc.entity.image.ImageImpl;

@Repository
public interface ImageRepo extends JpaRepository<ImageImpl, Integer> {

}
