package mvc.service.parameters;

import java.util.List;

import mvc.entity.parameters.ParametersImpl;

public interface ParameterService {

	List<ParametersImpl> getAll();
	
	List<ParametersImpl> getParamByAqFk(Integer aqFk);

	ParametersImpl getParameterById(Integer parameterId);

	ParametersImpl saveParameter(ParametersImpl parameter);

	Integer deleteParameterById(Integer parameterId);

}
