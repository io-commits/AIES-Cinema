package Auxiliry;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InputVerifacator {

	final static int MAX_VALID_YR = 9999;
	final static int MIN_VALID_YR = 0000;

	public static Integer verifyYear(String input) throws Exception {
		Integer yearPublishedInteger = 0;

		if (input.length() == 4) {
			try {
				yearPublishedInteger = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Year published field must be a number");
			}
		} else {
			throw new Exception("Year length must be 4 digits");
		}

		return yearPublishedInteger;
	}

	public static Double verifyDouble(String componentName, String input) throws Exception {
		Double candidate = 0.0;

		try {
			candidate = Double.parseDouble(input);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(componentName + " must be a number");
		}
		if(candidate < 0)
		{
			throw new Exception(componentName + " must be non negative number");
		}
		
		return candidate;
	}

	public static String verifyName(String componentName, String input) throws Exception {
		for (Character c : input.toCharArray()) {

			if (Character.isDigit(c) == true) {
				throw new Exception(componentName + " name must contain letters only");
			}
		}

		return input;
	}

	public static String verifyDate(String input) throws Exception {
		SimpleDateFormat sdfDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		int year = 0;
		int month = 0;
		int day = 0;

		if (input.length() != 10) {
			throw new Exception("Date must be corresponding format: yyyy-mm-dd");
		}

		try {
			sdfDateFormat.format(sdfDateFormat.parse(input));
		} catch (ParseException e) {
			throw new Exception("Date must be corresponding format: yyyy-mm-dd");
		}

		try {
			year = Integer.parseInt(String.valueOf(input.toCharArray(), 0, 4));
		} catch (Exception e) {
			throw new Exception("Invalid year");
		}
		try {
			month = Integer.parseInt(String.valueOf(input.toCharArray(), 5, 2));
		} catch (Exception e) {
			throw new Exception("Invalid month");
		}
		try {
			day = Integer.parseInt(String.valueOf(input.toCharArray(), 8, 2));
		} catch (Exception e) {
			throw new Exception("Invalid day");
		}

		if (isValidDate(day, month, year) == false) {
			throw new Exception("Date does not exists");
		}

		return input;
	}

	public static String verifyTime(String input) throws Exception {
		Integer hour;
		Integer min;
		
		if (input.length() != 5) {
			throw new Exception("Time must correspond to this format : HH:MM - 24 Hours format");
		}

		try {
			hour = Integer.parseInt(String.valueOf(input.toCharArray(), 0, 2));
		} catch (Exception e) {
			throw new Exception("Incorrect Hour");
		}
		if(hour < 0 || hour > 23)
		{
			throw new Exception("Hour must be on 24 hour format between values of 0 to 23");
		}
		
		if(input.charAt(2) != ':')
		{
			throw new Exception("The character ':' must seperate HH and MM");
		}
		
		try {
			min= Integer.parseInt(String.valueOf(input.toCharArray(), 3, 2));
		} catch (Exception e) {
			throw new Exception("Incorrect Hour");
		}
		if(min < 0 || min > 59)
		{
			throw new Exception("Minute must be between values of 0 to 59");
		}

		return input;
	}

	public static Integer verifyTheatreRangeItem(String componentName, String inputValue, Integer maxRange)
			throws Exception {
		Integer returnedInteger = 0;
		try {
			returnedInteger = Integer.parseInt(inputValue);
		} catch (NumberFormatException nfe) {
			throw new Exception(componentName + " must be a number");
		}

		if (returnedInteger < 1 || returnedInteger > maxRange) {
			throw new Exception(componentName + " entered is out of range");
		}

		return returnedInteger;
	}

	public static Integer verifyId(String input) throws Exception {

		Integer result = 0;
		try {
			result = Integer.parseInt(input);
		} catch (NumberFormatException nfe) {
			throw new Exception("ID must be a number");
		}

		if (input.length() != 9) {
			throw new Exception("ID must contain precisely 9 digits");
		}

		return result;
	}

	private static boolean isValidDate(int d, int m, int y) {
// If year, month and day  
// are not in given range 
		if (y > MAX_VALID_YR || y < MIN_VALID_YR)
			return false;
		if (m < 1 || m > 12)
			return false;
		if (d < 1 || d > 31)
			return false;

// Handle February month 
// with leap year 
		if (m == 2) {
			if (isLeap(y))
				return (d <= 29);
			else
				return (d <= 28);
		}

// Months of April, June,  
// Sept and Nov must have  
// number of days less than 
// or equal to 30. 
		if (m == 4 || m == 6 || m == 9 || m == 11)
			return (d <= 30);

		return true;
	}

	private static boolean isLeap(int year) {
		// Return true if year is
		// a multiple of 4 and not
		// multiple of 100.
		// OR year is multiple of 400.
		return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
	}
}
