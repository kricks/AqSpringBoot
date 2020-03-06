package mvc.entity.image;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "Image")
public class ImageImpl implements Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer imageId;

	@Column(name = "NAME", nullable = true)
	private String name;

	@Column(name = "TYPE", nullable = true)
	private String type;

	@Column(name = "IMAGE", nullable = true)
	private byte[] image;

	public ImageImpl(ImageView imageView) {
		BeanUtils.copyProperties(imageView, this, Image.class);
	}

	public ImageImpl() {
		// default contstructor
	}

	public ImageImpl(String name, String type, byte[] image) {
		this.name = name;
		this.type = type;
		this.image = image;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ImageImpl [name=" + name + ", type=" + type + ", image=" + Arrays.toString(image) + "]";
	}

}
