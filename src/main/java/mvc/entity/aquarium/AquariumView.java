package mvc.entity.aquarium;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AquariumView implements Aquarium {

	private Integer aquariumId;
	private String name;
	private String type;
	private Integer gallon;
	private String notes;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "CST")
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy", timezone
	// = "CST")
	private Date date;

	public AquariumView() {
		// default constructor
	}

	public AquariumView(Integer aquariumId, String name, String type, Integer gallon, String notes, Date date) {
		this.aquariumId = aquariumId;
		this.name = name;
		this.type = type;
		this.gallon = gallon;
		this.notes = notes;
		this.date = date;
	}

	public AquariumView(AquariumImpl aquariumImpl) {
		BeanUtils.copyProperties(aquariumImpl, this, Aquarium.class);
	}

	public Integer getAquariumId() {
		return aquariumId;
	}

	public void setAquariumId(Integer aquariumId) {
		this.aquariumId = aquariumId;
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

	public Integer getGallon() {
		return gallon;
	}

	public void setGallon(Integer gallon) {
		this.gallon = gallon;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "AquariumView [aquariumId=" + aquariumId + ", name=" + name + ", type=" + type + ", gallon=" + gallon
				+ ", notes=" + notes + ", date=" + date + "]";
	}
}
