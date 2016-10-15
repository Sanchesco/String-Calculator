package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if (text.contains("//")) {
			String[] split = splitNumbers(text,"\n");
			String delim = split[0].substring(2);
			return sum(splitNumbers(split[1], delim));
		}
		else
			return sum(splitNumbers(text, ",|\n"));
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String delim){
	    return numbers.split(delim);
	}
	
      
 	private static int sum(String[] numbers) throws IllegalArgumentException {
		int total_sum = 0;
		String errorMsg = "";
		for (String num : numbers) {
			if (toInt(num) < 0) {
				if (errorMsg == "") {
					errorMsg = num;
				}
				else {
					errorMsg.concat("," + num);
				}
			}
		}
		if (errorMsg != "") {
			throw new IllegalArgumentException("Negatives not allowed: " + errorMsg);
		}
		return total_sum;
	}


}