package com.util;

public class IdGenerator {
  
  public static final void main(String... aArgs){
	  System.out.println(IdGenerator.getId());
	  System.out.println(IdGenerator.getId());
  }
  
  public static String getId(){
	long currentTime = System.currentTimeMillis();
	Double randomNum =  (Math.random() * 100);
	return String.valueOf(currentTime + randomNum.longValue());
  }
} 