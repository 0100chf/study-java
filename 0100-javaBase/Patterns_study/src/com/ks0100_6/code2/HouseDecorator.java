package com.ks0100_6.code2;

/*

原体系：
House
	|--PingFang
	|--LouFang
无论将平房打造成田园还是欧式，都是对平房一种装修。
而该装修也可以用楼房。

将现将该装修定义好，需要把什么房子进行改装修，传入即可。
House
	|--PingFang
	|--LouFang
	|--TianYuan
	|--OuShi

*/

abstract class House2 {
	abstract void show();
}

class PingFang2 extends House2 {
	public void show() {
		System.out.println("平房");
	}
}

class LouFang2 extends House2 {
	public void show() {
		System.out.println("楼房");
	}
}

// 这里用了装饰者模式
class TianYuan2 extends House2 {

	private House2 h;

	TianYuan2(House2 h) {
		this.h = h;
	}

	public void show() {
		System.out.println("田园风格");
	}

	public void showTianYuan() {
		h.show();
		this.show();
	}

}

// 这里用了装饰者模式
class OuShi2 extends House2 {
	private House2 h;

	OuShi2(House2 h) {
		this.h = h;
	}

	public void show() {
		System.out.println("欧式风格");
	}

	public void showOuShi() {
		h.show();
		this.show();
	}

}

class HouseDecorator {
	public static void main(String[] args) {
		PingFang2 p = new PingFang2();

		OuShi2 o = new OuShi2(new TianYuan2(p));//装饰者模式的实例化方式
		o.showOuShi();
		System.out.println("----------");
		TianYuan2 t = new TianYuan2(new LouFang2());//装饰者模式的实例化方式
		t.showTianYuan();
		System.out.println("----------");
		OuShi2 o2 = new OuShi2(new LouFang2());//装饰者模式的实例化方式
		o2.showOuShi();
	}
}
