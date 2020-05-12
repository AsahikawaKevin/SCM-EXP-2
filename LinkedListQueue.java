package list;




public class LinkedListQueue<E>implements Queue<E> {
	private class Node{
		public E e;
		public Node next;
		
		public Node(E e,Node next){
			this.e=e;
			this.next=next;
		}
		
		public Node(E e){
			this.e=e;
			this.next=null;
		}
		@SuppressWarnings("unused")
		public Node(){
			this(null,null);
		}
		
		@Override
		public String toString(){
			return e.toString();
		}
	}
	private Node head,tail;
	private int size;
	public LinkedListQueue(){
		head=null;
		tail=null;
		size=0;
	}
	public int getSize(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public void enqueue(E e){
		if(tail==null){
			tail=new Node(e);
			head=tail;
		}else{
			tail.next=new Node(e);
			tail=tail.next;
		}
		size++;
	}
	public E dequeue(){
		if(isEmpty()){
				throw new IllegalArgumentException("List is Empty");
		}
		Node temp=head;
		head=head.next;
		temp.next=null;
		if(head==null){
			tail=null;
		}
		size--;
		return temp.e;
	}
	public E getFront(){
		if(isEmpty()){
			throw new IllegalArgumentException("List is Empty");
		}
		return head.e;
	}
	public String toString(){
		StringBuilder res= new StringBuilder();
		Node cur=head.next;
		res.append("Queue: Front");
		while(cur!=null){
			res.append((cur+"->"));
			cur=cur.next;
		}
		res.append("NULL  tail");
		return res.toString();
	}
	
	public static void main(String[ ] args)
	{
		LinkedListQueue<Integer> queue=new LinkedListQueue<Integer>();
		for(int i=0;i<10;i++)
		{
			queue.enqueue(i);
			System.out.println(queue);
			if(i%3==2){
				queue.dequeue();
				System.out.println(queue);
			}
		}
	}
}
