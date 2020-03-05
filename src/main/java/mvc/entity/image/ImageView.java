package mvc.entity.image;

import java.util.Arrays;

import org.springframework.beans.BeanUtils;

public class ImageView implements Image {
	private Integer imageId;
	private String name;
	private String type;
	private byte[] image;

	public ImageView(ImageImpl imageImpl) {
		BeanUtils.copyProperties(imageImpl, this, Image.class);
	}

	public ImageView() {
		// default contstructor
	}

	public ImageView(String name, String type, byte[] image) {
		this.name = name;
		this.type = type;
		this.image = image;
	}

//	public Integer getImageId() {
//		return imageId;
//	}
//
//	public void setImageId(Integer imageId) {
//		this.imageId = imageId;
//	}

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
