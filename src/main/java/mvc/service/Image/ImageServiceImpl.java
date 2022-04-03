package mvc.service.Image;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.entity.image.ImageImpl;
import mvc.entity.repo.ImageRepo;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepo imageRepo;

	@Override
	public List<ImageImpl> getAll() {
		return imageRepo.findAll();
	}

	@Override
	public ImageImpl getImageById(Integer imageId) {
		return imageRepo.findById(imageId).get();
	}

	@Override
	public ImageImpl saveImage(ImageImpl image) {
		System.out.println("image in service " + image);
		return imageRepo.save(image);
	}

	@Override
	public Integer deleteImageById(Integer imageId) {
		System.out.println("service " + imageId);
		return imageRepo.deleteByImId(imageId);
	}

	@Override
	public List<ImageImpl> getByCategory(String imageCategory) {
		System.out.println("service " + imageCategory);
		return imageRepo.getByCategory(imageCategory);
	}

}
