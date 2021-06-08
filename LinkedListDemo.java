package dsademo;

public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList<Integer> numberList = new LinkedList<>();
		numberList.delete(10);
		numberList.update(11, 12);
		System.out.println("Size: " + numberList.getCount());
		numberList.push(1);
		System.out.println("Size: " + numberList.getCount());
		numberList.pop();
		numberList.push(2);
		numberList.insert(1, 11);
		numberList.push(3);
		numberList.push(4);
		numberList.push(5);
		numberList.push(6);
		numberList.show();
		numberList.reverse();
		System.out.println("Size: " + numberList.getCount());
		
		numberList.delete(10);
		numberList.delete(5);
		System.out.println("Size: " + numberList.getCount());
		numberList.update(4, 10);
		numberList.update(11, 12);
		System.out.println("Size: " + numberList.getCount());

	}
}

class LinkedList<T> {
	Node<T> head;
	int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	/*
	 * Add element at the end of the linked list
	 */
	public Node<T> push(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(newNode);
		}
		count++;
		System.out.println("data Added successfully" + newNode);
		return newNode;
	}
	
	/*
	 * delete the specified element from the list
	 */
	public void delete(T data) {
		if (head == null) {
			System.out.println("Linked list is empty");
			return;
		}

		if (data.equals(head.getData())) {
			head = head.getNext();
		} else {
			Node<T> currentNode = head.getNext();
			Node<T> prevNode = head;
			while (currentNode != null) {
				if (data.equals(currentNode.getData())) {
					prevNode.setNext(currentNode.getNext());
					System.out.println("data deleted successfully:" + data);
					count--;
					break;
				}
				prevNode = currentNode;
				currentNode = currentNode.getNext();
			}
			if (currentNode == null) {
				System.out.println("data not found:" + data);
			}
		}
	}
	
	/*
	 * update the data in the list
	 */
	public void update(T data, T updatedData) {
		if (head == null) {
			System.out.println("Linked list is empty");
			return;
		}

		if (data.equals(head.getData())) {
			head = head.getNext();
		} else {
			Node<T> currentNode = head.getNext();
			while (currentNode != null) {
				if (data.equals(currentNode.getData())) {
					currentNode.setData(updatedData);
					System.out.println("data updated successfully:" + data);
					break;
				}
				currentNode = currentNode.getNext();
			}
			if (currentNode == null) {
				System.out.println("data not found:" + data);
			}
		}
	}
	/*
	 * show all the elements according to the insertion order
	 */
	public void show() {
		System.out.println("Showing all the elements: ");
		Node<T> currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNext();
		}
	}
	
	/*
	 * reverse the linked list
	 */
	public void reverse() {
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}
		Node<T> currentNode = head;
		Node<T> prevNode = null;
		Node<T> nextNode = null;
		while (currentNode != null) {
			nextNode = currentNode.getNext();
			currentNode.setNext(prevNode);
			prevNode = currentNode;
			currentNode = nextNode;
		}
		head = prevNode;
		System.out.println("Showing elements in reverse order:");
		show();
	}
	/*
	 * remove and return first element in the list
	 */
	public T pop() {
		if(head == null) {
			System.out.println("List is empty.");
			return null;
		}else {
			System.out.println("The popped element is :"+head.getData());
			T data = head.getData();
			head = head.getNext();
			return data;
		}
	}
	
	/*
	 * Insert at particular position in the list
	 */
	public void insert(int position,T data) {
		Node<T> newNode;
		if(position > count+1) {
			System.out.println("Not enough element present in the list.");
		}else if(position ==1) {
			newNode = new Node<T>(data);
			newNode.setNext(head);
			head = newNode;
		}else {
			Node<T> currentNode = head;
			int currentPosition = 1;
			while (currentPosition < position-1) {
				currentNode = currentNode.getNext();
				currentPosition++;
			}
			newNode = new Node<T>(data);
			newNode.setNext(currentNode.getNext());
			currentNode.setNext(newNode);
		}
	}
	
	/*
	 * delete all the elements in the list
	 */
	public boolean deleteAll() {
		if(head == null) {
			System.out.println("list is already empty.");
		}else {
			head = null;
		}
		return true;
	}

}

class Node<T> {
	private T data;
	private Node<T> next;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node(T data) {
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

	public Node() {
	}
}
