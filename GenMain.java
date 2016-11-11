package com.gq.regex;

public class GenMain {
  public static void main(String[] args) {
	Generator ge = new Generator();
	String reg = "a\\P{Upper}and(515)\\P{Lower}{2,10}[^a-z[you]]{5}";
	String reg1 = "\\P{Upper}\\P{Lower}{2,10}";
System.out.println("正则表达式为："+reg1);
	ge.genarate(reg1);
	System.out.println(ge.sb);
}
}
