package com.gq.regex;

import java.util.Random;

public class Diginal implements Generate {
   Random ran = new Random();
	 public char genera() {
		int miAscll = 48;
		int  maxAscll = 57;
		char result;
		int range = ran.nextInt(maxAscll - miAscll);
		result = (char) (miAscll + range);
		return result;
	}


}
