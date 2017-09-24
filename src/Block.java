
public class Block {
	int num;
	int amount;
	Hash preHash;
	long nonce = 0;
	Hash curHash;
	public Block(int num, int amount, Hash preHash){
		this.num=num;
		this.amount=amount;
		this.preHash=preHash;
		while (!curHash.isValid){
			curHash =calculateHash();
		}
	}
	public Block(int num, int amount, Hash preHash, long nonce){
		this.num=num;
		this.amount=amount;
		this.preHash=preHash;
		this.nonce=nonce;
	}
	public int getNum(){
		return this.num;
	}
	public int getAmount(){
		return this.amount;
	}
	public long getNonce(){
		return this.nonce;
	}
	public Hash getprevHash(){
		return this.preHash;
	}
	public Hash getHash(){
		return this.curHash;
	}
	public String toString(){
	}
}
