package mvc.entity.aquarium;

import java.util.Date;

public interface Aquarium {

	Integer getAquariumId();

	void setAquariumId(Integer aquariumId);

	String getName();

	void setName(String name);

	String getType();

	void setType(String type);

	Integer getGallon();

	void setGallon(Integer gallon);

	String getNotes();

	void setNotes(String notes);

	Date getDate();

	void setDate(Date date);
}
