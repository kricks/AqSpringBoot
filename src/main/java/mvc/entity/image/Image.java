package mvc.entity.image;

public interface Image {

	Integer getImageId();

	void setImageId(Integer imageId);

	String getName();

	void setName(String name);

	String getType();

	void setType(String type);

	byte[] getImage();

	void setImage(byte[] image);

}
