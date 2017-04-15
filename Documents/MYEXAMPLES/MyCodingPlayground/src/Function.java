import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function {

	String FirstReverse(String str) {
		String rev = "";
		char[] charStr = str.toCharArray();
		for (int i = charStr.length - 1; i >= 0; i--) {
			rev += charStr[i];
		}
		return rev;

	}

	int FirstFactorial(int num) {
		int dummy = 1;
		while (num > 0) {
			dummy = dummy * num;
			num--;
		}

		return dummy;
	}

	String Palindrome(String str) {
		// String[] revStr = str.split(" ");
		int cnt = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == ' ') {
				continue;
			}
			if (str.charAt(cnt) == ' ') {
				cnt++;
			}
			if (str.charAt(i) != str.charAt(cnt)) {
				return "false";
			}
			cnt++;
		}
		return "true";
	}

	String WordCount(String str) {

		return Integer.toString(str.split(" ").length);
		// return str;

	}

	String SecondGreatLow(int[] arr) {
		Arrays.sort(arr);
		if(arr.length==2){
			return String.valueOf(arr[1]+" "+arr[0]);
		}else{
			Integer a =0;
			int b =1;
			a=b;
		}
		return null;

	}
	
	 String ExOh(String str) { 
		  
		    /*
		     * Using the Java language, have the function ExOh(str) take the str parameter being passed and return the string true 
		     * if there is an equal number of x's and o's, otherwise return the string false. Only these two letters will be entered in the string, 
		     * no punctuation or numbers. 
		     * For example: if str is "xooxxxxooxo" then the output should return false because there are 6 x's and 5 o's.
		     * */
		    int xCount=0;
		    int oCount=0;
		    if(str.length()<=1)
		      return "false";
		    for(int i=0;i<str.length();i++){
		       if(str.charAt(i)=='x'||str.charAt(i)=='X')
		         xCount++;
		      else if(str.charAt(i)=='o'||str.charAt(i)=='O')
		        oCount++;
		    }
		    
		       
		    return xCount==oCount?"true":"false";
		    
		  } 
	
	
	String SimpleSymbols(String str) {
		/*
		 * :Test I/p: 2+a+a+ +d+ aaaa+z+z+z++a=2+a+a+==a+b
		 */
		for (int i = 0; i < str.length(); i++) {
			if (i == 0 && isAlphabet(str.charAt(i)))
				return "false";
			else if (i == str.length() - 1 && isAlphabet(str.charAt(i)))
				return "false";
			else if (isAlphabet(str.charAt(i))) {
				boolean found = false;
				for (int j = i - 1; j >= 0; j--) {
					if (str.charAt(j) == '=')
						continue;
					else if (isAlphabet(str.charAt(j)))
						return "false";
					else if (str.charAt(j) == '+') {
						found = true;
						break;
					}
				}
				if (!found)
					return "false";
				for (int k = i + 1; k < str.length(); k++) {
					if (str.charAt(k) == '=')
						continue;
					else if (isAlphabet(str.charAt(k)))
						return "false";
					else if (str.charAt(k) == '+') {
						found = true;
						break;
					}
				}
				if (!found)
					return "false";
			}
		}
		return "true";

	}

	private boolean isAlphabet(char ch) {
		if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
			return true;
		}
		return false;
	}
	
	String SwapCase(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isUpperCase(str.charAt(i)))
				sb.append(Character.toLowerCase(str.charAt(i)));
			else if (Character.isLowerCase(str.charAt(i)))
				sb.append(Character.toUpperCase(str.charAt(i)));
			else {
				sb.append(str.charAt(i));
				continue;
			}

		}
		return sb.toString();
	}
	
	String DivisionStringified(double num1, double num2) {

		// sample i/p:503394930 43
		int result = (int) Math.round(num1 / num2);
		String copyResult = String.valueOf((int) result);
		StringBuilder sb = new StringBuilder();
		if (copyResult.length() <= 3)
			return copyResult;
		else {
			// sb.append(copyResult).reverse();
			int cnt = 0;
			for (int i = copyResult.length() - 1; i >= 0; i--) {
				cnt++;
				sb.append(copyResult.charAt(i));
				if (cnt == 3) {
					sb.append(",");
					cnt = 0;
				}
			}
		}
	    
	       
	    return sb.reverse().toString();
	    
	  }
	
	
	String LetterChanges(String str) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			if (isAlphabet(str.charAt(i))) {
				char ch = str.charAt(i);
				if (ch == 'z') {
					ch = 'a';
				} else if (ch == 'Z') {
					ch = 'A';

				} else {
					ch++;
				}

				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o'
						|| ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
						|| ch == 'O' || ch == 'U') {
					ch = Character.toUpperCase(ch);
				}
				sb.append(ch);
			} else {

				sb.append(str.charAt(i));
			}
		}
		return sb.toString();

	}
	
	String ArithGeo(int[] arr) {
		if (arr.length <= 1)
			return "-1";
		int geometric = arr[1] / arr[0];
		int difference = Math.abs(arr[1]) - Math.abs(arr[0]);
		boolean isArithmetic = true;
		boolean isGeometric = true;
		for (int i = 0; i < arr.length - 1; i++) {
			if (((arr[i] < 0 || arr[i] > 0) || (arr[i] > 0 || arr[i] < 0))
					&& (arr[i + 1] + arr[i] == difference)) {
				continue;
			} else if (((arr[i] > 0 && arr[i] > 0) || (arr[i] < 0 || arr[i] < 0))
					&& (Math.abs(arr[i + 1]) - Math.abs(arr[i]) == difference)) {
				continue;
			} else {
				isArithmetic = false;
				break;
			}

		}

		if (isArithmetic)
			return "Arithmetic";

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] * geometric == arr[i + 1])
				continue;
			else {
				isGeometric = false;
				break;
			}

		}
		if (isGeometric)
			return "Geometric";

		return "-1";

	}
	
	String NumberAddition(String str) {
		int cnt = 0;
		//i/p:88Hello 3World!
		//o/p:91
		String[] arr = str.split("[^0-9]+");//split the given string by any character other than numbers.
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].trim().length() > 0) {
				try {
					cnt += Integer.parseInt(arr[i]);
				} catch (NumberFormatException nfe) {
					continue;
				}
			}
		}
		return String.valueOf(cnt);

	}
	
	int ArrayAdditionI(int[] arr) { 
		  
	    // code goes here   
	    /* Note: In Java the return type of a function and the 
	       parameter types being passed are defined, so this return 
	       call must match the return type of the function.
	       You are free to modify the return type. */
	     
	    return arr[0];
	    
	  } 
	
	
	String LetterCountI(String str) { 
		  
	   String[] words = str.split("[\\s]+");//split by empty spaces
	   Map<String,Map<Character,Integer>> wordLetterCount = new LinkedHashMap<String,Map<Character,Integer>>(); 
	   for(int i=0;i<words.length;i++){
		  wordLetterCount.put(words[i], getNumberOfChars(words[i]));
	   }
	       String greatest = findGreatestString(wordLetterCount);
	    return greatest.trim().length()>0?greatest:"-1";
	    
	  } 
	
	private Map<Character, Integer> getNumberOfChars(String word) {
		Map<Character, Integer> charCount = new HashMap<Character, Integer>();
		for (int i = 0; i < word.length(); i++) {
			if (charCount.containsKey(word.charAt(i))) {
				Integer x = charCount.get(word.charAt(i));
				charCount.put(word.charAt(i), x+=1);
			} else {
				charCount.put(word.charAt(i), 1);
			}
		}

		return charCount;
	}
	
	private String findGreatestString(Map<String, Map<Character, Integer>> words) {
		String greatest = "";
		int count = 0;
		for (String word : words.keySet()) {
			int innerCount = 0;
			if (words.get(word).keySet().size() == word.length()) {
				continue;
			}
			for (Character ch : words.get(word).keySet()) {
				if (words.get(word).get(ch) > 1)
					innerCount += words.get(word).get(ch);
			}
			if (innerCount > count) {
				count = innerCount;
				greatest = word;
			}
		}
		return greatest;
	}
	
	
	String CountingMinutesI(String str) { 
	    String[] time = str.trim().split("-");
	    int startTime = Integer.parseInt(time[0].split(":")[0]);
	    int startMinutes = Integer.parseInt(time[0].split("[a-z|A-Z|:]+")[1]);
	    String startMeridian = time[0].split("[0-9|:]+")[1];
	    int endTime =Integer.parseInt( time[1].split(":")[0]);
	    int endMinutes = Integer.parseInt(time[1].split("[a-z|A-Z|:]+")[1]);
	    String endMeridian = time[1].split("[0-9|:]+")[1];
	    boolean continueLoop = true;
	    int count = 0;
	    int endValue = startTime==12?0:startTime;
	    endTime = endTime==12? 0:endTime;
	    String judgeMeridian = startMeridian;
		while (continueLoop) {
			count++;
			if (endValue == 11) {
				endValue = 0;
			} else {
				endValue++;
			}
			
			if (endValue == 0) {
				if (judgeMeridian.equalsIgnoreCase("pm"))
					judgeMeridian = "am";
				else
					judgeMeridian = "pm";
			}
			if (String.valueOf(endTime).concat(endMeridian).equalsIgnoreCase(String.valueOf(endValue).concat(judgeMeridian))) {
				continueLoop = false;
			}
		}
		
		count *=60;
		if(startMinutes>0)
		count -=startMinutes;
		if(endMinutes>0)
		count+=endMinutes;
		return String.valueOf(count);

	}
	
	String DashInsert(String str) {
		//i/p:454793
		//insert dashes between odd numbers
		//o/p:4547-9-3
		StringBuilder dashInsert = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			int firstVal = Integer.parseInt(String.valueOf(str.charAt(i)));
			int secondVal = 0;
			if (i != str.length()-1)
				secondVal =Integer.parseInt(String.valueOf(str.charAt(i + 1)));
			if ((firstVal != 0 && secondVal != 0) && firstVal % 2 != 0
					&& secondVal % 2 != 0) {
				dashInsert.append(firstVal).append("-");
			} else {
				dashInsert.append(firstVal);
			}
		}
		return dashInsert.toString();
	}
	
	
	String PowersofTwo(int num) {
		if (num < 2)
			return "false";
		if (num == 2)
			return "true";
		for (int i = 2; i <= num; i++) {
			//int powerNum = (int)Math.pow(2, i);
			int powerNum = getPowersOf(2, i);
			if (powerNum == num)
				return "true";
			else if (powerNum >= num) {
				return "false";
			}

		}
		return "false";
	}

	int getPowersOf(int num, int n) {
		for (int i = 1; i <= n; i++) {
			if (i == 1)
				num = num * i;
			else
				num *= 2;
		}
		return num;
	}
	
	
	int MultiplicativePersistence(int num) { 
		  
	    // code goes here   
	    /* Note: In Java the return type of a function and the 
	       parameter types being passed are defined, so this return 
	       call must match the return type of the function.
	       You are free to modify the return type. */
		int count = 0;
		if(num<10) return count;
		while(num>0){
			num =splitMultiply(num);
			count++;
			if(num<10) return count;
		}
	       
	    return count;
	    
	  } 

	int splitMultiply(int num) {
		int mul = 1;
		while (num > 0) {
			int mulNum = num % 10;
			mul *= mulNum;
			num /= 10;
		}

		return mul;
	}
	
	int MeanMode(int[] arr) {

		// code goes here
		/*
		 * Note: In Java the return type of a function and the parameter types
		 * being passed are defined, so this return call must match the return
		 * type of the function. You are free to modify the return type.
		 */
		int meanCount = 0;
		int mode = 0;
		int count = 0;
		int prevCount = 0;
		for (int i = 0; i < arr.length; i++) {
			meanCount += arr[i];
			count=0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == arr[i]) {
					count++;
				}

				if (count > 1 && count > prevCount) {
					mode = arr[i];
				}
				prevCount = count;
			}
		}

		return meanCount / arr.length == mode ? 1 : 0;

	}
	
	String OffLineMinimum(String[] strArr) {
		/*
		 * I/P:5 4 6 E 1 7 E E 3 2
           O/P:4,1,5
		 * */
		List<String> numList = Arrays.asList(strArr);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<numList.size();i++){
			if(numList.get(i).equals("E")){
			int idx = getMinIndex(numList, i);
			sb.append(numList.get(idx)).append(',');
			numList.set(idx, "");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
	
	int getMinIndex(List<String> numList, int limit) {
		int min = 0;
		int idx = 0;
		for (String str : numList) {
			if (str.trim().length() > 0 && !str.trim().equals("E")) {
				try {
					min = Integer.parseInt(str);
					idx = numList.indexOf(str);
					break;
				} catch (NumberFormatException e) {
					continue;
				}
			}
		}

		for (int i = 0; i < limit; i++) {
			if (!numList.get(i).trim().equals("E")) {
				try {
					int num = Integer.parseInt(numList.get(i));
					if (num < min) {
						min = num;
						idx = i;
					}
				} catch (NumberFormatException ne) {
					continue;

				}
			}
		}
		return idx;

	}
	

	public static void main(String[] args) {
		// keep this function call here
		Scanner s = new Scanner(System.in);
		Function c = new Function();
		// System.out.print(c.FirstReverse(s.nextLine()));
		// System.out.print(c.FirstFactorial(new Integer(s.nextLine())));
		// System.out.print(c.Palindrome(s.nextLine()));
		// System.out.print(c.WordCount(s.nextLine()));
		
		  String[] strArr = s.nextLine().split(" "); int[] intArr = new
		  int[strArr.length]; 
		  for (int i = 0; i < strArr.length; i++) 
		  intArr[i] = Integer.parseInt(strArr[i]);
		  //new Integer(strArr[i]); }
		  System.out.println(c.SecondGreatLow(intArr)); 
		//System.out.print(c.SimpleSymbols(s.nextLine())); 
		//System.out.println(c.ExOh(s.nextLine()));
		// System.out.print(c.SwapCase(s.nextLine()));
		/*String[] charArr = s.nextLine().split(" ");
		int[] numArr = new int[charArr.length];
		for(int i =0;i<charArr.length;i++)
		{
			numArr[i] = Integer.parseInt(charArr[i]);
		}
		
		System.out.print(c.DivisionStringified(numArr[0],numArr[1]));*/ 
		//System.out.print(c.LetterChanges(s.nextLine())); 
		/*String[] charArr = s.nextLine().split(" ");
		int[] numArr = new int[charArr.length];
		for(int i =0;i<charArr.length;i++)
		{
			numArr[i] = Integer.parseInt(charArr[i]);
		}
		System.out.print(c.ArithGeo(numArr));*/ 
		//System.out.print(c.NumberAddition(s.nextLine()));
		//System.out.print(c.LetterCountI(s.nextLine())); 
		//System.out.print(c.CountingMinutesI(s.nextLine()));
		//System.out.print(c.DashInsert(s.nextLine()));
		//String str = s.nextLine().trim();
		//System.out.print(c.PowersofTwo(Integer.parseInt(String.valueOf(str)))); 
		//System.out.print(c.MultiplicativePersistence(Integer.parseInt(s.nextLine().trim())));
		/*String[] strArr = s.nextLine().trim().split("[\\s]+");
		int[] numArr = new int[strArr.length];
		for(int i =0;i<strArr.length;i++)
		{
			numArr[i] = Integer.parseInt(strArr[i]);
		}
		System.out.print(c.MeanMode(numArr));*/
		
		//String[] strArr = s.nextLine().trim().split("[\\s]+");
		//System.out.print(c.OffLineMinimum(strArr)); 
	}

}
