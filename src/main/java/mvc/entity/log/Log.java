package mvc.entity.log;

import java.util.Date;

public interface Log {

	Integer getLogId();

	void setLogId(Integer logId);

	String getTitle();

	void setTitle(String title);
	
	String getLog();

	void setLog(String log);

	Date getDate();

	void setDate(Date date);
	
	Integer getLogFk();

	void setLogFk(Integer logFk);
	
}
