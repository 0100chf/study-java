package com.ks0100.exam.link;

/**
 * 单向链表
 * 
 * @author chen haifeng
 *
 */
public class OneWayLink {
	public Node first; // 定义一个头结点
	private int pos = 0;// 节点的位置

	public OneWayLink() {
		this.first = null;
	}

	// 插入一个头节点
	public void addFirstNode(Object data) {
		Node node = new Node(data);
		node.next = first;// 把原来头节点放到新插入节点后面
		first = node;// 头节点指向插入的
	}

	// 删除一个头节点,并返回被删除的节点
	public Node deleteFirstNode() {
		Node tempNode = first;
		first = tempNode.next;
		return tempNode;
	}

	// 在任意索引位置插入节点
	public void add(int index, Object data) {

		// 如果索引等于0，往头插入。
		if (index == 0) {
			addFirstNode(data);
		} else {
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

	// 删除任意位置的节点
	public Node deleteByPos(int index) {
		if (index == 0) {
			return deleteFirstNode();
		} else {
			// 根据位置找到节点和上一个节点，然后把上一个节点指向，删除节点的下一个
			Node node = findByPos(index);
			Node previous = findByPos(index - 1);
			previous.next = node.next;
			return node;
		}
	}

	// 根据节点的data删除节点(仅仅删除第一个)
	public Node deleteByData(Object data) {

		Node node = findByData(data);//根据数据找节点
		if (node != null) {
			int index = findNodeIndex(node);//找到节点的index
			if (index == 0) {
				deleteFirstNode();
			} else {
				Node previous = findByPos(index - 1);//没有previous很痛苦，要通过索引再找到上一个节点
				previous.next = node.next;
			}
		}

		return node;
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

	//根据节点找索引
	public int findNodeIndex(Node node) {
		pos = 0;
		Node current = first;
		while (current != node) {
			current = current.next;
			pos++;
		}
		return pos;
	}


	// 根据数据查找节点信息
	public Node findByData(Object data) {
		Node current = first;
		while (current.data != data) {
			if (current.next == null)
				break;
			current = current.next;
		}
		return current;
	}

	public static void main(String[] args) {
		OneWayLink link = new OneWayLink();
		link.addFirstNode(20);
		link.addFirstNode(21);
		link.addFirstNode(19);
		link.displayAllNodes();
		
		// add后，索引后面的节点往后移动？其实不会移动。
		link.add(1, 22); // 19,22,21,20
		link.add(2, 23); // 19,22,23,21,20
		link.add(3, 99); // 19,22,23,99,21,20
		link.displayAllNodes();

		Node node = link.deleteFirstNode();
		System.out.println("deleteFirstNode node : " + node.data);
		link.displayAllNodes();

		node = link.deleteByPos(3);
		System.out.println("deleteByPos 3 node : " + node.data);
		link.displayAllNodes();

		node = link.deleteByData(20);
		System.out.println("deleteByData node : " + node.data);
		link.displayAllNodes();

		System.out.println("node1: " + link.findByPos(1).data);
		System.out.println("node2: " + link.findByData(22).data);
	}
}
