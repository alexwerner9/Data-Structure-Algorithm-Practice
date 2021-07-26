package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Solution {
    
	////////////////////
	
	/*
	 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

		Return the answer in an array.
	 */
	
	public int[] smallerNumbersThanCurrent(int[] nums) {
        
        Integer[] indices = new Integer[nums.length];
        int[] answer = new int[nums.length];
        int counter = 0;
        
        for(int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        
        Arrays.sort(indices, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return nums[i1] - nums[i2];
            }
        });
        
        for(int i = 0; i < nums.length; i++) {
            while(nums[indices[counter]] < nums[i]) {
                answer[i]++;
                counter++;
            }
            counter = 0;
        }
        
        return answer;
        
    }
	
	////////////////////
	
	/*
	 * Given an integer, convert it to a roman numeral.
	 */
	
	public String intToRoman(int num) {
        
        StringBuilder finalString = new StringBuilder();
        
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        while(num > 0) {
            for(int i = 0; i < roman.length; i++) {
                while(num - values[i] >= 0) {
                    finalString.append(roman[i]);
                    num -= values[i];
                }
            }
        }
        
        return finalString.toString();
        
    }
	
	////////////////////
	
	/*
	 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

		Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
	 */
	
	public int reverse(int x) {
        
        char[] xList = Integer.toString(x).toCharArray();
        
        int lP = 0;
        int rP = xList.length - 1;
        
        StringBuilder xString = new StringBuilder();
        
        if(xList[0] == '+' || xList[0] == '-') {
            xString.append(xList[0]);
            lP = 1;
        }
        
        while(rP >= lP) {
            xString.append(xList[rP]);
            rP--;
        }
        
        try {
            return Integer.parseInt(xString.toString());
        } catch(NumberFormatException e) {
            return 0;
        }
        
    }
	
	////////////////////
	
	/*
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

		P   A   H   N
		A P L S I I G
		Y   I   R
		And then read line by line: "PAHNAPLSIIGYIR"
		
	 */
	
	public String convert(String s, int numRows) {
        
        StringBuilder finalBuilder = new StringBuilder();
        ArrayList<StringBuilder> grid = new ArrayList<StringBuilder>();
        
        for(int i = 0; i < numRows; i++) {
            grid.add(new StringBuilder());
        }
        
        boolean ascending = true;
        int currRow = 0;
        
        for(int i = 0; i < s.length(); i++) {
            
            grid.get(currRow).append(s.charAt(i));
            
            if(numRows != 1) {
            
                if(currRow == numRows - 1) {
                    ascending = false;
                }
                if(currRow == 0) {
                    ascending = true;
                }

                if(ascending) {
                    currRow++;
                } else {
                    currRow--;
                }
                
            }
            
        }
        
        for(int i = 0; i < numRows; i++) {
            finalBuilder.append(grid.get(i).toString());
        }
        
        return finalBuilder.toString();
        
    }
	
	////////////////////
	
	/*
	
	////////////////////
	
	/*
	 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

		You may assume that each input would have exactly one solution, and you may not use the same element twice.

		You can return the answer in any order.
	 */
	
	public int[] twoSum(int[] nums, int target) {
        
        Integer[] indices = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, new Comparator<Integer>() {
            
            public int compare(Integer i1, Integer i2) {
                return nums[i1] - nums[i2];
            }
            
        });
        
        int lP = 0;
        int rP = nums.length - 1;
        
        while(rP > -1) {
            int result = nums[indices[rP]] +nums[indices[lP]];
            if(result > target) {
                rP--;
            }
            if(result < target) {
                lP++;
            }
            if(result == target) {
                int[] answer = {indices[lP], indices[rP]};
                return answer;
            }
        }
        
        return new int[0];
        
    }
	
	////////////////////
	
	/*
	 * Given a string s, return the longest palindromic substring in s.
	 */
	
	public String longestPalindrome(String s) {
        
        int lP = 0;
        int rP = 0;
        int len = 0;
        int start = 0;
        int end = 0;
        
        for(double i = 0; i < s.length(); i += 0.5) {
            
            if(Math.floor(i) != i) {
                lP = (int)Math.floor(i);
                rP = (int)Math.floor(i + 1);
            } else {
                lP = (int)i;
                rP = (int)i;
            }
            
            inner:
            while(lP >= 0 && rP < s.length() && s.charAt(lP) == s.charAt(rP)) {

                if(rP - lP > len) {
                    start = lP;
                    end = rP;
                    len = end - start;
                }
                
                lP--;
                rP++;
                
            }
            
        }
        
        return s.substring(start, end + 1);
    }
	
	////////////////////

	/*
	 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
	 * return the median of the two sorted arrays.
	 * 
	 * The overall run time complexity should be O(log (m+n)).
	 */
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        //Create new array to hold combined array
        //combinedLocale tracks previous point added
        int[] combinedArray = new int[nums1.length + nums2.length];
        int combinedLocale = 0;
        
        //p1 & p2 point to locations in nums1 and nums2 respectively
        int p1 = 0;
        int p2 = 0;
        
        double median;
        
        //Iterate through points
        while(p1 < nums1.length && p2 < nums2.length) {
            
            if(nums1[p1] < nums2[p2]) {
                combinedArray[combinedLocale++] = nums1[p1++];
            } else {
                combinedArray[combinedLocale++] = nums2[p2++];
            }
            
        }
        
        //Add remaining points to combined array
        while(p1 < nums1.length) {
            combinedArray[combinedLocale++] = nums1[p1++];
        }
        while(p2 < nums2.length) {
            combinedArray[combinedLocale++] = nums2[p2++];
        }
        
        //If even, find middle of 2 points, else just the middle point
        if(combinedArray.length % 2 == 0.0) {
            median = (combinedArray[combinedArray.length / 2] +
                      combinedArray[combinedArray.length / 2 - 1]) / 2.0; 
        } else {
            median = combinedArray[(int)Math.floor(combinedArray.length / 2.0)];
        }
        
        return median;
        
    }
	
	////////////////////
	
	/*
	 * A valid number can be split up into these components (in order):

			A decimal number or an integer.
			(Optional) An 'e' or 'E', followed by an integer.
		
		A decimal number can be split up into these components (in order):
		
			(Optional) A sign character (either '+' or '-').
			One of the following formats:
			One or more digits, followed by a dot '.'.
			One or more digits, followed by a dot '.', followed by one or more digits.
			A dot '.', followed by one or more digits.
		
		An integer can be split up into these components (in order):
		
			(Optional) A sign character (either '+' or '-').
			One or more digits.
		
		Given a string s, return true if s is a valid number.
	 */
	
    String validString;
    boolean eOkay;
    public boolean isNumber(String s) {
        
        eOkay = false;
        
        validString = "0123456789+-.Ee";
        
        return firstCheck(s);
        
    }  
    public boolean firstCheck(String s) {
        
        //Everything but E, e
        if(!validString.substring(0, 13).contains(Character.toString(s.charAt(0)))) {
            //System.out.println("invalid first char: " + s.charAt(0));
            return false;
        } else {
            //System.out.println("valid first char: " + s.charAt(0));
        }
        
        if(s.charAt(0) == '.' && s.length() > 0) {
            return isInteger(s.substring(1));
        }
        
        //0-9
        if(validString.substring(0, 10).contains(Character.toString(s.charAt(0)))) {
            eOkay = true;
        }
        
        for(int i = 1; i < s.length(); i++) {
            
            //0-9
            if(validString.substring(0, 10).contains(Character.toString(s.charAt(i)))) {
                eOkay = true;
            }
            
            //0-9, . , E, e
            if(!validString.substring(0, 10).contains(Character.toString(s.charAt(i))) &&
               !validString.substring(12).contains(Character.toString(s.charAt(i)))) {
                //System.out.println("doesn't contain character: " + s.charAt(i));
                return false;
            }
            
            //Call isInteger, return result (if false, whole thing is false)
            if(s.charAt(i) == '.') {
                //System.out.println("decimal, checking after");
                return isInteger(s.substring(i + 1));
            }
            
            if(s.charAt(i) == 'E' || s.charAt(i) == 'e') {
                return isEInteger(s.substring(i + 1));
            }
            
        }
        
        //System.out.println("first check only - true");
        return true;
        
    }
    public boolean isEInteger(String s) {
        
        if(!eOkay) {
            //System.out.println("not eOkay");
            return false;
        }
        
        if(s.length() == 0) {
            //System.out.println("length 0");
            return false;
        }
        
        //0-9, + , -
        if(!validString.substring(0, 12).contains(Character.toString(s.charAt(0)))) {
            //System.out.println("invalid first e character: " + s.charAt(0));
            return false;
        }
        
        if(validString.substring(10, 12).contains(Character.toString(s.charAt(0)))
        && s.length() == 1) {
            
            return false;
            
        }
        
        for(int i = 1; i < s.length(); i++) {
            
            //0-9
            if(!validString.substring(0, 10).contains(Character.toString(s.charAt(i)))) {
                //System.out.println("invalid e character: " + s.charAt(i));
                return false;
            }
        }
        
        return true;
        
    }
    public boolean isInteger(String s) {
        
        //System.out.println("checking after decimal");
        
        for(int i = 0  ; i < s.length(); i++) {
            
            if(validString.substring(0, 10).contains(Character.toString(s.charAt(i)))) {
                eOkay = true;
            }
            
            if(!validString.substring(0, 10).contains(Character.toString(s.charAt(i))) &&
               !validString.substring(13).contains(Character.toString(s.charAt(i)))) {
            
                //System.out.println("invalid character: " + s.charAt(i));
                
                return false;
            
            }
            
            if(s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                return isEInteger(s.substring(i + 1));
            }
            
        }
        
        if(!eOkay) {
            return false;
        }
        
        return true;
        
    }
    
    ///////////////////
    
    /*
     * Given a string containing just the characters '(' and ')',
     * find the length of the longest valid (well-formed) 
     * parentheses substring.
     */
    
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        
        Stack<Integer> queue = new Stack<Integer>();
        queue.push(-1);
        
        for(int i = 0; i < s.length(); i++) {
            
            if(Character.toString(s.charAt(i)).equals("(")) {
                queue.push(i);
            }
            
            if(Character.toString(s.charAt(i)).equals(")")) {
                
                queue.pop();
                if(queue.empty()) {
                    queue.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - queue.peek());
                }
                
            }
            
        }
        
        return maxLength;
    }
    
    ///////////////////
    
    
    
}