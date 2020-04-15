package mvc.manager.Image;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.entity.image.ImageImpl;
import mvc.entity.image.ImageView;
import mvc.service.Image.ImageService;

@Service
public class ImageManagerImpl implements ImageManager {

	@Autowired
	private ImageService imageService;

	@Override
	public List<ImageView> getAll() {
		List<ImageView> imageView = new ArrayList<>();
		for (ImageImpl imageImpl : imageService.getAll()) {
			ImageView imView = new ImageView(imageImpl);
			imageView.add(imView);
		}
		return imageView;
	}
	
	@Override
	public List<ImageView> getByCategory(String imageCategory) {
		List<ImageView> imageView = new ArrayList<>();
		for (ImageImpl imageImpl : imageService.getByCategory(imageCategory)) {
			ImageView imView = new ImageView(imageImpl);
			imageView.add(imView);
		}
		return imageView;
	}

	@Override
	public ImageView getImageById(Integer imageId) {
		ImageImpl imageImpl = imageService.getImageById(imageId);
		ImageView imageView = new ImageView(imageImpl);
		return imageView;
	}

	@Override
	public ImageView saveImage(ImageView image) {
		ImageImpl imageImpl = new ImageImpl(image);
		System.out.println("ImageImpl in manager " + imageImpl);
		imageService.saveImage(imageImpl);
		ImageView imageView = new ImageView(imageImpl);
		System.out.println("ImageView in manager " + imageView);
		return imageView;
	}

	@Override
	public Integer deleteImageById(Integer imageId) {
		System.out.println("manager " + imageId);
		return imageService.deleteImageById(imageId);
	}

}
