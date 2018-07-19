package com.ks0100.exam.link;

/*
 * 双向链表
 */
public class TwoWayLink {

	public Node first; // 定义一个头结点
	public Node last; // 定义一个尾结点
	private int pos = 0;// 节点的位置

	// 插入一个头节点
	public void addFirstNode(Object data) {
		Node node = new Node(data);
		if (first == null) {
			last = node;
		}else{    
			node.next = first;    
            first.previous = node;    
        }
		first = node;
	}

	// 插入一个尾节点
	public void addLastNode(Object data) {
		Node node = new Node(data);
		if (first == null) {
			first = node;
		} else {
			last.next = node;  
			node.previous = last;  
		}
		last = node;
	}

	// 在任意索引位置插入节点
	public void add(int index, Object data) {
		
		// 如果索引等于0，往头插入。
		if (index == 0) {
			addFirstNode(data);
		}else if(index>0){
			Node current = findByPos(index);
			if(current==null){//参数索引太大
				return;
			}
			Node previous=current.previous;//有了previous，查找容易多了
			Node node = new Node(data);
			node.next = current;
			node.previous=previous;
			current.previous=node;
			previous.next = node;
			
		}
	}

	// 删除一个头节点,并返回被删除的节点
	public Node deleteFirstNode() {
		if (first != null) {
			Node tempNode = first;
			first = tempNode.next;
			if(first==null){
				last=null;
			}
			return tempNode;
		} else {
			return null;
		}
	}

	// 删除一个尾节点,并返回被删除的节点
	public Node deleteLastNode() {
		Node tempNode;
		if(last==first){// 只有一个节点删除头即可
			tempNode = deleteFirstNode();
			last = null;
		}else{
			tempNode = last;
			Node previous = last.previous;//有了previous，查找容易多了
			previous.next=null;
			last = previous;
		}
		return tempNode;
	}

	// 删除任意位置的节点
	public Node deleteByPos(int index) {
		
		if (index == 0) {
			return deleteFirstNode();
		}else if(index>0){
			// 根据位置找到节点和上一个节点，然后把上一个节点指向，删除节点的下一个
			Node node = findByPos(index);
			if(node==null){//参数索引太大
				return null;
			}
			Node previous = node.previous;
			previous.next = node.next;
			return node;
		}else{
			return null;
		}
		
	}

	// 根据节点找索引
	public int findLastIndex() {
		Node current = first;
		if (first != null) {
			pos = 0;
			while (current.next != null) {
				current=current.next;
				pos++;
			}
		} else {
			return -1;// 表示没有节点
		}

		return pos;
	}

	// 根据位置查找节点信息
	public Node findByPos(int index) {
		pos = 0;
		Node current = first;
		boolean exist=true;
		while (pos != index) {
			if (current == null) {
				exist=false;//参数索引大于实际的索引，所以找不到节点
				break;
			}
			current = current.next;
			pos++;
		}
		if(!exist){
			return null;
		}
		return current;
	}

	// 根据节点找索引
//	public int findNodeIndex(Node node) {
//		pos = 0;
//		Node current = first;
//		while (current != node) {
//			current = current.next;
//			pos++;
//		}
//		return pos;
//	}

	// 显示出所有的节点信息
	public void displayAllNodes() {
		System.out.print("打印链表:");
		Node current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TwoWayLink link = new TwoWayLink();
		link.addFirstNode(20);
		link.addFirstNode(21);
		link.addFirstNode(19);
		link.displayAllNodes();
		
		link.addLastNode(30);
		link.addLastNode(31);
		link.displayAllNodes();
		
		link.add(1, 22);
		link.add(2, 99);
		link.displayAllNodes();
		
		System.out.println("deleteFirstNode:"+link.deleteFirstNode().data);
		link.displayAllNodes();
		
		System.out.println("deleteLastNode:"+link.deleteLastNode().data);
		link.displayAllNodes();
		
		System.out.println("deleteByPos 2 node : " + link.deleteByPos(2).data);
		link.displayAllNodes();
	}


}
