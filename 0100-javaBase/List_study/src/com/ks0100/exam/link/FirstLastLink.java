package com.ks0100.exam.link;

/*
 * 双端链表
 */
public class FirstLastLink {
	public Node first; // 定义一个头结点
	public Node last; // 定义一个尾结点
	private int pos = 0;// 节点的位置

	// 插入一个头节点
	public void addFirstNode(Object data) {
		Node node = new Node(data);
		node.next = first;// 把原来头节点放到新插入节点后面
		if (first == null) {
			last = node;
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
		}
		last = node;
	}

	// 在任意索引位置插入节点
	public void add(int index, Object data) {
		int lastIndex = findLastIndex();
		// 如果索引等于0，往头插入。
		if (index == 0) {
			addFirstNode(data);
		} else if (index == lastIndex) {
			addLastNode(data);
		} else if (index > 0 && index < lastIndex) {
			// 根据索引分别找到，相邻的前后节点，然后插入。
			// 找到的动作是从头开始，效率低。影响插入效率。所以链表插入的效率瓶颈在于如何访问到节点。
			Node current = findByPos(index);
			Node previous = findByPos(index - 1);
			Node node = new Node(data);
			node.next = current;
			previous.next = node;
			pos = 0;
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
		int lastIndex = findLastIndex();
		Node tempNode;
		if (lastIndex == 0) {// 只有一个节点删除头即可
			tempNode = deleteFirstNode();
			last = null;
		} else {
			tempNode = last;
			Node previous = findByPos(lastIndex - 1);
			previous.next = null;
			last = previous;
		}
		return tempNode;
	}

	// 删除任意位置的节点
	public Node deleteByPos(int index) {
		int lastIndex = findLastIndex();
		if (index == 0) {
			return deleteFirstNode();
		} else if (index == lastIndex) {
			return deleteLastNode();
		} else if (index > 0 && index < lastIndex) {
			// 根据位置找到节点和上一个节点，然后把上一个节点指向，删除节点的下一个
			Node node = findByPos(index);
			Node previous = findByPos(index - 1);
			previous.next = node.next;
			return node;
		} else {
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
		while (pos != index) {
			if (current == null) {
				break;
			}
			current = current.next;
			pos++;
		}
		return current;
	}

	// 根据节点找索引
	public int findNodeIndex(Node node) {
		pos = 0;
		Node current = first;
		while (current != node) {
			current = current.next;
			pos++;
		}
		return pos;
	}

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
		FirstLastLink link = new FirstLastLink();
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
		
		System.out.println("deleteByPos 3 node : " + link.deleteByPos(3).data);
		link.displayAllNodes();
		
		FirstLastLink link2 = new FirstLastLink();
		link2.addFirstNode(20);
		System.out.println("deleteFirstNode:"+link2.deleteFirstNode().data);
		link2.displayAllNodes();
	}

}
