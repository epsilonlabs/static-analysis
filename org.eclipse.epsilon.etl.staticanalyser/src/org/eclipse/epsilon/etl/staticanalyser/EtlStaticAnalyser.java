package org.eclipse.epsilon.etl.staticanalyser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.staticanalyser.BuiltinEolModule;
import org.eclipse.epsilon.eol.staticanalyser.EolStaticAnalyser;
import org.eclipse.epsilon.erl.dom.Post;
import org.eclipse.epsilon.erl.dom.Pre;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.dom.TransformationRule;
import org.eclipse.epsilon.etl.dom.IEtlVisitor;

public class EtlStaticAnalyser extends EolStaticAnalyser implements IEtlVisitor {

	@Override
	public void visit(Post post) {
		if (post != null)
			post.getBody().accept(this);

	}

	@Override
	public void visit(Pre pre) {
		if (pre != null)
			pre.getBody().accept(this);

	}

	@Override
	public void visit(TransformationRule transformationRule) {
		transformationRule.getSourceParameter().accept(this);
		transformationRule.getTargetParameters().forEach(t -> t.accept(this));
		ExecutableBlock<Boolean> guard =transformationRule.getGuard();
		if(guard != null) {
			if(guard.getBody() instanceof StatementBlock) {
				StatementBlock guardBody = ((StatementBlock) guard.getBody());
				guardBody.accept(this);
			}
			else
				((Expression)guard.getBody()).accept(this);
		}
		ExecutableBlock<Void> rule =transformationRule.getBody();
		if(rule != null) {
		StatementBlock ruleBody = (StatementBlock) rule.getBody();
		ruleBody.accept(this);
		}

	}

	@Override
	public List<ModuleMarker> validate(IModule imodule) {

		errors = new ArrayList<>();
		if (!(imodule instanceof EtlModule))
			return null;
			EtlModule etlModule = (EtlModule) imodule;
			this.module = etlModule;
			context = (EolCompilationContext) etlModule.getCompilationContext();;
			
			super.preValidate(etlModule);
			for (Pre pre : etlModule.getDeclaredPre()) {
				pre.accept(this);
			}

			super.mainValidate(etlModule);
			for (TransformationRule tr : etlModule.getTransformationRules()) {
				tr.accept(this);
			}
			
			for (Post post : etlModule.getDeclaredPost()) {
				post.accept(this);
			}
			
			super.postValidate(etlModule);

			return errors;
		}

}
