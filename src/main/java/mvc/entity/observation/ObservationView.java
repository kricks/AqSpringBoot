package mvc.entity.observation;

import java.util.Date;

import org.springframework.beans.BeanUtils;

public class ObservationView implements Observation{
	
	private Integer observationId;
	private String title;
	private String observation;
	private Date date;
	private Integer obAqFk;
	
	public ObservationView() {
		// default constructor
	}

	public ObservationView(Integer observationId, String title, String observation, Date date, Integer obAqFk) {
		super();
		this.observationId = observationId;
		this.title = title;
		this.observation = observation;
		this.date = date;
		this.obAqFk = obAqFk;
	}
	
	public ObservationView(ObservationImpl observationImpl) {
		System.out.println("view");
		BeanUtils.copyProperties(observationImpl, this, Observation.class);
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

	public void setObAqFk(Integer obAqFk) {
		this.obAqFk = obAqFk;
	}

	@Override
	public String toString() {
		return "ObservationView [observationId=" + observationId + ", title=" + title + ", observation=" + observation
				+ ", date=" + date + ", obAqFk=" + obAqFk + "]";
	}
	
}
