package com.gq.regex;

import java.util.Random;

public class Alnum implements Generate{
	
    Random ran = new Random();
	public char genera() {
		double d = ran.nextDouble();
		char result;
		if(d>0.5){
			result = new Alpha().genera();
		}else{
		    result = new Diginal().genera();	
		}
		return result;
	}
}
