package com.ks0100_1;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue p=new PriorityQueue();
		p.offer(10);//将指定的元素插入此队列（如果立即可行且不会违反容量限制），当使用有容量限制的队列时，此方法通常要优于 add(E)，后者可能无法插入元素，而只是抛出一个异常。 
		p.offer(2);
		p.offer(4);
		p.offer(1);
		p.offer(4);
		p.offer(-8);
		System.out.println("p:"+p);//toString()方法看不到元素实际的顺序
//		Iterator it=p.iterator();
//		while(it.hasNext()){
//			System.out.print(" "+it.next());
//		}
		System.out.print("用 poll 来显示该队列的元素顺序:");
		while(!p.isEmpty()){
			System.out.print(" "+p.poll());//poll是排队投票的意思，投了一票，这个人就出队列了
		}
		System.out.println();
		System.out.println("poll 完 p:"+p);
		p.offer(10);
		p.offer(2);
		p.offer(4);
		p.offer(1);
		p.offer(4);
		p.offer(-8);
		System.out.println("peek:"+p.peek());//peek是偷看的意思，只能看到排在队伍第一个的
		System.out.println("p:"+p);
	}

}
