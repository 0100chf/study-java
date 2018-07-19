package com.ks0100_3;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
	private String name;
	public Canvas(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void drawAll(List<Shape> list){
		for(Shape s:list){
			s.draw(this);
		}
	}
	

	
	//<?>可以接受任何类型的集合元素
	public void drawAll2(List<?> list){
		for(int i=0;i<list.size();i++){
			Object o=list.get(i);
			if(o instanceof Circle){
				Circle c=(Circle)o;
				c.draw(this);
			}else if(o instanceof Rectangle){
				Rectangle c=(Rectangle)o;
				c.draw(this);
			}else{
				Shape s=(Shape)o;
				s.draw(this);
			}
		}
	}
	
	public void drawAll3(List<? extends Shape> list){
		for(Shape s:list){
			s.draw(this);
		}
	}
	
	//画出Circle及其父类
	public void drawCircleList(List <? super Circle> list){
		for(int i=0;i<list.size();i++){
			Shape s=(Shape)list.get(i);//多态
			s.draw(this);
		}
	}
	
	public static void main(String[] args) {
		Canvas c=new Canvas("红布");
		List<Circle> circleList=new ArrayList<Circle>();
		circleList.add(new Circle());
		circleList.add(new Circle());
		//c.drawAll(circleList);//编译错误，List<Circle>可不是List<Shape>的子类
		List<Rectangle> rectangleList=new ArrayList<Rectangle>();
		rectangleList.add(new Rectangle());
		rectangleList.add(new Rectangle());
		System.out.println("用通配符解决问题，List<?> list----------");
		c.drawAll2(circleList);
		c.drawAll2(rectangleList);
		
		List<String> strList=new ArrayList<String>();
		strList.add("0100");
		//c.drawAll2(strList);//编译正确，运行时出现类型转换错误
		System.out.println("设定类型通配符的上限 ,List<? extends Shape> ------");
		c.drawAll3(circleList);
		c.drawAll3(rectangleList);
		//c.drawAll3(strList);//编译时就错误。所以设定参数通配符上限，就能避免运行时类型转换错误
		
		System.out.println("设定类型通配符的下限 ,List <? super Circle> list ------");
		c.drawCircleList(circleList);
		//c.drawCircleList(rectangleList);//编译错误
		//c.drawCircleList(strList);//编译错误
	}
}
