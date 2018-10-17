package oj.search;

import java.awt.datatransfer.StringSelection;

public class BinarySearchClass {
	public static int BinarySearch(int[] list,int item){
		int lowIndex = 0;
		int highIndex = list.length -1;
		while (lowIndex  <= highIndex) {
			int midIndex = (lowIndex + highIndex) / 2;
			if(list[midIndex] == item){
				return midIndex;
			}
			
			if(list[midIndex] > item){
				highIndex = midIndex -1;
			}else{
				lowIndex = midIndex +1;
			}
		}
		return -1;
	}
	
	public static void main(String [] args){
		int[] params = new int[]{-1,0,3,5,9,12};
		int result = BinarySearch(params,13);
		System.out.println(result);
	}
	
}
