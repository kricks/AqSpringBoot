package mvc.entity.parameters;

import java.util.Date;

public interface Parameters {

	Integer getParameterId();
	void setParameterId(Integer parameterId);
	
	Integer getParamFk();
	void setParamFk(Integer paramFk);
	
	Date getDate();
	void setDate(Date date);
	
	Double getPh();
	void setPh(Double ph);
	
	Double getNitrite();
	void setNitrite(Double nitrite);
	
	Double getNitrate();
	void setNitrate(Double nitrate);
	
	Double getAmmonia();
	void setAmmonia(Double ammonia);
	
	Double getPhosphate();
	void setPhosphate(Double phosphate);
	
	Double getMagnesium();
	void setMagnesium(Double magnesium);
	
	Double getCalcium();
	void setCalcium(Double calcium);
	
	Double getAlkalinity();
	void setAlkalinity(Double alkalinity);
	
	Double getPotasium();
	void setPotasium(Double potasium);
	
	Double getIodine();
	void setIodine(Double iodine);
	
}
