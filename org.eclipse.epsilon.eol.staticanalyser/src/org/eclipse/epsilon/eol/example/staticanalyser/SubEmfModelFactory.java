package org.eclipse.epsilon.eol.example.staticanalyser;

import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.staticanalyser.IModelFactory;

public class SubEmfModelFactory implements IModelFactory {

	@Override
	public IModel createModel(String driver) {
		// TODO Auto-generated method stub
		return new EmfModel();
	}

}
