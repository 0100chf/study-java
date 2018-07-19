package com.ks0100_4;

/*
 * 测试StringBuilder和StringBuffer
 * 
 * 如果程序退出则表示线程不安全。
 */
public class StringThread {

	// 待测试sb对象，分别打开这两行代码的注释
	private static StringBuilder sb = new StringBuilder();
//	 private static StringBuffer sb = new StringBuffer();

	// 运行条件
	public boolean condition = true;// 控制循环的条件，只有错误了，才会false，程序停止

	
	public static void main(String[] args) throws Exception {
		StringThread demo = new StringThread();
		demo.test();
	}

	/**
	 * 主要的测试方法
	 * 
	 * @throws InterruptedException
	 */
	public void test() throws InterruptedException {
		// 写入内容
		String infos[] = { "0000000000000000", "1111111111111111", "2222222222222222", "3333333333333333" };

		Thread t1[] = new Thread[4];
		// 启动4个线程，每个线程分别去 sb.replace 数组的对应元素
		//比如第1个线程的sb对象不停的去replace 0000000000000000，第二个线程的sb对象不停的去replace 1111111111111111，以此类推
		//假如replace的字符串中的字符不一致，就会出现线程安全的问题
		for (int i = 0; i < t1.length; i++) {
			t1[i] = new Thread(new DemoWrite(infos[i]));
			t1[i].start();
		}

		//启动一个线程，不停的去检查sb.replace 是不是正确。
		Thread checkThread = new Thread(new DemoRead("checkThread"));
		checkThread.start();

	}

	/**
	 * StringBuilder写类,负责替换StringBuilder内容
	 * 
	 */
	class DemoWrite implements Runnable {

		// 写入信息
		private String str;

		/*
		 * 构造方法，传人要replace的字符串。
		 */
		public DemoWrite(String str) {
			this.str = str;
		}

		/*
		 * 这个方法在线程启动后自动调用，会不停的去sb.replace
		 */
		@Override
		public void run() {
			while (condition) {
				sb.replace(0, 16, str); // 验证replace方法是否线程安全
			}
		}

	}

	/**
	 * 读类,读取StringBuilder内容并校验
	 * 
	 * @author Administrator
	 *
	 */
	class DemoRead implements Runnable {
		// 校验写入信息
		private String infos[] = { "0000000000000000", "1111111111111111", "2222222222222222", "3333333333333333" };

		private String threadName;// 线程名字

		public DemoRead(String threadName) {
			this.threadName = threadName;
		}

		@Override
		public void run() {

			String currentSb;
			// 循环读取并校验
			while (condition) {
				// 获取当前值
				currentSb = sb.toString();
				System.out.println(threadName + "；现在校验的字符串是:" + currentSb);
				boolean safe = false;// 先假设线程不安全的

				// 循环校验
				for (String s : infos) {
					/*
					 * 只要 replace后 currentSb 的数据等于
					 * 数组里面规定的这4组字符串中的一个，就说明线程安全，否则是不安全的。
					 */
					if (s.equals(currentSb)) {
						safe = true;
						break;
					}
				}

				/* 非线程安全
				 * 出现字符不一致的原因是前一个线程没有replace完毕，后一个线程接着replace，结果造成replace出脏数据的情况
				 * 如果线程安全的，会在方法上加一个关键字synchronized，以后会学。我们看replace()方法
				 * 这个关键字，好像一把锁一样。
				 * 前面的线程执行replace()方法时，锁起来，不让后面的线程来执行replace()方法，
				 * 直到前面的线程执行完replace()方法后，后面的线程才执行replace()方法。
				 */
				if (!safe) {
					System.err.println("StringBuilder1 是非线程安全的，replace 错误的字符串是: " + currentSb);
					condition = false;// 退出循环
				}

			}
		}

	}

}
