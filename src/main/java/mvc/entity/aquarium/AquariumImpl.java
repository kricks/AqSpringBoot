package mvc.entity.aquarium;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "AQUARIUM")
public class AquariumImpl implements Aquarium {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aquariumId;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "TYPE", nullable = true)
	private String type;

	@Column(name = "GALLON", nullable = true)
	private Integer gallon;

	@Column(name = "NOTES", nullable = true)
	private String notes;

	@Column(name = "DATE", nullable = false)
	private Date date;

	public AquariumImpl() {
		// default constructor
	}

	public AquariumImpl(Integer aquariumId, String name, String type, Integer gallon, String notes, Date date) {
		this.aquariumId = aquariumId;
		this.name = name;
		this.type = type;
		this.gallon = gallon;
		this.notes = notes;
		this.date = date;
	}

	public AquariumImpl(AquariumView aquariumView) {
		BeanUtils.copyProperties(aquariumView, this, Aquarium.class);
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
		return "AquariumImpl [aquariumId=" + aquariumId + ", name=" + name + ", type=" + type + ", gallon=" + gallon
				+ ", notes=" + notes + ", date=" + date + "]";
	}
}
