package oj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 反转整数
 * @author wenjie
 *
 */
public class ReverseInteger {
	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            
            int ret = new Solution2().reverse(x);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
/**
 * 解决思路一
 * 简单的循环遍历
 * @author wenjie
 *
 */
class Solution {
    public int reverse(int x) {
    	String str = String.valueOf(x);
    	char[] charArray = str.toCharArray();
    	//之前理解的整数溢出是数字位，傻逼了
//    	if((charArray.length > 33 && charArray[1] == '-') || (charArray.length > 32 && charArray[1] != '-') || x == 0){
//    		return 0;
//    	}
    	if(x == 0){
    		return 0;
    	}
    	//结果
    	char[] result = new char[33];
    	int index = 0;//因为结果集索引号与取的索引号不一致
    	boolean flag = false;;//判断从开始到结束没有碰到
    	for(int i = charArray.length - 1 ;i >= 0 ; i--) {
    		if(charArray[0] == '-' && index == 0){
    			result[0] = '-';
    			index ++;
    		}else if(charArray[0] == '-' && i == 0){
    			continue;
    		}
    		if(flag == true){
    			result[index] = charArray[i];
    			index ++;
    		}else if(charArray[i] != '0' ){
    			result[index] = charArray[i];
    			index ++;
    			flag = true;
    		}
    	}
    	//需要截取处理
    	char[] result2 = new char[index];
    	System.arraycopy(result, 0, result2, 0, index);
    	//oj没有bigInteger
    	//BigInteger b = new BigInteger(String.valueOf(result2));
    	//if(b.compareTo(new BigInteger(String.valueOf((Integer.MAX_VALUE)))) == 1 || b.compareTo(new BigInteger(String.valueOf((Integer.MIN_VALUE)))) == -1){
    		//return 0;
    	//}
    	//
    	//判断整数溢出 很拙劣的方法
    	try{
    		x = Integer.valueOf(String.valueOf(result2));
    	}catch(Exception e){
    		return 0;
    	}
    	
		return x;
    }
}

/**
 * 对数的操作其实就是对数字位的操作
 * 因为涉及到边界问题，所以只能用long做对比了
 * @author wenjie
 *
 */
class Solution2 {
    public int reverse(int x) {
    	long result = 0 ;
    	while(x != 0) {
    		//判断边界
    		result  = 10 * result +  x % 10;
    		x /= 10;
    		
    	}
    	if(result > Integer.MAX_VALUE){
    		result = 0;
		}
    	if(result < Integer.MIN_VALUE){
    		result = 0;
		}
    	return Integer.valueOf(String.valueOf(result));
    }
}
