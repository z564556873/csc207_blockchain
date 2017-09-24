import java.util.Arrays;


public class Hash {
	byte[] hash;
	public Hash(byte[] data){
		this.hash=data;
	}
	public byte[] getdata(){
		return this.hash;
	}
	public boolean isValid(){
		return (hash[0]==0&&hash[1]==0&&hash[2]==0);
	}
	public String toString(){
		int[] arr = new int[hash.length];
		for (int i = 0; i<hash.length;i++){
			arr[i]=Byte.toUnsignedInt(hash[i]);
		}
		String ret = String.format("%x",arr[0]);
		return ret;
	}
	public boolean equals(Object other){
		if(other instanceof Hash){
			Hash o = (Hash) other;
			return Arrays.equals(this.hash,o.getdata());
		}else{
			return false;
		}
	}
}
