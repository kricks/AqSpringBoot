package mvc.service.log;

import java.util.List;

import mvc.entity.log.LogImpl;

public interface LogService {

	List<LogImpl> getAll();
	
	List<LogImpl> getByLogFk(Integer logFk);
	
	LogImpl getLogById(Integer logId);
	
	LogImpl saveLog(LogImpl log);
	
	Integer deleteLogById(Integer logId);
	
}
