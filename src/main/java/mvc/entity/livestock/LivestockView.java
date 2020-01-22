package mvc.entity.livestock;

import org.springframework.beans.BeanUtils;

public class LivestockView implements Livestock {

	private Integer livestockId;
	private String name;
	private String species;
	private String gender;
	private String notes;
	private Integer fkAquariumId;

	public LivestockView() {
		// default constructor
	}

	public LivestockView(LivestockImpl livestockImpl) {
		BeanUtils.copyProperties(livestockImpl, this, Livestock.class);
	}

	public Integer getLivestockId() {
		return livestockId;
	}

	public void setLivestockId(Integer livestockId) {
		this.livestockId = livestockId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getFkAquariumId() {
		return fkAquariumId;
	}

	public void setFkAquariumId(Integer fkAquariumId) {
		this.fkAquariumId = fkAquariumId;
	}
}
