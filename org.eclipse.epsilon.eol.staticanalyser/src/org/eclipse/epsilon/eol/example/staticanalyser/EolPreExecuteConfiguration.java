package org.eclipse.epsilon.eol.example.staticanalyser;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.dom.ModelDeclaration;
import org.eclipse.epsilon.eol.launch.EolRunConfiguration;
import org.eclipse.epsilon.eol.staticanalyser.EolStaticAnalyser;

public class EolPreExecuteConfiguration extends EolRunConfiguration {
	IEolModule module;

	public EolPreExecuteConfiguration(EolRunConfiguration other) {
		super(other);
		module = super.getModule();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void preExecute() throws Exception {
		super.preExecute();
		for (ModelDeclaration modelDeclaration : module.getDeclaredModelDeclarations()) {
			if (modelDeclaration.getDriverNameExpression().getName().equals("EMF"))
				module.getCompilationContext().setModelFactory(new SubEmfModelFactory());
		}
		module.getContext().setModule(module);
		long startTime = System.currentTimeMillis();
		if (module instanceof EolModule) {
			new EolStaticAnalyser().validate(module);
			long stopTime = System.currentTimeMillis();
			System.out.println("Static Analysis Took : " + (stopTime - startTime));
		}

	}
}
