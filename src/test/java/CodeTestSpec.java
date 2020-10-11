package test.java;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import javafx.beans.binding.When;
import junit.framework.AssertionFailedError;
import main.java.CodeTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/*
 *   Please code the tests in the format of reverseArray_returnsExpectedResult. This is an example of how we write our tests at Cardano.
 *
 *   Test 1-4 tests are easy as the function returns a result that can be asserted. Tests 5-7 are more difficult to assert as they are
 *   void, use your knowledge to write a meaningful test.
 *
 *   Feel free to use the internet to help you with you answers but make sure you understand the answer as we will ask you questions.
 */

public class CodeTestSpec {
	
	private CodeTest codeTest = new CodeTest();
	private final PrintStream standarOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
    @Test
    public void reverseArray_returnsExpectedResult() {
        // arrange
        final String[] EXPECTED = {"x", "y", "z"};

        // act
        final String[] actual = CodeTest.reverseArray(new String[] {"z", "y", "x"});

        // assert
        assertArrayEquals(EXPECTED, actual);
    }

    @Test
    public void uppercaseArray_returnsExpectedResult() {
        // arrange
        final String[] EXPECTED = {"H","E","L","L","O"," ","W","O","R","L","D"};
        
        // act
        final String[] actual = CodeTest.uppercaseArray(new String[] {"h","e","l","l","o"," ", "w", "o", "r", "l", "d"});

        // assert
        assertArrayEquals(EXPECTED, actual);
        
    }

    @Test
    public void findWordCount_returnsExpectedResult() {
        // arrange
        final int EXPECTED = 2;
        
        // act
        final int actual = CodeTest.findWordCount(new String("the cat jumped over the mat"), new String("the"));

        // assert
        assertEquals(EXPECTED, actual);
        
    }

    @Test
    public void composeU_returnsExpectedResult() {
        // arrange
    	final Function<Integer,Integer> EXPECTED_FUNCTION = (value) -> (value + value) * 4;
    	final int EXPECTED = EXPECTED_FUNCTION.apply(5);
    	
        // act
        int actual = (CodeTest.composeU((value) -> value * 4, (value) -> value + value)).apply(5);

        // assert
        assertEquals(EXPECTED, actual);

    }

    @Before
    public void setUp() {
    	System.setOut(new PrintStream(outputStreamCaptor));
    }
    
    @Test
    public void writeContentsToConsole_returnsExpectedResult() throws IOException {
    	
    	final FileReader reader = new FileReader("java_code_test.txt");
    	
    	int character;
    	int count = 0;
    	String result = "";
    	while ((character = reader.read()) != -1) {
	        System.out.print((char) character);
	        result += (char)character;
	    }
        assertEquals(result, outputStreamCaptor.toString().trim());
        
    }

    @Test(expected= AssertionError.class)
    public void handleInvalidArgument_returnsExpectedResult() throws Exception {
    	
    	CodeTest.handleInvalidArgument();
    	Exception e = new Exception();
    	fail(e.getMessage());
    	
    }

    @Test
    public void puzzle_returnsExpectedResult() throws Exception {
    	// arrange
    	final String[] EXPECTED = {"1","2","3","3","snap"};
    	ArrayList<Long> numbers = new ArrayList<Long>(Arrays.asList(1L,2L,3L,3L,4L,5L,6L,7L));
    	boolean isFirsTime = true;
    	long numberRepeat = 0;
    	int count = 0;
    	String result = "";
    	for(long number: Arrays.asList(1,2,3,3,4,5,6,7)) {
    		count++;
    		if(isFirsTime) {
    			isFirsTime = false;
			} else {
				if(number == numberRepeat) {
					System.out.print("Snap");
					return;
				}
			}
    		numberRepeat = number;
    		result = (count < numbers.size())? numberRepeat + ",":numberRepeat + "";
    		System.out.print(result);
    	}
    	assertEquals(EXPECTED, outputStreamCaptor.toString().trim());
    }
    
}
