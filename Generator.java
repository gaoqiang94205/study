package com.gq.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Generator {
	 StringBuffer sb = new StringBuffer(); //最终结果集
 
  public void genarate(String str) { 
	 ArrayList<String> P = new ArrayList<String>();//用于存储三种形式的列表
     ArrayList<String> B = new ArrayList<String>();
     ArrayList<String> K = new ArrayList<String>();
     
     int indexP = 0; //三种列表的下标
     int indexB = 0;
     int indexK = 0;
     
     String reg1 = "\\\\P(\\{[A-Za-z0-9,]+\\}){1,2}";//三种正则匹配最小单元
     String reg2 =  "\\[.+\\](\\{[0-9,]{1,3}\\}){0,1}";
     String reg3 = "\\(.+\\)(\\{[0-9,]{1,3}\\}){0,1}";
    
	 //String str = "a\\P{Upper}a(515)\\P{Lower}{2,10}[djkjs]{11}";
   
     SplitReg(reg1, str, P);
     SplitReg(reg2, str, B);
     SplitReg(reg3, str, K);
	 //String str = "aaaa\\P{Upper}\\P{Lower}{2,10}[djkjs]{11}(1112)";
	 
     String str1 = replace(str);
    
//System.out.println(str1);
	 String[] c = str1.split(" ");
	 
	 for(int i=0;i<c.length;i++){
		 
	   if(c[i].equals("P")){//匹配\\P{}类型的字符
		   String reg = P.get(indexP);
		   StringTokenizer st = new StringTokenizer(reg, "\\P{}");  
		   int count = st.countTokens();  //一般来说\\P{},[],()后面要么有限定字符或者没有两种情况
		    if(count ==1){
		    	String regExp = st.nextToken();
		    	indexP++;
		    	BigBracket.deal(sb, regExp, "1");
		    }else{
		    	String regExp = st.nextToken();
		    	String arg = st.nextToken();
		    	indexP++;
		    	BigBracket.deal(sb, regExp, arg);
		    }  
	   }
	   else if(c[i].equals("B")){ //匹配中括里面的内容
    	   String reg = B.get(indexB);
    	   StringTokenizer st = new StringTokenizer(reg, "{}");
    	   int count = st.countTokens();
    	   if(count == 1){
    		   String regExp = st.nextToken();
    		   BigBracket.MidDeal(regExp, "1", sb);
    		   indexB++;
    	   }else{
    		   String regExp = st.nextToken();
    		   String arg = st.nextToken(); 
    		   BigBracket.MidDeal(regExp, arg, sb);
    		   indexB++;
    	   }
	   }
       else if(c[i].equals("K")){
    	   String reg = K.get(indexK);
    	   StringTokenizer st = new StringTokenizer(reg, "(){}");
    	   int count = st.countTokens();
    	   if(count == 1){
    		   String Litreg = st.nextToken(); 
    		   BigBracket.LitDeal(Litreg, "1", sb);
    	   }else{
    		   String litReg = st.nextToken();
    		   String arg2 = st.nextToken();
    		   BigBracket.LitDeal(litReg, arg2, sb);
    	   }
	   }else{  //没有匹配的作为必须重现的字符单元
		   sb.append(c[i]); //追加到目标字符串中
	   }
	 }
	 
	 
	 }
 public static void SplitReg(String reg,String str,List<String> li){
	   Pattern patt = Pattern.compile(reg);
	      Matcher m1 = patt.matcher(str);
	      while (m1.find()) {
	          li.add(m1.group(0));            
	      } 
	    /*  for (String s : li){
	          System.out.print(s+"   ");
	      }
	      System.out.println();*/
  
 }
 
 public  String replace(String str){  //可以从配置文件中读取需要替换的正则表达式集合，然后依次替换
	 str = str.replaceAll("\\\\P(\\{[A-Za-z0-9,]+\\}){1,2}", " P ");
	 str = str.replaceAll("\\[.+\\](\\{[0-9,]{1,3}\\}){0,1}", " B ");
	 str = str.replaceAll("\\(.+\\)(\\{[0-9,]{1,3}\\}){0,1}", " K ");
	 return str;
 }
 public void split(String str) {
	//String str = "\\P{Upper}{2,10}";
      StringTokenizer st = new StringTokenizer(str, "\\P{}");
      System.out.println(st.countTokens());
    /*  while(st.hasMoreTokens()){
	    System.out.println(st.nextToken()); 
      } */ 
	}
	public static void main(String[] args) {
		Generator t = new Generator();
		String reg = "a\\P{Upper}and(515)\\P{Lower}{2,10}[^a-z[you]]{5}";
System.out.println("正则表达式为："+reg);
		t.genarate(reg);
		System.out.println(t.sb);
	}
 
}


