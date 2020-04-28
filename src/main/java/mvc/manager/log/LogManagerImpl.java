package mvc.manager.log;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mvc.entity.log.LogImpl;
import mvc.entity.log.LogView;
import mvc.service.log.LogService;


@Service
public class LogManagerImpl implements LogManager{
	
	@Autowired
	private LogService logService;

	@Override
	public List<LogView> getAll() {
		List<LogView> logView = new ArrayList<>();
		for (LogImpl logImpl : logService.getAll()) {
			LogView loView = new LogView(logImpl);
			logView.add(loView);
		}
		return logView;
	}
	
	@Override
	public List<LogView> getByLogFk(Integer logFk) {
		List<LogView> logView = new ArrayList<>();
		for (LogImpl logImpl : logService.getByLogFk(logFk)) {
			LogView loView = new LogView(logImpl);
			logView.add(loView);
		}
		return logView;
	}

	@Override
	public LogView getLogById(Integer logId) {
		LogImpl logImpl = logService.getLogById(logId);
		LogView logView = new LogView(logImpl);
		return logView;
	}

	@Override
	public LogView saveAquarium(LogView log) {
		LogImpl logImpl = new LogImpl(log);
		logService.saveLog(logImpl);
		LogView logView = new LogView(logImpl);
		return logView;
	}

	@Override
	public Integer deleteLogById(Integer logId) {
		return logService.deleteLogById(logId);
	}
}
