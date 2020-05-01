package mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mvc.entity.livestock.LivestockView;
import mvc.entity.parameters.ParametersView;
import mvc.manager.Parameters.ParameterManager;

@RequestMapping(value = "/parameter")
@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = { "http://localhost:4200" })
public class ParameterController {
	
	@Autowired
	private ParameterManager parameterManager;

	@GetMapping(value = "/all")
	public ResponseEntity<List<ParametersView>> getAllLog() {
	List<ParametersView> parameter = parameterManager.getAll();
	System.out.println("hello aall");
	if (parameter.isEmpty()) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<>(parameter, HttpStatus.OK);
	}
	
	@GetMapping(value = "/aqFk/{aqFk}")
	public List<ParametersView> getParamByAqFk(@PathVariable("aqFk") Integer aqFk) {
		return parameterManager.getParamByAqFk(aqFk);
	}
	
	@GetMapping(value = "/{parameterId}")
	public ParametersView getParamById(@PathVariable("parameterId") Integer parameterId) {
		return parameterManager.getParameterById(parameterId);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<ParametersView> createLog(@RequestBody ParametersView parameter) {
		System.out.println("create param " + parameter);
		System.out.println("hello create");
		ParametersView pView = parameterManager.saveParameter(parameter);
		return new ResponseEntity<>(pView, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/update/{parameterId}")
	public ResponseEntity<ParametersView> updateAquarium(@RequestBody ParametersView parameter) {
		if (parameter.getParameterId() == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		ParametersView pView = parameterManager.saveParameter(parameter);
		return new ResponseEntity<>(pView, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{parameterId}")
	public ResponseEntity<Integer> deleteLog(@PathVariable("parameterId") Integer parameterId) {
		if (parameterId == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		Integer delete = parameterManager.deleteParameterById(parameterId);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}
	
}
