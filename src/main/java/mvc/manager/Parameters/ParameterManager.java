package mvc.manager.Parameters;

import java.util.List;

import mvc.entity.parameters.ParametersView;

public interface ParameterManager {

List<ParametersView> getAll();
	
	List<ParametersView> getParamByAqFk(Integer aqFk);

	ParametersView getParameterById(Integer parameterId);

	ParametersView saveParameter(ParametersView parameter);

	Integer deleteParameterById(Integer parameterId);
	
}
