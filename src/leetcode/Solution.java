package leetcode;

import java.util.Stack;

class Solution {
    
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