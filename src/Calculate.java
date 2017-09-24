import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Calculate {
	public static byte[] calculateHash(String msg) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("sha-256");
		md.update(msg.getBytes());
		byte[] hash = md.digest();
		return hash;
	}
}
