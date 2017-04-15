import java.util.*; 
import java.io.*;

class Function {
	int AdditivePersistence(int num) {

		// code goes here
		/*
		 * Note: In Java the return type of a function and the parameter types
		 * being passed are defined, so this return call must match the return
		 * type of the function. You are free to modify the return type.
		 */
		int number = num;
		int counter = 0;
		int numToAdd = 0;
		int conditionCounter = 0;
		while (number > 0) {
			numToAdd += number % 10;
			number = number / 10;
			if (number == 0) {
				conditionCounter++;
				number = numToAdd;
				counter++;
				if (number < 10) {
					number = 0;
					if (conditionCounter == 1)
						counter = 0;
				}
				numToAdd = 0;
			}
		}
		num = counter;
		return num;

	}
	
	
	
	int WordCount(String str) { 
		  
	    // code goes here   
	    /* Note: In Java the return type of a function and the 
	       parameter types being passed are defined, so this return 
	       call must match the return type of the function.
	       You are free to modify the return type. */
		
		String[] words = str.split(" ");
		return words.length;
	  } 
	
	
	
		  String ABCheck(String str) { 
		  
		    // code goes here   
		    /* Note: In Java the return type of a function and the 
		       parameter types being passed are defined, so this return 
		       call must match the return type of the function.
		       You are free to modify the return type. */
			  char[] Arr = str.substring(0, str.length()).toCharArray();
			  for(int i=0;i<Arr.length;i++){
				  if(Character.toLowerCase(Arr[i])=='a' && i+4<Arr.length){
					  char compare = Arr[i+4];
					  if(Character.toLowerCase(compare)=='b')
						 return "true";
					  
				  }else if(Character.toLowerCase(Arr[i])=='b' && i+4<Arr.length){
					  char compare = Arr[i+4];
					  if(Character.toLowerCase(compare)=='a')
						 return "true";
					  
				 }
			  }
		       
		    return "false";
		    
		  } 
	
	
	 String AlphabetSoup(String str) { 
		  
		    // code goes here   
		/*
		 * Note: In Java the return type of a function and the parameter types
		 * being passed are defined, so this return call must match the return
		 * type of the function. You are free to modify the return type.
		 */
		String[] Arr = str.split(" ");

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Arr.length; i++) {
			char[] subArr = Arr[i].toCharArray();
			for(int j=0;j<subArr.length;j++){
				subArr[j] = Character.toLowerCase(subArr[j]);
			}
			Arrays.sort(subArr);
			sb.append(subArr);
			sb.append(" ");
		}
		str = sb.toString();
		return str;

		  } 
	
	
	String LetterChanges(String str) { 
		  
	    // code goes here   
	    /* Note: In Java the return type of a function and the 
	       parameter types being passed are defined, so this return 
	       call must match the return type of the function.
	       You are free to modify the return type. */
		
		 String Arr[] = str.split(" ");
		 Map<Character,Character> alphabetMap = new HashMap<Character, Character>();
		 alphabetMap.put('a', 'b');
		 alphabetMap.put('b', 'c');
		 alphabetMap.put('c', 'd');
		 alphabetMap.put('d', 'e');
		 alphabetMap.put('e', 'f');
		 alphabetMap.put('f', 'g');
		 alphabetMap.put('g', 'h');
		 alphabetMap.put('h', 'i');
		 alphabetMap.put('i', 'j');
		 alphabetMap.put('j','k');
		 alphabetMap.put('k', 'l');
		 alphabetMap.put('l', 'm');
		 alphabetMap.put('m', 'n');
		 alphabetMap.put('n', 'o');
		 alphabetMap.put('o', 'p');
		 alphabetMap.put('p', 'q');
		 alphabetMap.put('q', 'r');
		 alphabetMap.put('r', 's');
		 alphabetMap.put('s', 't');
		 alphabetMap.put('t', 'u');
		 alphabetMap.put('u', 'v');
		 alphabetMap.put('v', 'w');
		 alphabetMap.put('w', 'x');
		 alphabetMap.put('x', 'y');
		 alphabetMap.put('y', 'z');
		 alphabetMap.put('z', 'a');
		 StringBuilder words = new StringBuilder();
		 for(int i = 0;i<Arr.length;i++)
		    {
		    		for(int j=0;j<Arr[i].toCharArray().length;j++){
		    			char[] subArr = Arr[i].toCharArray();
		    			char ch = subArr[j];
		    			if (Character.isLetter(ch) && !Character.isDigit(ch) && !Character.isWhitespace(ch)) 
		    			{
		    				char nextChar = alphabetMap.get(Character.toLowerCase(ch));
		    				
		    				if( Character.toUpperCase(nextChar)=='A'||Character.toUpperCase(nextChar)=='E'
		    				        ||Character.toUpperCase(nextChar)=='I'||Character.toUpperCase(nextChar)=='O'||Character.toUpperCase(nextChar)=='U')
		    					subArr[j] = Character.toUpperCase(nextChar);
		    				 else
		    					 subArr[j] = Character.toLowerCase(nextChar);
		    				
		    			}
		    			words.append(subArr[j]);
		    		}
		    	words.append(" ");	
		    	
		    }
		
	       str = words.toString();
	    return str;
	    
	  } 
	
	
	String TimeConvert(int num) { 
		  
	    // code goes here   
	    /* Note: In Java the return type of a function and the 
	       parameter types being passed are defined, so this return 
	       call must match the return type of the function.
	       You are free to modify the return type. */
		int hours = num/60;
		int minutes = num%60;
		
		return new String(hours+":").concat(String.valueOf(minutes));
	    
	  } 
	
	
	 String Palindrome(String str) { 
		  
		    // code goes here   
		    /* Note: In Java the return type of a function and the 
		       parameter types being passed are defined, so this return 
		       call must match the return type of the function.
		       You are free to modify the return type. */
		 char[] Arr = str.toCharArray();
		 int j =0;
		 for(int i=Arr.length-1;i>=0;i--){
			 if(Character.isWhitespace(Arr[j]))
				 j++;
			 if(Character.isWhitespace(Arr[i]))
				 continue;
			 if(Arr[j]!=Arr[i])return "false";
			 j++;
		 }
		       
		    return "true";
	} 
	 
	 
	 String SecondGreatLow(int[] arr) { 
		  
		    // code goes here   
		    /* Note: In Java the return type of a function and the 
		       parameter types being passed are defined, so this return 
		       call must match the return type of the function.
		       You are free to modify the return type. */
		 int big = arr[0];
		 int secondBig = 0;
		 int low = arr[0];
		 int secondLow = 0;
		 for(int i =0;i<arr.length;i++){
			 if(arr[i]>=big){
				 secondBig = big;
				 big = arr[i];	
			 }
			 else if(arr[i]>=secondBig){
				 secondBig = arr[i];
			 }
			 
		 }
		 
		 for(int i =0;i<arr.length;i++){
			 if(low>=arr[i]){
				 secondLow = low;
				 low= arr[i];	
			 }
			 
		 }
		       
		    return String.valueOf(secondBig)+" "+String.valueOf(secondLow);
		    
		  } 
	
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    Function c = new Function();
   /* String str= "reverse";
    StringBuilder sb = new StringBuilder();
    char strAr[] =  str.toCharArray();
    for(int i=strAr.length-1;i>=0;i--){
        sb.append(strAr[i]);
    }
       str = sb.toString();*/
    /*int num=3;
    int result = 1;
    if(num==1||num==0)
      System.out.println(num);
    else {
      
    for(int i=1;i<=num;i++)
      result = result*i;
    }*/
    String longWord =  "hello";
    int longLength = 0;
    String result = "";
   
   /* for(int i = 0;i<Arr.length;i++)
    {
    	if(Arr[i].length()>longLength){
    		 boolean isLong = true;
    		for(int j=0;j<Arr[i].toCharArray().length;j++){
    			
    			char[] subArr = Arr[i].toCharArray();
    			if (!Character.isLetter(subArr[j])) 
    			{
    				isLong = false;
    				break;
    			}
    		}
    		if(isLong){
    		longLength = Arr[i].length();
    		result =  Arr[i];
    		}
    	}
    }*/
    
    /*StringBuilder sb1 = new StringBuilder();
    for(int i = 0;i<Arr.length;i++)
    {
    	StringBuilder sb = new StringBuilder();
		char subArr =Character.toUpperCase(Arr[i].charAt(0));
		Arr[i] = sb.append(subArr).append(Arr[i].substring(1, Arr[i].length())).toString();
		sb1.append(Arr[i]).append(" ");
    }*/
    
    char[] Arr = longWord.toCharArray();
    int vowelCount = 0;
    for(int i = 0;i<Arr.length;i++){
      char ch = Arr[i];
     if( Character.toUpperCase(ch)=='A'||Character.toUpperCase(ch)=='E'
        ||Character.toUpperCase(ch)=='I'||Character.toUpperCase(ch)=='O'||Character.toUpperCase(ch)=='U')
           vowelCount++;
    }
    
    
   /*char[] Arr = longWord.toCharArray();
    result = "true";
    for(int i = 0;i<Arr.length;i++)
    {
      if(Character.isLetter(Arr[i]) && !Character.isDigit(Arr[i]))
      {
        if(i==0||i==Arr.length-1)
          result =  "false";
          
        else if((i-1>=0 && Arr[i-1] != '+' ) && (i+1<Arr.length && Arr[i+1] != '+'))
        	 result =  "false"; 
      }
    }*/
    
   
    System.out.print(/*c.AdditivePersistence(new Integer(s.nextLine()))*/c.SecondGreatLow(new int[]{1,2,3,100})); 
  }   
  
}