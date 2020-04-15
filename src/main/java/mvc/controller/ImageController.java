package mvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mvc.entity.image.ImageView;
import mvc.manager.Image.ImageManager;

@RequestMapping(value = "/image")
@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@EnableAutoConfiguration
public class ImageController {

	@Autowired
	private ImageManager imageManager;

	@GetMapping(value = "/all")
	public ResponseEntity<List<ImageView>> getAllImages() {
		List<ImageView> images = imageManager.getAll();

		if (images.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		System.out.println("hit controller get all");
		return new ResponseEntity<>(images, HttpStatus.OK);
	}

	@GetMapping(value = "/category/{category}")
	public ResponseEntity<List<ImageView>> getAllByCategory(@PathVariable("category") String category) {
		List<ImageView> images = imageManager.getByCategory(category);

		if (images.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		System.out.println("hit controller get all");
		return new ResponseEntity<>(images, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{imageId}")
	public ResponseEntity<ImageView> getImageById(@PathVariable("imageId") Integer imageId) {
		ImageView imageView = imageManager.getImageById(imageId);
		if (imageId == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(imageView, HttpStatus.OK);

	} 
	
	@PostMapping(value = "/create")
	public ResponseEntity<ImageView> createImage(@RequestBody ImageView image) {
		Integer imageId = image.getImageId();
//		if (imageId != null) {
//			return new ResponseEntity<>(HttpStatus.CONFLICT);
//		}
		ImageView imView = imageManager.saveImage(image);
		System.out.println("controller " + image);
		return new ResponseEntity<>(imView, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/delete/{imageId}")
	public ResponseEntity<Integer> deleteImage(@PathVariable("imageId") Integer imageId) {
//		if (imageId == null) {
//			return new ResponseEntity<>(HttpStatus.CONFLICT);
//		}
		System.out.println("controller " + imageId);
		Integer delete = imageManager.deleteImageById(imageId);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}
	
}
