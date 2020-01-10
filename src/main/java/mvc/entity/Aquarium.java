package mvc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import mvc.entity.Aquarium;

@Entity
@Table(name = "AQUARIUM")
public class Aquarium {
	
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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy", timezone = "CST")
	private Date date;

}
