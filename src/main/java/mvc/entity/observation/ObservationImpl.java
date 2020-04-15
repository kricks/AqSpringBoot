package mvc.entity.observation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import mvc.entity.aquarium.Aquarium;

@Entity
@Table(name = "OBSERVATION")
public class ObservationImpl implements Observation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer observationId;
	
	@Column(name = "TITLE", nullable = true)
	private String title;
	
	@Column(name = "OBSERVATION", nullable = true)
	private String observation;
	
	@Column(name = "DATE", nullable = true)
	private Date date;
	
	@Column(name = "OB_AQFK")
	private Integer obAqFk;
	
	public ObservationImpl() {
		// default constructor
	}
	
	public ObservationImpl(Integer observationId, String title, String observation, Date date, Integer obAqFk) {
		this.observationId = observationId;
		this.title = title;
		this.observation = observation;
		this.date = date;
		this.obAqFk = obAqFk;
	}
	
	public ObservationImpl(ObservationView observationView) {
		System.out.println("impl");
		BeanUtils.copyProperties(observationView, this, Observation.class);
	}

	public Integer getObservationId() {
		return observationId;
	}

	public void setObservationId(Integer observationId) {
		this.observationId = observationId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getObAqFk() {
		return obAqFk;
	}

	public void setObAqFk(Integer obAqFK) {
		this.obAqFk = obAqFK;
	}

	@Override
	public String toString() {
		return "ObservationImpl [observationId=" + observationId + ", title=" + title + ", observation=" + observation
				+ ", date=" + date + ", obAqFk=" + obAqFk + "]";
	}
	
}
