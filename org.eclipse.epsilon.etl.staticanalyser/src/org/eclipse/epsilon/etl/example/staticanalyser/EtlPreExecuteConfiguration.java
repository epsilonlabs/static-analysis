package org.eclipse.epsilon.etl.example.staticanalyser;

import org.eclipse.epsilon.emc.emf.SubEmfModelFactory;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.dom.ModelDeclaration;
import org.eclipse.epsilon.eol.launch.EolRunConfiguration;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.staticanalyser.EtlStaticAnalyser;

public class EtlPreExecuteConfiguration extends EolRunConfiguration {
	IEolModule module;

	public EtlPreExecuteConfiguration(EolRunConfiguration other) {
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
		if (module instanceof EtlModule) {
			new EtlStaticAnalyser().validate(module);
			long stopTime = System.currentTimeMillis();
			System.out.println("Static Analysis Took : " + (stopTime - startTime));
		}

	}
}
