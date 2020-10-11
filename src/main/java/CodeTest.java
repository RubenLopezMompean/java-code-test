package main.java;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Function;

public class CodeTest {
    public static void main(String[] args) {
        System.out.println("Please replace this with calls to all completed tests.");
        //reverseArray test
        try {
        	System.out.println("---------------------------");
	        String[] numbersArray = {"1","2","3","4","5","6"};
	        String[] reverseNumbersArray = reverseArray(numbersArray);
	        String reverseNumber = "";
	        for(String number : reverseNumbersArray) {
	        	reverseNumber += number;
	        }
        	System.out.println(reverseNumber);
        	System.out.println();
        } catch(Exception e) {
        	System.out.println("Error executing reverseArray test");
        }
        //uppercaseArray test
        try {
        	System.out.println("---------------------------");
	        String[] wordArray = {"h","e","l","l","o"," ", "w", "o", "r", "l", "d"};
	        String[] uppercaseArray = uppercaseArray(wordArray);
	        String uppercaseWord = "";
	        for(String letter : uppercaseArray) {
	        	uppercaseWord += letter;
	        }
        	System.out.println(uppercaseWord);
        } catch(Exception e) {
        	System.out.println("Error executing uppercaseArray test. Error: " + e.getMessage());
        }
        //findWordCount test
        try {
        	System.out.println("---------------------------");
        	String text = "the cat jumped over the mat";
        	String wordToFind = "the";
        	int wordCount = findWordCount(text, wordToFind);
        	System.out.println("The word [" + wordToFind + "] appear " + wordCount + " times.");
        } catch(Exception e) {
        	System.out.println("Error executing findWordCount test. Error: " + e.getMessage());
        }
        //OPTIONAL wordsCount test
        try {
        	System.out.println("---------------------------");
        	String text = "the cat jumped over the mat";
        	String wordToFind = "the";
        	HashMap<String,Integer> wordCount = wordsCountHM(text);
        	System.out.println(wordCount.toString());
        } catch(Exception e) {
        	System.out.println("Error executing wordsCount test. Error: " + e.getMessage());
        }
        //writeContentsToConsole test
        try {
        	System.out.println("---------------------------");
        	writeContentsToConsole();
        } catch(Exception e) {
        	System.out.println("Error executing writeContentsToConsole test. Error: " + e.getMessage());
        }
        //composeU test
        try {
        	System.out.println("---------------------------");
	        Function<Integer,Integer> multiply = (value) -> value * 4;
	    	Function<Integer,Integer> addition = (value) -> value + value;
	    	Function<Integer,Integer> composeExample = composeU(multiply,addition);
	    	int example = composeExample.apply(5);
        	System.out.println("Example value: " + example + "\nComposeU function finish.");
        } catch(Exception e) {
        	System.out.println("");
        }
        //handleInvalidArgument test
        try {
        	System.out.println("---------------------------");
        	handleInvalidArgument();
        } catch(Exception e) {
        	System.out.println("Error executing handleInvalidArgument test. " + e.getMessage());
        }
        
        try {
        	System.out.println("---------------------------");
        	puzzle();
        } catch(Exception e) {
        	System.out.println("Error executing puzzle test. " + e.getMessage());
        }
        
    }

    /*
     * Create a function that accepts an array of numbers and returns a reversed array (e.g. [1,2,3] would be [3,2,1]
     */
    public static String[] reverseArray(String[] input) {
    	
    	int inputSize = input.length;
    	String[] newInput = new String[inputSize];
    	for(int x = 0; x < input.length; x++) {
    		newInput[inputSize - 1] = input[x];
    		inputSize--;
    	}
        return newInput;
    }

    /*
     * Write a function that transforms an array of strings to an upper-case array of strings
     */
    public static String[] uppercaseArray(String[] input) {
    	
    	String[] newInput = new String[input.length];
    	for (int x = 0; x < input.length; x++) {
    		newInput[x] = input[x].toUpperCase();
    	}
        return newInput;
    }

    /*
     * Given a sentence create a function that returns the number of unique words (e.g. 'the cat jumped over the mat' 
     * would be [{'the': 2}, {'cat': 1}…]
     */
    public static int findWordCount(String text, String wordToFind) {
    	
    	int count = 0;
    	while(text.contains(wordToFind)) {
    		int index = text.indexOf(wordToFind);
    		text = text.substring(index + wordToFind.length(), text.length());
            count++;
    	}
        return count;
    }
    
    /*
     * OPTIONAL findWordCount
     */
    public static HashMap<String,Integer> wordsCountHM(String text) {
    	HashMap<String,Integer> numberUniqueWords = new HashMap<String, Integer>();
    	String[] words = text.split(" ");
    	for(String word: words) {
    		int counts = 0;
    		if(numberUniqueWords.containsKey(word)) {
    			counts = numberUniqueWords.get(word);
    			numberUniqueWords.put(word, counts+1);
    		} else {
    			numberUniqueWords.put(word, 1);
    		}
    	}
    	return numberUniqueWords;
    }

    /*
     * Write a function 'composeu' that takes two unary functions and returns a unary function that calls them both. 
     * A unary function has a single argument and a single return value (e.g. f(d) { return d + 1}
     */
    public static Function<Integer,Integer> composeU(Function<Integer,Integer> f1, Function<Integer,Integer> f2){
    	
    	Function<Integer, Integer> newFunction = f1.compose(f2);
    	
        return newFunction;
    }

    /*
     * Write a function that reads from a file and prints the contents to the console
     */
    public static void writeContentsToConsole() throws IOException {
    	
    	try (FileReader reader = new FileReader("java_code_test.txt")) {
    	    int character;
    	 
    	    while ((character = reader.read()) != -1) {
    	        System.out.print((char) character);
    	    }
    	    System.out.println("\nwriteContestsToConsole() has been executed successfully");
    	} catch (IOException e) {
    	   throw  e;
    	}
    }

    /*
     * Give an example of how a function would handle an invalid argument
     */
	public static void handleInvalidArgument() throws Exception {
    	
    	try {
    		ArrayList<String> forceError = null;
    		Iterator<String> forceErrorIt = forceError.iterator();
    		while(forceErrorIt.hasNext())
    			System.out.println("I am inside");
    	} catch(Exception e) {
    		new Exception("Error: " + e.getMessage());
    	}
    }

	/*
	 * Write a console application that accepts a random sequence of numbers and loops through looking for 2 equal,
	 * consecutive numbers. When found write 'Snap' to the console else print out the number (e.g. 1,3,5,5,'Snap').
	 * 
	 */
    public static void puzzle() throws Exception {
        // add code here
    	 System.out.println ("Starting the program");
         ArrayList <Long> numbers = new ArrayList<Long>();
         String keyboardEnter = "";
         long numberRepeat = 0;
         boolean isFirsTime = true;
         int count = 0;
         String result = "";
         try {
        	 do {
        		 System.out.println ("Please enter a number per keyboard: ");
	             Scanner inputScanner = new Scanner(System.in);
	             keyboardEnter = inputScanner.nextLine();
	             try {
	            	 if(!keyboardEnter.equals("x"))
	            		 numbers.add(Long.valueOf(keyboardEnter));
	             } catch(Exception e) {
	            	 System.out.println("Wrong, you have to input a number, if you want out enter \"x\"");
	             }
        	 } while(!keyboardEnter.equals("x"));
        	 for(long number: numbers) {
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
        	 
         } catch(Exception e) {
     		throw new Exception("Error: " + e.getMessage());
         }
    }
}