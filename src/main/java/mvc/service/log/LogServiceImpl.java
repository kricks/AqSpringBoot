package mvc.service.log;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.entity.log.LogImpl;
import mvc.entity.repo.LogRepo;

@Service
@Transactional
public class LogServiceImpl implements LogService {
	
	@Autowired
	private LogRepo logRepo;

	@Override
	public List<LogImpl> getAll() {
		return logRepo.findAll();
	}

	@Override
	public List<LogImpl> getByLogFk(Integer logFk) {
		return logRepo.findByLogFk(logFk);
	}

	@Override
	public LogImpl getLogById(Integer logId) {
		return logRepo.findById(logId).get();
	}

	@Override
	public LogImpl saveLog(LogImpl log) {
		return logRepo.save(log);
	}

	@Override
	public Integer deleteLogById(Integer logId) {
		return logRepo.deleteLogById(logId);
	}	
	
}
