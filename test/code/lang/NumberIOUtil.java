package code.lang;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class NumberIOUtil {
	public static short readShort(byte[] b) {
		InputStream is = new ByteArrayInputStream(b);
		DataInputStream dis = new DataInputStream(is);
		try {
			return dis.readShort();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Short.MIN_VALUE;
	}
}
