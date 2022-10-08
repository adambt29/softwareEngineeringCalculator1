import java.io.*;
import java.util.*;

public class Calculator {
    public  static String expression;
    public static boolean validExpression = true;

    public static void main(String[] args) throws IOException {

    }

    public static ArrayList<String> expressionToIntsAndOperatorString(String expression) {
        ArrayList<String> elements = new ArrayList<String>(0);
        boolean wasPrevOperator = false; // boolean to check if the previous character in expression was an operator

        String listOfIntChars = "0123456789"; // list of possible int chars
        String listOfOperatorChars = "+-*"; // list of possible operator chars
        int elementsIndex = 0; // starting index of string in 'elements' arraylist

        // Start with check that first char in string is not a mathematical operator
        if (!(expression.charAt(elementsIndex) == '+' || expression.charAt(elementsIndex) == '-'
                || expression.charAt(elementsIndex) == '*')) {
            for (int i = 0; i < expression.length(); i++) {

                // If there are two operators in a row:
                if ((wasPrevOperator)
                        && (expression.charAt(i) == '+' || expression.charAt(i) == '-'
                                || expression.charAt(i) == '*')) {
                    System.out.println("Invalid Expression: Duplicate operator(s)");
                    validExpression = false;
                    i = expression.length();
                }
                // if the character being looked at is invalid (not in the string of chars or
                // the string of operators)
                else if (!(listOfIntChars.contains(String.valueOf(expression.charAt(i)))) &&
                        !(listOfOperatorChars.contains(String.valueOf(expression.charAt(i))))) {
                    System.out.println("This is not a valid expression");
                    validExpression = false;
                    i = expression.length();
                    // if the character is valid but its the first of the expression just add it to
                    // the expression string arraylist
                } else if (listOfIntChars.contains(String.valueOf(expression.charAt(i))) && i == 0) {

                    elements.add(String.valueOf(expression.charAt(i)));
                }
                // if char is a number then add number to appropriate element slot in element
                // array & set was PrevOperator to False
                else if (listOfIntChars.contains(String.valueOf(expression.charAt(i)))) {
                    // if prev character was operator then just add new int char to arraylist
                    if (wasPrevOperator) {
                        elements.add(String.valueOf(expression.charAt(i)));
                        wasPrevOperator = false;
                        // if prev character was not operator, add the new int char to the currently
                        // indexed int string
                    } else {
                        wasPrevOperator = false;
                        elements.set(elementsIndex, elements.get(elementsIndex) + String.valueOf(expression.charAt(i)));
                    }
                }
                // if char is an operator then add operator to next element slot in element
                // string array
                // then move elementsIndex forward by 1 for following integer
                else if (listOfOperatorChars.contains(String.valueOf(expression.charAt(i)))) {
                    wasPrevOperator = true;
                    elements.add("place holder");
                    elementsIndex++;
                    elements.set(elementsIndex, String.valueOf(expression.charAt(i)));
                    elementsIndex++;
                }

            }
            // error output if first char in expression is a mathematical operator
        } else {
            System.out.println("Invalid Expression: Cannot start with mathematical operator");
            validExpression = false;
        }

        // error output if the last character in the expression is a mathematical
        // operator
        if (wasPrevOperator) {
            System.out.println("Invalid Operation: You must have an integer after every operand");
            validExpression = false;
        }

        return elements;
    }

    // To Be completed:
    // Will take expression, then call the above function to
    // convert into arraylist of ints and operators, then perform the necessary
    // maths to compute the result of that expression, outputting it as a string
    public static String finalResult(String expressionn) {
        ArrayList<String> listOfInput = expressionToIntsAndOperatorString(expressionn);
        return "null";
    }
}