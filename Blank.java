package com.gq.regex;

import java.util.Random;

public class Blank implements Generate {

	 Random ran = new Random();
		public char genera() {
			double d = ran.nextDouble();
			System.out.println(d);			
			int result;
			if(d>0.5){
				result = 32;
			}else{
			    result = 9;	
			}
			return (char) result;
		}
}
