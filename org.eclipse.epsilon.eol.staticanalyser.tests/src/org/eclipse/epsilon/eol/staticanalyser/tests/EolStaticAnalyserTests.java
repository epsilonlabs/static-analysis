package org.eclipse.epsilon.eol.staticanalyser.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.staticanalyser.EolStaticAnalyser;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolType;
import org.junit.Test;

public class EolStaticAnalyserTests {

	@Test
	public void testPrimitiveTypesVariableDeclaration() throws Exception {
		assertValid("var i : Integer; (/*Integer*/i).println();");
		assertValid("var b : Boolean; (/*Boolean*/b).println();");
		assertValid("var s : String; (/*String*/s).println();");
		assertValid("var r : Real; (/*Real*/r).println();");
	}

	@Test
	public void testPrimitiveTypesAssignmentExpression() throws Exception {
		StringBuffer st = new StringBuffer();
		st.append("var i : Integer = 4;");
		st.append("var s : String = \"test\";");
		st.append("(/*Integer*/i) = (/*String*/s);");
		st.append("var a : Any = true;");
		st.append("(/*Any*/ a) = (/*String*/s);");
		assertValid(st.toString());
	}

	@Test
	public void testCollectionTypesAssignmentExpression() throws Exception {
		StringBuffer st = new StringBuffer();
		st.append("var col : Collection<Integer> = Collection{0..9};\n");
		st.append("var seq : Sequence<Integer> = Sequence{0..9};\n");
		st.append("var bg : Bag<Integer> = Bag{0..9};\n");
		st.append("(/*Bag<Integer>*/bg) = (/*Collection<Integer>*/col);\n");
		assertValid(st.toString());
	}

	@Test
	public void testPrimitiveTypesAssignmentExpressionErrorMessage() throws Exception {
		StringBuffer st = new StringBuffer();
		st.append("var i : Integer = 4;");
		st.append("var s : String = \"test\";");
		String expectedMessage = "String cannot be assigned to Integer";
		st.append("i = s;");
		assertValidMessage(st.toString(),expectedMessage);
	}

	public void assertValid(String eol) throws Exception {
		EolModule module = new EolModule();
		module.parse(eol);
		EolStaticAnalyser staticAnalyser = new EolStaticAnalyser();
		staticAnalyser.validate(module);
		visit(module.getChildren());
	}

	public void assertValidMessage(String eol, String message) throws Exception {
		EolModule module = new EolModule();
		module.parse(eol);
		EolStaticAnalyser staticAnalyser = new EolStaticAnalyser();
		List<ModuleMarker> errors = staticAnalyser.validate(module);
		assertEquals(message, errors.get(0).getMessage());
	}

	protected void visit(List<ModuleElement> elements) {
		for (ModuleElement element : elements) {
			if (!element.getComments().isEmpty()) {
				assertEquals(element.getComments().get(0).toString(), getResolvedType(element).toString());
			}
			visit(element.getChildren());
		}
	}

	protected EolType getResolvedType(ModuleElement element) {
		return (EolType) element.getData().get("resolvedType");
	}
}
