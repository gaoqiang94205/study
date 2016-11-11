package com.gq.regex;

import java.util.Random;

public class Lower implements Generate {
    Random ran = new Random();
	public char genera() {
		int miAscll = 97;
		int  maxAscll = 122;
		char result;
		int range = ran.nextInt(maxAscll - miAscll);
		result = (char) (miAscll + range);
		return result;
	}
	
}