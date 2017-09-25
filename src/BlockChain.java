import java.security.NoSuchAlgorithmException;

public class BlockChain {
	Node first;
	Node last;
	class Node{
		Block data;
		Node next;

		Node(Block data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	public BlockChain(int initial) throws NoSuchAlgorithmException {
		Block start = new Block(0, initial,null);
		this.first=new Node(start, null);
		this.last=this.first;
	}
	public Block mine(int amount) throws NoSuchAlgorithmException{
		return new Block(this.last.data.num+1, amount,this.last.data.curHash);
	}
	public int getSize(){
		return this.last.data.num + 1;
	}
	public void append(Block blk){
		if (blk.preHash!=this.last.data.curHash){
			throw new IllegalArgumentException("invalid block");
		}else{
			Node added = new Node(blk,null);
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
		boolean ret = true;
		while(temp.next!=null){
			if (temp.data.curHash!=temp.next.data.preHash){
				ret = false;
			}
		}
		return ret;
	}
	public void printBalances(){
		int total = this.first.data.amount;
		int alice = 0;
		int bob;
		Node temp = this.first;
		while (temp.next!=null){
			alice +=temp.data.amount;
			temp = temp.next;
		}
		bob = total - alice;
		Object[] args = new Object[]{new Integer[alice], new Integer[bob]};
		System.out.printf("Alice: %d, Bob: %d", args);

	}
}
