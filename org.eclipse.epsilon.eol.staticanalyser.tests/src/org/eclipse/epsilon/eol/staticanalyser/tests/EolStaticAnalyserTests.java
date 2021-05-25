package org.eclipse.epsilon.eol.staticanalyser.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.staticanalyser.EolStaticAnalyser;
import org.eclipse.epsilon.eol.types.EolType;
import org.junit.Test;

public class EolStaticAnalyserTests {
	
	@Test
	public void testPrimitiveTypes() throws Exception {
		assertValid("var i : Integer; (/*Integer*/i).println();");
		assertValid("var b : Boolean; (/*Boolean*/b).println();");
		assertValid("var s : String; (/*String*/s).println();");
		assertValid("var r : Real; (/*Real*/r).println();");
	}
	
	public void assertValid(String eol) throws Exception {
		EolModule module = new EolModule();
		module.parse(eol);
		EolStaticAnalyser staticAnalyser = new EolStaticAnalyser();
		staticAnalyser.validate(module);
		visit(module.getChildren());
	}
	
	protected void visit(List<ModuleElement> elements) {
		for (ModuleElement element : elements) {
			if (!element.getComments().isEmpty()) {
				assertEquals(element.getComments().get(0).toString(),
						getResolvedType(element).getName());
			}
			visit(element.getChildren());
		}
	}
	
	protected EolType getResolvedType(ModuleElement element) {
		return (EolType) element.getData().get("resolvedType");
	}
}
