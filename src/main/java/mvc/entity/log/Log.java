package mvc.entity.log;

import java.util.Date;

public interface Log {

	public Integer getLogId();

	public void setLogId(Integer logId);

	public String getTitle();

	public void setTitle(String title);
	public String getLog();

	public void setLog(String log);

	public Date getDate();

	public void setDate(Date date);
	
	public Integer getLogFk();

	public void setLogFk(Integer logFk);
	
}
