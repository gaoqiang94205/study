package com.gq.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class MidBracket {
	
	static Random ran = new Random();
	
	public static char generate(String argu){ //嵌套生成字符方法
		char back;
		List<Character> res = new ArrayList<Character>();
		StringTokenizer tokens = new StringTokenizer(argu, "[]");
		while(tokens.hasMoreTokens()){
		   String str = tokens.nextToken();		   
		   res.add(deal(str));
		}
		 int selest = ran.nextInt(res.size());
		 back = res.get(selest);
//System.out.println(back);		 
		 return back;
	}
	
	public static char deal(String paras) { //单一生成方法
	  List<Character> range = new ArrayList<Character>();
	  List<Character> tmp = new ArrayList<Character>();
	  char[] cs = paras.toCharArray();
	  boolean reverse = false;
	  char back = 'a';
	  for(int i=0;i<cs.length;i++){
		 if(cs[i]=='^'){//处理以^开头的正则
			 reverse = true;
			 //i++;
			 //tmp.add(cs[i]);
		 }
		 else if(cs[i] =='-'){//正则中的范围处理
			 i++;
			 tmp.add(cs[i]);
			 if(!reverse){
				 int size = tmp.size()-1;
				 int max = (int)tmp.get(size);
				 int min = (int)tmp.get(size-1);
				 range.remove(range.size()-1);
				 range.add(geneChar(max, min));
			 }else{
				 int size = tmp.size()-1;
				 int max = (int)tmp.get(size);
				 int min = (int)tmp.get(size-1);
				 range.remove(range.size()-1);
				 for(int j=min;j<=max;j++){
					 range.add((char) j);
				 }
			 } 
		}else if(cs[i]  =='|'){//逻辑或处理
			 i++;
			 tmp.add(cs[i]);
			 int size = tmp.size() - 1;
			 char min = tmp.get(size);
			 char max = tmp.get(size - 1);
			 range.remove(range.size()-1);
			 double r = ran.nextDouble();
			 if(r > 0.5){
				 range.add(min);
			 }else{
				 range.add(max);
			 }
		 }else if(cs[i] ==','){
	        //处理
			
		 } else{
		   tmp.add(cs[i]);
		   range.add(cs[i]);
		 }
	  }//最终结果分为两种情况  1.取反  2.不取反
	  if(reverse){  //取反
			 int base = 62 + ran.nextInt(62);
			 while(contain(base,range)){
				 base = 62 + ran.nextInt(62);
			 }
			 back = (char) base;
	  }else{  //不取反
		  int selest = ran.nextInt(range.size());
		  back = range.get(selest);
	  }
	  return back;
	}
	
	public static boolean contain(int a,List<Character> b){//自己实现的contain方法，可以用List的contains（）方法替换
	   boolean con = false;
		for(int i=0;i<b.size();i++){
		  if(a == b.get(i))
			  con = true;
	  }	
		return con;
	}
	
	public static char geneChar(int max,int min){//根据一个范围生成字符
	  Random ran = new Random();
		int miAscll = min;
		int  maxAscll = max;
		char result;
		int a = maxAscll - miAscll;
		int range = ran.nextInt(a + 1);
		result = (char)(miAscll + range);
		return result;
	}
	
  public static void main(String[] args) {//测试主类
	//List li = new MidBracket().deal("b|c");
	  
	/*for(int i=0;i<li.size();i++){
		System.out.print(li.get(i)+"  ");
		if(i==5){
			System.out.println();
		}
	}*/
	  new MidBracket().generate("[^a-z[str]]");;
	 //System.out.println(r);
}
  public void pastArgu(String argus){
	  List<String> li = new ArrayList<>();
	  char[] ch = argus.toCharArray();
	  for(int i=0;i<ch.length;i++){
		  
	  }
  }
}
