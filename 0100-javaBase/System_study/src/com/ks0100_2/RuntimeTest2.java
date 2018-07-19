package com.ks0100_2;

public class RuntimeTest2 {

	public static void main(String[] args)throws Exception {
		Runtime rt=Runtime.getRuntime();
		rt.exec("notepad.exe");//运行记事本程序
		rt.exec("calc.exe");//运行计算器程序
		
		//RuntimeTest3 有更好玩的，可以写java程序去编译另外的java程序。
	}

}
