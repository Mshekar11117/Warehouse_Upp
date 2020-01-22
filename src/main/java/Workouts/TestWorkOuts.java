package Workouts;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestWorkOuts {
	
	/*public static void main(String[] args) {
		
		String reverse = "";
		String word = "Reverse the string";
		
		int length = word.length();
		for(int i=length-1; i>=0; i--) {
			
			reverse = reverse +word.charAt(i);
			System.out.println("Reverse--"+reverse);
		}
	}*/
	
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate= formatter.format(date);  
		System.out.println(strDate);
		
				
	}

}
