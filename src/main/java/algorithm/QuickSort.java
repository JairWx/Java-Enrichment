package algorithm;

import java.awt.datatransfer.StringSelection;
import java.beans.beancontext.BeanContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
	public static void main(String [] args){
		int[] test = {4,6,3};
	test = sort(test);
	for (int i : test) {
		System.out.println(i);
	}
	}
	public static int[] sort(int[] params){
		
		if(params.length < 2){
			return params;
		}
		int[] left = new int[params.length];
		int leftIndex = 0;
		int[] right = new int[params.length];
		int rightIndex = 0;
		int mark = params[params.length/2];
		for(int i = 0;i<params.length;i++ ){
			if(i == params.length/2){
				continue;
			}
			if(mark > params[i]){
				left[leftIndex] = params[i];
				leftIndex++;
			}else{
				right[rightIndex] = params[i];
				rightIndex++;
			}
		}
		int[] result =  new int[leftIndex+1+rightIndex];
		result[leftIndex] = mark;
		if(leftIndex != 0){
			left = Arrays.copyOfRange(left, 0, leftIndex);
			left = sort(left);
			System.arraycopy(left,0,result,0,leftIndex);
		}
		if(rightIndex != 0){
			right = Arrays.copyOfRange(right, 0, rightIndex);
			right = sort(right);
			System.arraycopy(right,0,result,leftIndex+1,rightIndex);
		}
		return result;
	}
}
