package com.ks0100_5.code2;

//炒青菜的做法
public class SubClass2 extends Template {

	@Override
	protected void clean() {
		System.out.println("把每片青菜叶子洗干净");
	}

	@Override
	protected void cut() {
		System.out.println("把菜根切掉");
		System.out.println("剥大蒜");
		System.out.println("拍大蒜");
	}

	@Override
	protected void cook() {
		System.out.println("菜油热锅");
		System.out.println("煎大蒜");
		System.out.println("青菜下锅");
		System.out.println("炒青菜");
		System.out.println("煮几分钟");
		System.out.println("起锅，放调料");
	}

}
