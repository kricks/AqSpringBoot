package mvc.manager.Parameters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mvc.entity.parameters.ParametersImpl;
import mvc.entity.parameters.ParametersView;
import mvc.service.parameters.ParameterService;

@Service
public class ParameterManagerImpl implements ParameterManager {
	
	@Autowired ParameterService parameterService;

	@Override
	public List<ParametersView> getAll() {
		List<ParametersView> parametersView = new ArrayList<>();
		for (ParametersImpl lsImpl : parameterService.getAll()) {
			ParametersView lsView = new ParametersView(lsImpl);
			parametersView.add(lsView);
		}
		return parametersView;
	}

	@Override
	public List<ParametersView> getParamByAqFk(Integer aqFk) {
		List<ParametersView> parametersView = new ArrayList<>();
		for (ParametersImpl lsImpl : parameterService.getParamByAqFk(aqFk)) {
			ParametersView lsView = new ParametersView(lsImpl);
			parametersView.add(lsView);
		}
		return parametersView;
	}

	@Override
	public ParametersView getParameterById(Integer parameterId) {
		ParametersImpl pImpl = parameterService.getParameterById(parameterId);
		ParametersView pView = new ParametersView(pImpl);
		return pView;
	}

	@Override
	public ParametersView saveParameter(ParametersView parameter) {
		ParametersImpl pImpl = new ParametersImpl(parameter);
		System.out.println("param mamager + " + parameter );
		parameterService.saveParameter(pImpl);
		System.out.println("pImpl mamager + " + pImpl );
		ParametersView pView = new ParametersView(pImpl);
		System.out.println("view mamager + " + pView );
		return pView;
	}

	@Override
	public Integer deleteParameterById(Integer parameterId) {
		return parameterService.deleteParameterById(parameterId);
	}
	
	

}
