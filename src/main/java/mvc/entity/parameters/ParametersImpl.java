package mvc.entity.parameters;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;
@Entity
@Table(name = "PARAMETER")
public class ParametersImpl implements Parameters {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer parameterId;
	
	@Column(name = "AQFK_ID", nullable = true)
	private Integer aqFk;
	
	@Column(name = "DATE", nullable = true)
	private Date date;
	
	@Column(name = "PH", nullable = true)
	private Double ph;
	
	@Column(name = "NIRATE", nullable = true)
	private Double nitrate;
	
	@Column(name = "NITRITE", nullable = true)
	private Double nitrite;
	
	@Column(name = "AMMONIA", nullable = true)
	private Double ammonia;
	
	@Column(name = "PHOSPHATE", nullable = true)
	private Double phosphate;
	
	@Column(name = "MAGNESIUM", nullable = true)
	private Double magnesium;
	
	@Column(name = "CALCIUM", nullable = true)
	private Double calcium;
	
	@Column(name = "POTASIUM", nullable = true)
	private Double potasium;
	
	@Column(name = "IODINE", nullable = true)
	private Double iodine;
	
	@Column(name = "ALKALINITY", nullable = true)
	private Double alkalinity;
	
	public ParametersImpl() {
		// default constructor
	}
	
	public ParametersImpl(Integer parameterId, Integer aqFk, Date date, Double ph, Double nitrate, Double nitrite,
			Double ammonia, Double phosphate, Double magnesium, Double calcium, Double potasium, Double iodine,
			Double alkalinity) {
		this.parameterId = parameterId;
		this.aqFk = aqFk;
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

	public ParametersImpl(ParametersView parametersView) {
		BeanUtils.copyProperties(parametersView, this, Parameters.class);
	}

	
	public Integer getParameterId() {
		return parameterId;
	}
	public void setParameterId(Integer parameterId) {
		this.parameterId = parameterId;
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

	public Integer getAqFk() {
		return aqFk;
	}

	public void setAqFk(Integer aqFk) {
		this.aqFk = aqFk;
	}

	@Override
	public String toString() {
		return "ParametersImpl [parameterId=" + parameterId + ", aqFk=" + aqFk + ", date=" + date + ", ph=" + ph
				+ ", nitrate=" + nitrate + ", nitrite=" + nitrite + ", ammonia=" + ammonia + ", phosphate=" + phosphate
				+ ", magnesium=" + magnesium + ", calcium=" + calcium + ", potasium=" + potasium + ", iodine=" + iodine
				+ ", alkalinity=" + alkalinity + "]";
	}
	
}
