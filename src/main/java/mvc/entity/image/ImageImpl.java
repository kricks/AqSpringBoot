package mvc.entity.image;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "Images")
public class ImageImpl implements Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer imageId;

	@Column(name = "NAME", nullable = true)
	private String name;

	@Column(name = "CATEGORY", nullable = true)
	private String category;

	@Column(name = "IMAGE_URL", nullable = true)
	private String ImageURL;

	public ImageImpl(ImageView imageView) {
		BeanUtils.copyProperties(imageView, this, Image.class);
	}

	public ImageImpl() {
		// default constructor
	}

	public ImageImpl(Integer imageId, String name, String category, String ImageURL) {
		super();
		this.imageId = imageId;
		this.name = name;
		this.category = category;
		this.ImageURL = ImageURL;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImageURL() {
		return ImageURL;
	}

	public void setImageURL(String ImageURL) {
		this.ImageURL = ImageURL;
	}

	public String toString() {
		return "ImageImpl [imageId=" + imageId + ", name=" + name + ", category=" + category + ", ImageURL=" + ImageURL + "]";
	}
	
}
