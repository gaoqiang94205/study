package com.gq.regex;

import java.util.StringTokenizer;

public class Test1 {
	public static void main(String[] args) {
	String str = "\\P{Upper}{2,10}";
	String str1 = "[djkjs]{11,20}";
	
  StringTokenizer st = new StringTokenizer(str1, "{}");
  System.out.println(st.countTokens());
  while(st.hasMoreTokens()){
	  System.out.println(st.nextToken()); 
  } 
 
}
}
