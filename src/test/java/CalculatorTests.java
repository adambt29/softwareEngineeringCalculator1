import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;
import java.util.*;

public class CalculatorTests {
    public  ArrayList<String> testList=new ArrayList<String>(0);
    public  ArrayList<String> expectedList=new ArrayList<String>(0);

    // Test for basic addition of final function
    @Test
    public void addBasic() {
        org.junit.Assert.assertEquals(("7"), (Calculator.finalResult("5+2")));
    }

    @Test
    public void addAndSubtract() {
        org.junit.Assert.assertEquals("8", Calculator.finalResult("5+6-3"));
    }

    @Test
    public void multiply() {
        org.junit.Assert.assertEquals("10", Calculator.finalResult(" 5*2"));
    }

    @Test
    public void addAndMultiply() {
        org.junit.Assert.assertEquals("25", Calculator.finalResult("5+4*5"));
    }

    @Test
    public void subtractAndMultiply() {
        org.junit.Assert.assertEquals("-7", Calculator.finalResult("5-6*2"));
    }

    @Test
    public void invalidDuplicateOperator() {
        org.junit.Assert.assertEquals("Invalid Expression", Calculator.finalResult("5++2"));
    }

    @Test
    public void invalidExpression() {
        org.junit.Assert.assertEquals("Invalid Expression", Calculator.finalResult("5+2ergerg"));
    }
// now testing expressionToIntsAndOperatorString method

    @Test
    public void empty(){
        testList.add("0");
        expectedList.add("0");
        org.junit.Assert.assertEquals(expectedList,Calculator.expressionToIntsAndOperatorString("0"));
    }

    @Test
    public void invalid(){
        testList.add("+1-2");
        org.junit.Assert.assertEquals(expectedList,Calculator.expressionToIntsAndOperatorString("+1-2"));
    }
    @Test
    public void invalidDuplicatedSemiComplete(){
        testList.add("1+-2");
        expectedList.add("1");
        expectedList.add("+");
        org.junit.Assert.assertEquals(expectedList,Calculator.expressionToIntsAndOperatorString("1+-2"));
    }

    @Test
    public void simpleExpression(){
        testList.add("2+3");
        expectedList.add("2");
        expectedList.add("+");
        expectedList.add("3");
        org.junit.Assert.assertEquals(expectedList,Calculator.expressionToIntsAndOperatorString("2+3"));
    }
    @Test
    public void complexExpression(){
        testList.add("10*2+3-14");
        expectedList.add("10");
        expectedList.add("*");
        expectedList.add("2");
        expectedList.add("+");
        expectedList.add("3");
        expectedList.add("-");
        expectedList.add("14");
        org.junit.Assert.assertEquals(expectedList,Calculator.expressionToIntsAndOperatorString("10*2+3-14"));
    }

}
