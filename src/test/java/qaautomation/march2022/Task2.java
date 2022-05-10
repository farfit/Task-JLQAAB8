package qaautomation.march2022;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);
		char operator;
		Integer number1 = null, number2 = null, result;

		// create an object of Scanner class
		Scanner input = new Scanner(System.in);

		// ask users to enter operator
		System.out.println("Choose an operator: +, -, *, or /");
		operator = input.next().charAt(0);

		try {
			// ask users to enter numbers
			System.out.println("Enter first number");
			number1 = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("You have entered invalid data");
		}

		try {
			System.out.println("Enter second number");
			number2 = input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("You have entered invalid data");
		}

		switch (operator) {

		// performs addition between numbers
		case '+':
			result = number1 + number2;
			System.out.println(number1 + " + " + number2 + " = " + result);
			break;

		// performs subtraction between numbers
		case '-':
			result = number1 - number2;
			System.out.println(number1 + " - " + number2 + " = " + result);
			break;

		// performs multiplication between numbers
		case '*':
			result = number1 * number2;
			System.out.println(number1 + " * " + number2 + " = " + result);
			break;

		// performs division between numbers
		case '/':
			result = number1 / number2;
			System.out.println(number1 + " / " + number2 + " = " + result);
			break;

		default:
			System.out.println("Invalid operator!");
			break;
		}

		input.close();
	}

}
