package com.gq.regex;

import java.util.Random;

public class Alpha implements Generate{

    Random ran = new Random();
	public char genera() {
		double d = ran.nextDouble();
		char result;
		if(d>0.5){
			result = new Upper().genera();
		}else{
		    result = new Lower().genera();	
		}
		return result;
	}
}
