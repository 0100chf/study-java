package com.ks0100_3;

//问题：编写Account类模拟银行储蓄账户。一个储蓄账户有账号、余额、年利息等属性，
//有存款、取款、查询方法。取款方法中，假设储蓄账户不允许透支。
public class Account {
	String id;
	double yuer;
	static double rate;		
	void save(double y){
		yuer+=y;			
	}	
	void qu_kuang(double y){
		if(yuer>=y){
			yuer-=y;
		}else
			System.out.println("账户余额不足，不允许透支");
	}	
	void search(){
		System.out.println("账户余额是:"+yuer);
	}
}

