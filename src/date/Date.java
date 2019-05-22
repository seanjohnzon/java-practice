package date;

/**
 * This course project is copyright of CyberTek ©CyberTek[2017]. All rights reserved. 
 * Any redistribution or reproduction of part or all of the contents in any form is 
 * prohibited without the express consent of CyberTek.
 */

import java.util.Calendar;

public class Date implements Comparable<Date> {

	private static final int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	protected final int month;
	protected final int day;
	protected final int year;

	/*
	 * Initialized a new date from the month, day and year.
	 * 
	 * @param month the month (between 1 and 12)
	 * 
	 * @param day the day (between 1 and 28-31, depending on the month)
	 * 
	 * @param year the year
	 * 
	 */

	public Date(int month, int day, int year) {
		if (!isValid(month, day, year)) {
			System.out.println("Invalid Date");
			throw new IllegalArgumentException();
		}
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/*
	 * @return month of that month
	 */
	public int getMonth() {
		return this.month;
	}

	/*
	 * @return day of that day
	 */
	public int getDay() {
		return this.day;
	}

	/*
	 * @return year of that year
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * This method checks if a given date is a valid calendar date
	 * 
	 * @param m month
	 * @param d day
	 * @param y year. (A year is no less than 1900, and no greater than 2100)
	 * @return true if the given date is a valid calendar date. false otherwise
	 */
	public static boolean isValid(int m, int d, int y) {
		if(m>0 && m<13 && d>0 && d<32 && y>1900 && y<2100) {
			return true;
		}
		return false;

	}

	/**
	 * @param year
	 * @return true if the given year is a leap year. false otherwise.
	 */
	public static boolean isLeapYear(int year) {
		 if ((year % 4 == 0 && (year % 100 !=0)) || year % 400 == 0 ) {
             return true;
          } 
            return false;      
          }

	/**
	 * Compare this date to that day.
	 * 
	 * @return {a negative integer or zero or a positive integer}, depending on
	 *         whether this date is {before, equal to, after} that date
	 */

	public int compareTo(Date that) {
		if(this.year > that.year) {
			return 1;
		}
		else if(this.year < that.year) {
			return -1;
		}
		if(this.month > that.month) {
			return 1;
		}
		else if(this.month < that.month) {
			return -1;
		}
		if(this.day > that.day) {
			return 1;
		}
		else if(this.day < that.day) {
			return -1;
		}
		return 0;
	}

	/**
	 * Return a string representation of this date.
	 * 
	 * @return the string representation in the format MM/DD/YYYY
	 */
	public String toString() {
		return(month + "/"+day+"/"+year);
	}

	/**
	 * 
	 * @return the word representation of the date. Example: (new
	 *         Date(12,1,2017)).dateToWords() returns "December One Two Thousand
	 *         Seventeen"
	 */
	public String dateToWords() {
		String[] monthWords = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String[] numbersLessThanTen = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
				"Ten" };
		String[] numbersBetweenTenAndTwenty = { "", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
				"Seventeen", "Eighteen", "Nineteen" };
		String[] multiplesOfTen = {"","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		String[] yearWords = { "Hundred", "Thousand" };
		String d, m, y;
		
			m = monthWords[this.month];
			if(this.day<10 && this.day>0) {
				d = numbersLessThanTen[this.day];
			}
			else if(this.day>=10 && this.day<20) {
				d = numbersBetweenTenAndTwenty[this.day%10];
			}
			else {
			int first = this.day/10;
			int second = this.day%10;
			d = multiplesOfTen[first] +" "+ numbersLessThanTen[second];
			}
			int firstYear = this.year/1000;
			int secondYear = this.year/100%10;
			int lastYear = this.year%100;
			if(lastYear==0) {
				y = numbersLessThanTen[firstYear]+" "+yearWords[1]+" "+numbersLessThanTen[secondYear];
			}
			else if(lastYear<10 && lastYear>0) {
				y = numbersLessThanTen[firstYear]+" "+yearWords[1]+" "+numbersLessThanTen[secondYear]+" "+yearWords[0]+" "+numbersLessThanTen[lastYear];
			}
			else if(lastYear>=10 && lastYear<20) {
				y = numbersLessThanTen[firstYear]+" "+yearWords[1]+" "+numbersLessThanTen[secondYear]+" "+yearWords[0]+" "+numbersBetweenTenAndTwenty[lastYear%10];
			}
			else {
				y = numbersLessThanTen[firstYear]+" "+yearWords[1]+" "+numbersLessThanTen[secondYear]+" "+yearWords[0]+" "+multiplesOfTen[lastYear/10]+" "+numbersLessThanTen[lastYear%10];
			}
			String date = "";
			date += m+" "+d+" "+y;
			
		return date;
	}

	public int age() {
		Calendar cal = Calendar.getInstance();
		int d = cal.get(Calendar.DAY_OF_MONTH);
		int m = cal.get(Calendar.MONTH); // starts from 0 to 11
		int y = cal.get(Calendar.YEAR);

		int age = 0;

		   age = y - this.year;
	        if (m < this.month)
	        {
	            age--;
	        } else if (m == this.month)
	        {
	            if (this.day >= d)
	            {
	                age++;
	            }
	        }
	        
		return age;
	}

}