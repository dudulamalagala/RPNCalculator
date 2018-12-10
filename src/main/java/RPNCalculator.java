package main.java;

import java.util.*;

public class RPNCalculator {
	private static Scanner input = new Scanner(System.in);
	private static Stack<Double> operands = new Stack<Double>();
    
	public static void calculator() {

        System.out.println("Welcome to the RPN Calculator program!");

        System.out.println("Enter list of number and operator strings containing whitespace seperated, Q to quit.  ");
        
        boolean done = false;
        String in = "";
        while (!done)
        {
        	in = input.nextLine();
        	if (in.equals("Q") || in.equals("q"))
        	 {
        	 done = true;
        	 }
        	solveEquation(in);         
        }
    }
	
	public static double solveEquation(final String input) {
			
		List<String> tokenizedInput = Arrays.asList(input.split(" "));

		for (String currentToken : tokenizedInput) {
			try {
				double inputAsInt = Integer.parseInt(currentToken);
				operands.push(inputAsInt);
				continue; // move to the next iteration of the loop
			} catch (NumberFormatException exception) {
				// do nothing, just continue
			}
            
			try {
				if (currentToken.contains("+")) {
					double total = operands.pop() + operands.pop();
					operands.push(total);
					
				} else if (currentToken.contains("-")) {
					double secondNum = operands.pop();
					double total = operands.pop() - secondNum;
					operands.push(total);
					
				} else if (currentToken.contains("*")) {
					double total = operands.pop() * operands.pop();
					operands.push(total);
					
				} else if (currentToken.contains("/")) {
					double secondNum = operands.pop();
					double total = operands.pop() / secondNum;
					operands.push(total);
					
				}  else if (currentToken.toUpperCase().contains("SQRT")){
					double number = operands.pop();
					double total = Math.sqrt(number);
					operands.push(total);
					
					
				} else if (currentToken.toUpperCase().contains("UNDO")){
					operands.remove(operands.pop());
			   
				} else if (currentToken.equals("clear")){
					operands.removeAllElements();
				} 
			} catch (Exception e) {
			   System.out.println("operator " + currentToken + "(position: "+(tokenizedInput.size()+1)+"): insufficient parameters");
			   System.out.print("Stack: "+tokenizedInput.size());
			   System.exit(0);
			}
		}
		System.out.print("Stack:");
		for (int i = 0; i < operands.size(); i++) {
            System.out.print(operands.get(i)+" ");
        }
		System.out.println("t"+operands.lastElement());
		return operands.size()> 0?operands.lastElement():0.0;
		
   }
	
	public static void main(String[] args) {
		try {
        	calculator();
        } catch (Exception e) {
            System.out.println("Oops, that doesn't work... ");
        }
	}

}
