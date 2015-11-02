package code.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileCopyUtils {

	/**
	 * 复制文件
	 * 
	 * @param fromFile
	 *            被复制的文件
	 * @param toFile
	 *            复制的目录文件
	 * @param rewrite
	 *            是否覆盖
	 */
	public static final void copyfile(File fromFile, File toFile, Boolean rewrite) {
		if (fromFile.exists() && fromFile.isFile() && fromFile.canRead()) {
			if (!toFile.getParentFile().exists()) {
				toFile.getParentFile().mkdirs();
			}
			if (toFile.exists() && rewrite) {
				toFile.delete();
			}
		}
		nioTransferCopy(fromFile, toFile);
	}

	/**
	 * 正规复制文件方法，使用Java中的IO的API
	 * 
	 * @param source
	 * @param target
	 * 
	 */
	@SuppressWarnings("unused")
	private static final void commonCopy(File source, File target) {
		InputStream fis = null;
		OutputStream fos = null;
		try {
			fis = new BufferedInputStream(new FileInputStream(source));
			fos = new BufferedOutputStream(new FileOutputStream(target));
			byte[] buf = new byte[4096];
			int i;
			while ((i = fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(fis);
			close(fos);
		}

	}

	/**
	 * 正规复制文件方法，使用Java中的NIO的API<br>
	 * 带缓冲
	 * 
	 * @param source
	 * @param target
	 * 
	 */
	@SuppressWarnings("unused")
	private static final void nioBufferCopy(File source, File target) {
		FileChannel in = null;
		FileChannel out = null;
		FileInputStream inStream = null;
		FileOutputStream outStream = null;
		try {
			inStream = new FileInputStream(source);
			outStream = new FileOutputStream(target);
			in = inStream.getChannel();
			out = outStream.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(4096);
			while (in.read(buffer) != -1) {
				buffer.flip();
				out.write(buffer);
				buffer.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(inStream);
			close(in);
			close(outStream);
			close(out);
		}
	}

	/**
	 * 正规复制文件方法，使用Java中的NIO的API<br>
	 * 不带缓冲
	 * 
	 * @param source
	 * @param target
	 * 
	 */
	private static final void nioTransferCopy(File source, File target) {
		FileChannel in = null;
		FileChannel out = null;
		FileInputStream inStream = null;
		FileOutputStream outStream = null;
		try {
			inStream = new FileInputStream(source);
			outStream = new FileOutputStream(target);
			in = inStream.getChannel();
			out = outStream.getChannel();
			in.transferTo(0, in.size(), out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(inStream);
			close(in);
			close(outStream);
			close(out);
		}
	}

	private static final void close(Closeable c) {
		try {
			c.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
