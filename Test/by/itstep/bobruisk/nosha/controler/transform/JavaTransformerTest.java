package by.itstep.bobruisk.nosha.controler.transform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JavaTransformerTest {

	private JavaTransformer transformer = new JavaTransformer();

	@Test
	public void toClassNameTest() {
		assertEquals("Bad transform class name", "ClassName", transformer.toClassName("class name"));
		assertEquals("Bad transform class name", "ClassName", transformer.toClassName("clasS namE"));
		assertEquals("Bad transform class name ", "Class", transformer.toClassName("clasS"));

	}

	@Test
	public void toCommentTest() {
		assertEquals("Bad transform comment", "Comment text", transformer.toComment("coMMent TExt"));
		assertEquals("Bad transform comment", "Comment text", transformer.toComment("comment text"));
		assertEquals("Bad transform comment ", "Comment", transformer.toComment("comment"));
	}

	@Test
	public void toConstantTest() {
		assertEquals("Bad transform constant", "CONSTANT_TEXT", transformer.toConstant("ConstAnt Text"));
		assertEquals("Bad transform constant", "CONSTANT_TEXT", transformer.toConstant("constant text"));
		assertEquals("Bad transform constant ", "CONSTANT", transformer.toConstant("constant"));
	}

	@Test
	public void toVariableTest() {
		assertEquals("Bad transform variable", "variableText", transformer.toVariable("variable text"));
		assertEquals("Bad transform variable", "variableText", transformer.toVariable("VARIABLE TEXT"));
		assertEquals("Bad transform variable ", "variable", transformer.toVariable("VaRiaBlE"));
	}
}
