package mvc.entity.log;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LogView implements Log{
	
	private Integer logId;
	private String title;
	private String log;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "CST")
	private Date date;
	private Integer logFk;
	
	public LogView() {
		// default constructor
	}

	public LogView(Integer logId, String title, String log, Date date, Integer logFk) {
		super();
		this.logId = logId;
		this.title = title;
		this.log = log;
		this.date = date;
		this.logFk = logFk;
	}
	
	public LogView(LogImpl logImpl) {
		BeanUtils.copyProperties(logImpl, this, Log.class);
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

	public void setLogFk(Integer logFk) {
		this.logFk = logFk;
	}

	@Override
	public String toString() {
		return "LogView [logId=" + logId + ", title=" + title + ", log=" + log
				+ ", date=" + date + ", logFk=" + logFk + "]";
	}
	
}
