package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 集合依赖与rt.jar包
 * @author wenjie
 *
 */
public class Collection1 {
	
	public static List<String> arraylist = new ArrayList<String>();
	public static Map<String,String> map = new HashMap<String,String>();
	static{
		arraylist.add("111");
		arraylist.add("222");
		arraylist.add("133311");
		arraylist.add("444");
		
		map.put("sssss", "ssss");
		map.put("112121", "222");
		map.put("s1212ssss", "222");
	}
	public static void main(String[] args) {
		mapTraversal();
	}
	
	/**
	 * 常用的List遍历
	 */
	public static void listTraversal() {
		Iterator iterator = arraylist.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());;
		}
		ListIterator iterator2 = arraylist.listIterator();
		iterator2.add("sss");
		iterator2.previous();
		iterator2.set("ddd");
		while(iterator2.hasNext()) {
			System.out.println(iterator2.next());;
		}
	}
	
	/**
	 * 常用的Map遍历
	 * 列举常用的遍历方法
	 */
	public static void mapTraversal() {
		//通过Iterator 将map转变为由key组成的set,然后用list遍历的第一种方法进行遍历
		System.out.println("=====第一种方法=======");
		Iterator iterator = map.keySet().iterator();
		while(iterator.hasNext()){
			String key = (String) iterator.next();
			System.out.println("key="+key);
			System.out.println("value="+map.get(key));
		}
		//通过entrySet() 将key-value作为整体 Entry存放到set集合中Map.Entry 表示映射关系
		System.out.println("=====第二种方法=======");
		Iterator iterator2 = map.entrySet().iterator();
		while(iterator2.hasNext()){
			Entry e = (Entry) iterator2.next();
			System.out.println("key="+e.getKey());
			System.out.println("value="+e.getValue());
		}
	}
}
