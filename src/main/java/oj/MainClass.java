package oj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            
            int ret = new Solution3().removeDuplicates(nums);
            String out = integerArrayToString(nums, ret);
            
            System.out.print(out);
        }
    }
}
class Solution3 {
    public int removeDuplicates(int[] nums) {
    	int length = nums.length;
    	if(nums.length > 1) {
    		 int index = nums[0];
             
             for(int i = 1 ;i < length;){
                 if(index == nums[i]){
                     System.arraycopy(nums, i+1, nums, i, length-i-1);
                         length--;
                 }else{
                     index = nums[i];
                     i++; 
                 }
             }
        }
    	return length;
    }
}


