package com.ks0100_5.code2;

/*
 * 定义一个做菜的模板类
 */
public abstract class Template {
	
	/*
	 * 模板方法，定义算法骨架
	 */
	public final void templateMethod(){
		this.clean();
		this.cut();
		this.cook();
	}
	

	//洗菜
	protected abstract void clean();
	//切菜
	protected abstract void cut();
	
	//烹饪
	protected abstract void cook();
	
}
