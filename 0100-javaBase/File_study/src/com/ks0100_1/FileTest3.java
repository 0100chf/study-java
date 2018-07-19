package com.ks0100_1;

import java.io.File;
import java.io.IOException;

/*
 * 删除功能:public boolean delete()
 * 
 * 注意：
 * 		A:如果你创建文件或者文件夹忘了写盘符路径，那么，默认在项目路径下。
 * 		B:Java中的删除不走回收站。
 * 		C:要删除一个文件夹，请注意该文件夹内不能包含文件或者文件夹
 */
public class FileTest3 {

	public static void main(String[] args) throws IOException{
		/*
		 * create 分别用eclipse执行和命令行编译执行
		 * 1.eclipse执行可以改变一下class output folder，说明和classpath无关。
		 * 2.用命令行编译执行，
		 *   编译: javac -d . -encoding utf-8 FileTest3.java
		 *   执行如果在 FileTest3.java 同级文件目录下：java com.ks0100_1.FileTest3
		 *   如果在其他路径下需要设置classpath，set classpath=路径
		 *   然后切换到任意路径执行 java com.ks0100_1.FileTest3  
		 *   可以看到文件夹都是在“当前路径”下建立的
		 */
		//create 分别用eclipse执行和命令行编译执行
		//改变一下eclipse class output folder试一试看 
		
		//create() 和delete()分别执行
		//create();
		//delete();
		create2();
		
	}
	
	public static void create() throws IOException{
		// 我不小心写成这个样子了
		File file = new File("a.txt");
		System.out.println("createNewFile:" + file.createNewFile());

		// 继续玩几个
		File file2 = new File("aaa\\bbb\\ccc");
		System.out.println("mkdirs:" + file2.mkdirs());
		System.out.println("其实上面的操作都是在当前目录下建立文件和文件夹");
		//eclipse里的“当前目录”就是项目所在的目录，比如这个IO_study项目，所在的目录就是 通过properties-->Resource-->Location 查看到
		//如果我们通过cmd下进入FileTest3.java 所在路径，编译，执行，那么当前路径就是FileTest3.java 所在路径
		File current=new File(".");
		System.out.println(current.getAbsolutePath());//文件的绝对路径
	}
	
	//删除文件的方法很“安全”，找不到文件返回false，不执行删除即可。如果执行删除了返回false。
	public static void delete(){
		// 删除功能：我要删除a.txt这个文件
		File file3 = new File("a.txt");
		System.out.println("delete:" + file3.delete());

//		// 删除功能：我要删除ccc这个文件夹
		File file4 = new File("aaa\\bbb\\ccc");
		System.out.println("delete:" + file4.delete());

//		// 删除功能：我要删除aaa文件夹
		 File file5 = new File("aaa");
		 System.out.println("delete:" + file5.delete());

		File file6 = new File("aaa\\bbb");
		File file7 = new File("aaa");
		System.out.println("delete:" + file6.delete());
		System.out.println("delete:" + file7.delete());
	}
	
	// 两个反斜线\\等于一个斜线/
	public static void create2(){
		File file = new File("111/222/333");
		System.out.println("mkdirs:" + file.mkdirs());
		File file2 = new File("/dd");
		System.out.println("mkdirs:" + file2.mkdirs());
		File file3 = new File("./dd");
		System.out.println("mkdirs:" + file3.mkdirs());
		File file4 = new File(".\\ee");
		System.out.println("mkdirs:" + file4.mkdirs());
	}

}
