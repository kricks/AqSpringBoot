package mvc.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
		return new ResponseEntity<>(images, HttpStatus.OK);
	}

	@GetMapping(value = "/{imageName}")
	public ResponseEntity<ImageView> getImageByName(@PathVariable("imageName") String imageName) {
		ImageView aqView = imageManager.getByName(imageName);
		ImageView img = new ImageView(aqView.getName(), aqView.getType(), decompressBytes(aqView.getImage()));

		if (imageName == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		System.out.println("get from controller " + img);
		return new ResponseEntity<>(img, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ImageView> uplaodImage(@RequestParam("image") MultipartFile file) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		ImageView image = new ImageView(file.getOriginalFilename(), file.getContentType(),
				compressBytes(file.getBytes()));

//		ImageView id = imageManager.getImageById(imageId);
//		if (id != null) {
//			return new ResponseEntity<>(HttpStatus.CONFLICT);
//		}
		ImageView aqView = imageManager.saveImage(image);
		return new ResponseEntity<>(aqView, HttpStatus.CREATED);
	}

	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

//	@PutMapping(value = "/update/{aquariumId}")
//	public ResponseEntity<AquariumView> updateAquarium(@RequestBody AquariumView aquarium) {
//		if (aquarium.getAquariumId() == null) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		AquariumView aqView = aquariumManager.saveAquarium(aquarium);
//		return new ResponseEntity<>(aqView, HttpStatus.OK);
//	}
//
//	@DeleteMapping(value = "/delete/{aquariumId}")
//	public ResponseEntity<Integer> deleteAquarium(@PathVariable("aquariumId") Integer aquariumId) {
//		if (aquariumId == null) {
//			return new ResponseEntity<>(HttpStatus.CONFLICT);
//		}
//		Integer delete = aquariumManager.deleteAquariumById(aquariumId);
//		return new ResponseEntity<>(delete, HttpStatus.OK);
//	}
}
