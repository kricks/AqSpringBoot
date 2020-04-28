package mvc.entity.log;

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
@Table(name = "LOGS")
public class LogImpl implements Log {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer logId;
	
	@Column(name = "TITLE", nullable = true)
	private String title;
	
	@Column(name = "OBSERVATION", nullable = true)
	private String log;
	
	@Column(name = "DATE", nullable = true)
	private Date date;
	
	@Column(name = "LOG_FK")
	private Integer logFk;
	
	public LogImpl() {
		// default constructor
	}
	
	public LogImpl(Integer logId, String title, String log, Date date, Integer logFk) {
		this.logId = logId;
		this.title = title;
		this.log = log;
		this.date = date;
		this.logFk = logFk;
	}
	
	public LogImpl(LogView logView) {
		System.out.println("impl");
		BeanUtils.copyProperties(logView, this, Log.class);
	}

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getLogFk() {
		return logFk;
	}

	public void setLogFk(Integer obAqFK) {
		this.logFk = obAqFK;
	}

	@Override
	public String toString() {
		return "LogImpl [logId=" + logId + ", title=" + title + ", log=" + log
				+ ", date=" + date + ", logFk=" + logFk + "]";
	}
	
}
