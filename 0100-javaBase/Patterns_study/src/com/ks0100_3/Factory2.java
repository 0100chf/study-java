package com.ks0100_3;

public class Factory2 extends Factory {

	// 有一天工厂类升级了新功能，那么可以重写原来的工厂方法
	protected Api createApi(int condition) {

		Api api = null;
		if (condition == 3) {
			api = new Impl3();
		} else {
			api = super.createApi(condition);
		}
		return api;
	}
}
