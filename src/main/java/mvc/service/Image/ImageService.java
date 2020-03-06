package mvc.service.Image;

import java.util.List;

import mvc.entity.image.ImageImpl;

public interface ImageService {

	List<ImageImpl> getAll();

	ImageImpl getImageById(Integer imageId);

	ImageImpl saveImage(ImageImpl image);

	Integer deleteImageById(Integer imageId);

	ImageImpl getByName(String imageName);
}
