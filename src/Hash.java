import java.util.Arrays;

public class Hash {
	byte[] hash;
	public Hash(byte[] data){
		this.hash=data;
	}
	public byte[] getData(){
		return this.hash;
	}
	public boolean isValid(){
		return (hash[0]==0&&hash[1]==0&&hash[2]==0);
	}
	public String toString(){
		int[] arr = new int[hash.length];
		String ret = "";
		for (int i = 0; i<hash.length;i++){
			arr[i]=Byte.toUnsignedInt(hash[i]);
			Object[] args = new Object[]{new Integer(arr[i])};
			ret += String.format("%02X",args);
		}
		return ret;
	}
	public boolean equals(Object other){
		if(other instanceof Hash){
			Hash o = (Hash) other;
			return Arrays.equals(this.hash,o.getData());
		}else{
			return false;
		}
	}
}
