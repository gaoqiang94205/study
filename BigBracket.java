 package com.gq.regex;

import java.util.Random;

public class BigBracket {
  static Random ran = new Random();
  StringBuffer sb =new StringBuffer();
  
  static Generate ge = null;
  public static void deal(StringBuffer sb1,String regexp,String args){
	  String clas = "com.gq.regex."+regexp;
	try {
		ge = (Generate) Class.forName(clas).newInstance();
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	String[] nu = args.split(",");	
	  if(nu.length==2){
		String[] nm = args.split(",");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		int num = ran.nextInt(m-n+1);
		create(n,m,sb1);
	  }
	  if(nu.length==1){
		    if(nu[0].contains(",")){
		    String[] nm = args.split(",");
		    int n = Integer.parseInt(nm[0]);
	        create(n, 20,sb1);
		  }else{
			  int n = Integer.parseInt(args);
			  create(n, n,sb1);
		  }
	  }
  }
  public static void MidDeal(String midReg,String num,StringBuffer sb){
	  int nums = 0;
	  String[] nm = num.split(",");
	  if(nm.length==2){
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			nums =n + ran.nextInt(m-n+1);
		  }
		  if(nm.length==1){
			  //String[] nm = num.split(",");
			  if(num.contains(",")){
			    int n = Integer.parseInt(nm[0]);
			    int m = 20;   //前提是20大于n
			    nums =n + ran.nextInt(m-n+1);
			  }else{
				  int n = Integer.parseInt(nm[0]);
				  nums = n;  
			  }
		  }
		 
	  for(int i=0;i < nums;i++){
		  char c = MidBracket.generate(midReg);
          sb.append(c);		  
	  }
  }
  public static void LitDeal(String litReg,String num,StringBuffer sb){
	  String[] nm = num.split(",");
	  int nums = 0;
	  if(nm.length==2){
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			nums =n + ran.nextInt(m-n+1);
		  }
		  if(nm.length==1){
			  if(num.contains(",")){
			    int n = Integer.parseInt(nm[0]);
			    int m = 20;   //前提是20大于n
			    nums =n + ran.nextInt(m-n+1);
			  }else{
				  int n = Integer.parseInt(num);
				  nums = n;	  
			  }
		  }
	  for(int i=0;i < nums;i++){
		  String s = LittleBra.deal(litReg);
          sb.append(s);		  
	  }
  }
  
  public static void create(int n,int m,StringBuffer sb){
	int num = n + ran.nextInt(m-n+1);
		  for(int i=0;i<num;i++){
			   char c = (char)ge.genera();
			   sb.append(c);
		  }
  }
  
  public static void main(String[] args) {
	 BigBracket bk = new BigBracket();
	 //bk.deal(bk.sb,"Upper", "2,5");
	 //bk.LitDeal("shdbs", "3", bk.sb);
	 bk.MidDeal("[^a-z[scs]]", "2,", bk.sb);
	  String s = new String(bk.sb);
	  System.out.println(s);
}
}
