import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.ByteBuffer;

public class Block {
	int num;
	int amount;
	Hash preHash;
	long nonce = 0;
	Hash curHash;
	public Block(int num, int amount, Hash preHash) throws NoSuchAlgorithmException{
		this.num=num;
		this.amount=amount;
		this.preHash=preHash;
		do{
			this.curHash = calculateHash(this.num, this.amount, this.nonce, this.preHash);			this.nonce++;
		}while (!this.curHash.isValid());
	}
	public Block(int num, int amount, Hash preHash, long nonce) throws NoSuchAlgorithmException {
		this.num=num;
		this.amount=amount;
		this.preHash=preHash;
		this.nonce=nonce;
		this.curHash= calculateHash(this.num, this.amount, this.nonce, this.preHash);
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
		String ret;
		Object[] args = new Object[]{new Integer(this.num), new Integer(this.amount),new Long(this.nonce), this.preHash == null ? "null" : this.preHash.toString() ,
				this.curHash.toString()};
		ret = String.format("Block %d (Amount: %d, Nonce: %d, prevHash: %s, hash: %s", args);
		return ret;
	}
	public static Hash calculateHash(int num, int amount,long nonce,Hash preHash) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("sha-256");
		ByteBuffer byte1 = ByteBuffer.allocate(8);
		ByteBuffer byte2 = ByteBuffer.allocate(8);
		byte1.putInt(num).putInt(amount);
		byte2.putLong(nonce);
		md.update(byte1.array());
		if (preHash != null) {
			md.update(preHash.getData());
		}
		md.update(byte2.array());
		byte[] hash = md.digest();
		Hash ret = new Hash(hash);
		return ret;
	}
}
