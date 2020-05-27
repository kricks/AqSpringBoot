package mvc.entity.parameters;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ParametersView implements Parameters{

	private Integer parameterId;
	private Integer paramFk;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "CST")
	private Date date;
	private Double ph;
	private Double nitrate;
	private Double nitrite;
	private Double ammonia;
	private Double phosphate;
	private Double magnesium;
	private Double calcium;
	private Double potasium;
	private Double iodine;
	private Double alkalinity;
	
	public ParametersView() {
		//default constructor
	}

	public ParametersView(Integer parameterId, Integer paramFk, Date date, Double ph, Double nitrate, Double nitrite,
			Double ammonia, Double phosphate, Double magnesium, Double calcium, Double potasium, Double iodine,
			Double alkalinity) {
		super();
		this.parameterId = parameterId;
		this.paramFk = paramFk;
		this.date = date;
		this.ph = ph;
		this.nitrate = nitrate;
		this.nitrite = nitrite;
		this.ammonia = ammonia;
		this.phosphate = phosphate;
		this.magnesium = magnesium;
		this.calcium = calcium;
		this.potasium = potasium;
		this.iodine = iodine;
		this.alkalinity = alkalinity;
	}
	
	public ParametersView(ParametersImpl parametersImpl) {
		BeanUtils.copyProperties(parametersImpl, this, Parameters.class);
	}


	public Integer getParameterId() {
		return parameterId;
	}

	public void setParameterId(Integer parameterId) {
		this.parameterId = parameterId;
	}

	public Integer getParamFk() {
		return paramFk;
	}

	public void setParamFk(Integer paramFk) {
		this.paramFk = paramFk;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPh() {
		return ph;
	}

	public void setPh(Double ph) {
		this.ph = ph;
	}

	public Double getNitrate() {
		return nitrate;
	}

	public void setNitrate(Double nitrate) {
		this.nitrate = nitrate;
	}

	public Double getNitrite() {
		return nitrite;
	}

	public void setNitrite(Double nitrite) {
		this.nitrite = nitrite;
	}

	public Double getAmmonia() {
		return ammonia;
	}

	public void setAmmonia(Double ammonia) {
		this.ammonia = ammonia;
	}

	public Double getPhosphate() {
		return phosphate;
	}

	public void setPhosphate(Double phosphate) {
		this.phosphate = phosphate;
	}

	public Double getMagnesium() {
		return magnesium;
	}

	public void setMagnesium(Double magnesium) {
		this.magnesium = magnesium;
	}

	public Double getCalcium() {
		return calcium;
	}

	public void setCalcium(Double calcium) {
		this.calcium = calcium;
	}

	public Double getPotasium() {
		return potasium;
	}

	public void setPotasium(Double potasium) {
		this.potasium = potasium;
	}

	public Double getIodine() {
		return iodine;
	}

	public void setIodine(Double iodine) {
		this.iodine = iodine;
	}

	public Double getAlkalinity() {
		return alkalinity;
	}

	public void setAlkalinity(Double alkalinity) {
		this.alkalinity = alkalinity;
	}

	@Override
	public String toString() {
		return "ParametersView [parameterId=" + parameterId + ", paramFk=" + paramFk + ", date=" + date + ", ph=" + ph
				+ ", nitrate=" + nitrate + ", nitrite=" + nitrite + ", ammonia=" + ammonia + ", phosphate=" + phosphate
				+ ", magnesium=" + magnesium + ", calcium=" + calcium + ", potasium=" + potasium + ", iodine=" + iodine
				+ ", alkalinity=" + alkalinity + "]";
	}

}
