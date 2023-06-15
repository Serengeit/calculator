/**
 *
 */
package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class main {
	// строка с римскими числами, 0 для соответствия индексов и элементов
	private static String[] romenumbers = { "0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII",
			"XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "IXX", "XX" };
	// проверка на римское число на вводе

	public static boolean isRoman(String num) {
		return Arrays.asList(romenumbers).contains(num);

	}

	// перевод ввода в целое число из римского
	public static int romanToInt(String num) throws Exception {
		int number = 0;
		number = Arrays.binarySearch(romenumbers, num);
		if (number > 10) {
			throw new Exception("Convertation error. Not a roman numeral or more than X.");
		}
		return number;
	}

	// результат из арабского в римское
	public static String intToRoman(int num) throws Exception {
		if (num < 1) {
			throw new Exception("Convertation error. Result less than 1");
		}
		String number = "";
		number = romenumbers[num];
		return number;
	}

	// вычисления согласно введёной операции
	public static int calculate(int numA, int numB, String operation) throws Exception {
		switch (operation) {
		case "+":
			return (numA + numB);
		case "-":
			return (numA - numB);
		case "/":
			if (numB == 0) throw new Exception("Division by zero/");
			return (numA / numB);
		case "*":
			return (numA * numB);
		default:
			throw new Exception("Calculation error. Operation not found.");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException, Exception {
		System.out.println("Run");
		// TODO Автоматически созданная заглушка метода
		// ввод с клавиатуры
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		//System.out.println(line);
		// достаем переменные из строки
		String[] elements = line.split(" ");
		// Исключаем не верный ввод
		if (elements.length != 3)
			throw new Exception("Wrong format.");
		// операция над числами
		String operation = elements[1];
		int numA = 0, numB = 0;
		// Если римские, то с преобразованием
		if (isRoman(elements[0]) && isRoman(elements[2])) {
			numA = romanToInt(elements[0]);
			numB = romanToInt(elements[2]);
			System.out.println(intToRoman(calculate(numA, numB, operation)));
		}
		// если арабские
		if (!isRoman(elements[0]) && !isRoman(elements[2])) {
			numA = Integer.parseInt(elements[0]);
			numB = Integer.parseInt(elements[2]);
			System.out.println(calculate(numA, numB, operation));
		}
		if (((isRoman(elements[0]) && !isRoman(elements[2]))) || (!isRoman(elements[0]) && isRoman(elements[2]))) {
			throw new Exception("Incorrect input. Only arabic or only roman numbers.");
		}

	}

}
