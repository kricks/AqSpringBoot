package mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mvc.entity.log.LogView;
import mvc.manager.log.LogManager;

@RequestMapping(value = "/log")
@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = { "http://localhost:4200" })
public class LogController {
	
	@Autowired
	private LogManager logManager;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<LogView>> getAllLog() {
	List<LogView> log = logManager.getAll();
	if (log.isEmpty()) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<>(log, HttpStatus.OK);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<LogView> createLog(@RequestBody LogView log) {
		LogView obView = logManager.saveAquarium(log);
		return new ResponseEntity<>(obView, HttpStatus.CREATED);
	}
}
