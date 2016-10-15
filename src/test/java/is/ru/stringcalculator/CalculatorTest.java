package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	//testing for the empty string rule
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	//testing if we input the number 1, should return 1
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	//checkin the addition of two numbers
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
	//checking the addition of multiple numbers
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

	@Test
	//testing for the newline character
	public void testNewLineSeperator() {
		assertEquals(12, Calculator.add("1,2\n9"));
	}
	
	//checking for negative nubmers
	@Rule
    public ExpectedException expectedException = ExpectedException.none();
	
	@Test
    public void testNegativeNumber(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Negatives not allowed: -1");
        Calculator.add("-1,2");
    }

    @Test
    public void testNegativeNumbers(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Negatives not allowed: -1");
        Calculator.add("1,2,-9,-4");
    }
	
}