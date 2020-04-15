package mvc.manager.Image;

import java.util.List;

import mvc.entity.image.ImageView;

public interface ImageManager {
	List<ImageView> getAll();

	ImageView getImageById(Integer imageId);

	ImageView saveImage(ImageView image);

	Integer deleteImageById(Integer imageId);

	List<ImageView> getByCategory(String imageName);

}
