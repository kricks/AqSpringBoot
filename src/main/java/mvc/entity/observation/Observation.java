package mvc.entity.observation;

import java.util.Date;

public interface Observation {

	public Integer getObservationId();

	public void setObservationId(Integer observationId);

	public String getTitle();

	public void setTitle(String title);
	public String getObservation();

	public void setObservation(String observation);

	public Date getDate();

	public void setDate(Date date);
	
	public Integer getObAqFk();

	public void setObAqFk(Integer obAqFk);
	
}
