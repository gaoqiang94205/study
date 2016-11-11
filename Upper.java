package com.gq.regex;

import java.util.Random;

public class Upper implements Generate {
    Random ran = new Random();
	public char genera() {
		int miAscll = 65;
		int  maxAscll = 90;
		char result;
		int range = ran.nextInt(maxAscll - miAscll);
		result = (char) (miAscll + range);
		return result;
	}

}
