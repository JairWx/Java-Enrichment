package classloading;

import oj.MainClass;

public class ParentDelegation1 {
	
	public static void main(String [] args){
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		//sun.misc.Launcher$AppClassLoader@659e0bfd
		System.out.println(classLoader);
		try {
			Class<?> subClass = classLoader.loadClass("classloading.SubClass");
			System.out.println("加载的类名"+subClass.getName());
			//获取系统类加载器
			//findBootstrapClassOrNull(String name) 引导加载类
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
