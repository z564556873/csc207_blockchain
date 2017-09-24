
public class BlockChain {
	Node first;
	Node last;
	class Node{
		Block data;
		Node next;
		
		Node(Block data){
			this.data = data;
			this.next = null;
		}
	}
	public BlockChain(int initial){
		Block start = new Block(0, initial,null);
		this.first=new Node(start);
		this.last=this.first;
	}
	public Block mine(int amount){
		return new Block(this.last.data.num+1, amount,this.last.data.curHash);
	}
	public int getSize(){
		return this.last.data.num + 1;
	}
	public void append(Block blk){
		if (blk.preHash!=this.last.data.curHash){
			throw new IllegalArgumentException("invalid block");
		}else{
		Node added = new Node(blk);
		this.last.next=added;
		this.last = added;
		}
	}
	public boolean removeLast(){
		if (first == last){
			return false;
		}else{
			Node temp = this.first;
			while (temp.next!=this.last){
				temp = temp.next;
			}
			temp.next = null;
			this.last=temp;
			return true;
		}
	}
	public Hash getHash(){
		return this.last.data.curHash;
	}
	public boolean isValidBlockChain(){
		Node temp = this.first;
		while(first.next!=null){
			
		}
	}
}
