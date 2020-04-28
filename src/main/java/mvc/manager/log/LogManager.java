package mvc.manager.log;

import java.util.List;

import mvc.entity.log.LogView;

public interface LogManager {

	List<LogView> getAll();
	
	List<LogView> getByLogFk(Integer logFk);
	
	LogView getLogById(Integer logId);
	
	LogView saveAquarium(LogView log);
	
	Integer deleteLogById(Integer logId);
	
}
