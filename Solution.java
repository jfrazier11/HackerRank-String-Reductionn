//refactor later

import java.io.*;
import java.util.Scanner;
import java.util.HashMap;

public class Solution {

   public static void main(String[] args){
		    Scanner scanner = new Scanner(System.in);
	        String str = scanner.nextLine().trim().replaceAll("\\s", "");
	        scanner.close();
	        if(!str.matches("[abc]+")){
                 	throw new RuntimeException("The String Can Only Contain The Following Characters: 'a' , 'b', or 'c' ");
	        }	        
	        System.out.println(test(str));
	       
	}
	public static int test(String str){
		HashMap<String,Character> myMap = new HashMap<>();
		myMap.put("ab", 'c');
		myMap.put("ac",'b');
		myMap.put("ba",'c');
		myMap.put("bc",'a');
		myMap.put("cb",'a');
		myMap.put("ca",'b');
		int i =0;
		while(str.length() != 1){
			if(str.matches("^a{1,}$|^b{1,}$|^c{1,}$")) return str.length();
			if(str.charAt(i) == str.charAt(i+1)){
				i++;
			}
			else{
				str = str.replaceFirst(Character.toString(str.charAt(i))+str.charAt(i+1), Character.toString(myMap.get(Character.toString(str.charAt(i))+str.charAt(i+1))));
				if(i != 0) i--;
			}
		}	
		return 1;
	}
}
