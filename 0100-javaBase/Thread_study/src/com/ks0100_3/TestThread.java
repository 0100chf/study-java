package com.ks0100_3;

import java.io.IOException;

public class TestThread {
	public static void main(String[] args){
		if(args.length<1){
			//要求用户输入一个命令行，否则程序停止
			System.out.println("请输入一个命令行参数");
			System.exit(0);
		}
		PrimeThread getPrimes=new PrimeThread(Integer.parseInt(args[0]));
		getPrimes.start();
		while(getPrimes.isAlive()&&getPrimes.readyToGoOn()){
			System.out.println(" Counting the prime number ...\n");
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				return;
			}
		}
		System.out.println(" 按任意键继续。。。");
		try{
			System.in.read();
		}catch(IOException e){
			
		}
	}
}

class PrimeThread extends Thread{
	boolean m_bContinue=true;//标志本线程是否继续
	int m_nCircleNum;//循环的上限
	PrimeThread(int num){
		m_nCircleNum=num;
	}
	boolean readyToGoOn(){//判断本线程是否继续执行
		return m_bContinue;
	}
	
	public void run(){
		//继承并重载父类Thread的run()方法，在该线程被启动时自动执行
		int number=3;
		boolean flag=true;
		while(true){
			for(int i=2;i<number;i++){
				if(number %i==0)
					flag=false;
			}
			
			if(flag)
				System.out.println(number+"是素数");
			else
				System.out.println(number+"不是素数");
			number++;//修改number的数值，为下一轮素数检查做准备
			if(number >m_nCircleNum){
				m_bContinue=false;  //到达要求检查数值的上限，则准备结束此线程，
				return;//结束run()方法，结束线程
			}
			flag=true;
			
			try{
				sleep(500);//一轮检查之后，暂时休眠500毫秒
			}catch(InterruptedException e){
				return;
			}
		}
	}
	
}
