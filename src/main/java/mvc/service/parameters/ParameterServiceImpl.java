package mvc.service.parameters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mvc.entity.parameters.ParametersImpl;
import mvc.entity.repo.ParametersRepo;

@Service
@Transactional
public class ParameterServiceImpl implements ParameterService {
	
	@Autowired ParametersRepo parametersRepo;

	@Override
	public List<ParametersImpl> getAll() {
		return parametersRepo.findAll();
	}

	@Override
	public List<ParametersImpl> getParamByAqFk(Integer aqFk) {
		return parametersRepo.findByAqFk(aqFk);
	}

	@Override
	public ParametersImpl getParameterById(Integer parameterId) {
		return parametersRepo.findById(parameterId).get();
	}

	@Override
	public ParametersImpl saveParameter(ParametersImpl parameter) {
		System.out.println("service param " + "parameter");
		return parametersRepo.save(parameter);
	}

	@Override
	public Integer deleteParameterById(Integer parameterId) {
		return parametersRepo.deleteParameterById(parameterId);
	}
	
	

}
