package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

	@Test
	public void testTrueAdd() {
		Assert.assertEquals(MathQuestionService.q1Addition("1", "2"), 3, 0);
	}

	@Test
	public void testAddNumber1Empty() {
		 try {
	            MathQuestionService.q1Addition("", "2");
	            Assert.fail("Expected NumberFormatException");
	        } catch (NumberFormatException e) {
	            // This is expected behavior since empty string cannot be converted to double
	            Assert.assertTrue(true);
	        }
	}	
	@Test
	public void testSubtractionPositiveResult() {
	    Assert.assertEquals(MathQuestionService.q2Subtraction("5", "2"), 3, 0);
	}

	@Test
	public void testSubtractionNegativeResult() {
	    Assert.assertEquals(MathQuestionService.q2Subtraction("2", "5"), -3, 0);
	}

	@Test
	public void testSubtractionBothNumbersZero() {
	    Assert.assertEquals(MathQuestionService.q2Subtraction("0", "0"), 0, 0);
	}
	@Test
	public void testMultiplicationPositiveResult() {
	    Assert.assertEquals(MathQuestionService.q3Multiplication("3", "4"), 12, 0);
	}

	@Test
	public void testMultiplicationOneNumberZero() {
	    Assert.assertEquals(MathQuestionService.q3Multiplication("5", "0"), 0, 0);
	}

	@Test
	public void testMultiplicationBothNumbersZero() {
	    Assert.assertEquals(MathQuestionService.q3Multiplication("0", "0"), 0, 0);
	}
	@Test
	public void testDivisionIntegerResult() {
	    Assert.assertEquals(MathQuestionService.q4Division("10", "2"), 5, 0);
	}

	@Test
	public void testDivisionFloatingPointResult() {
	    Assert.assertEquals(MathQuestionService.q4Division("5", "2"), 2.5, 0);
	}

}
