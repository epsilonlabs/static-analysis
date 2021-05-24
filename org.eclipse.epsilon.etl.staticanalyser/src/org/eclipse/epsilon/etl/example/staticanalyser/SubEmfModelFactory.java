package org.eclipse.epsilon.etl.example.staticanalyser;

import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.staticanalyser.IModelFactory;

public class SubEmfModelFactory implements IModelFactory {

	@Override
	public IModel createModel(String driver) {
		return new EmfModel();
	}

}
