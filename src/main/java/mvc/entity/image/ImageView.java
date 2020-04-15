package mvc.entity.image;

import org.springframework.beans.BeanUtils;

public class ImageView implements Image {
	private Integer imageId;
	private String name;
	private String category;
	private String ImageURL;

	public ImageView(ImageImpl imageImpl) {
		BeanUtils.copyProperties(imageImpl, this, Image.class);
	}

	public ImageView() {
		// default contstructor
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

	@Override
	public String toString() {
		return "ImageView [imageId=" + imageId + ", name=" + name + ", category=" + category + ", ImageURL=" + ImageURL
				+ "]";
	}

}
