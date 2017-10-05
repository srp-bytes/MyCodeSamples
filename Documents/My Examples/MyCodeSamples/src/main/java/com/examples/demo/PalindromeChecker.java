package com.examples.demo;

/**
 * cerner_2^5_2017
 */
public class PalindromeChecker {
	
	/**
	 * cerner_2^5_2017
	 * Case sensitive Palindrome checker
	 * @param s - String
	 * @return boolean - true if String is palindrome
	 */
	public static boolean isPalindrome(String s){
		if(s==null||s.length()==0)
			return false;
		int left = 0, right = s.length()-1;
		while(left<right){
			if(s.charAt(left)!=s.charAt(right))
				return false;
			left++;right--;
		}
		return false;
	}

}
