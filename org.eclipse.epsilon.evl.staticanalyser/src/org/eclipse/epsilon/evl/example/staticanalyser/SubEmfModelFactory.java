package org.eclipse.epsilon.evl.example.staticanalyser;

import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.compile.context.IModelFactory;
import org.eclipse.epsilon.eol.models.IModel;

public class SubEmfModelFactory implements IModelFactory {

	@Override
	public IModel createModel(String driver) {
		// TODO Auto-generated method stub
		return new EmfModel();
	}

}
