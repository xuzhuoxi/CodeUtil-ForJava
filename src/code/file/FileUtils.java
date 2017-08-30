package code.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import code.array.ArrayUtils;

public class FileUtils {
	/**
	 * 计算文件的文件名(去掉.扩展名)
	 * 
	 * @param fileName
	 *            完整文件名
	 * @return 不包含扩展名的文件名，没有扩展名则返回完整文件名。
	 */
	public static final String getFilePrefixName(String fileName) {
		if ((fileName != null) && (fileName.length() > 0)) {
			int dot = fileName.lastIndexOf('.');
			if ((dot > -1) && (dot < (fileName.length()))) {
				return fileName.substring(0, dot);
			}
		}
		return fileName;

	}

	/**
	 * 计算文件的扩展名(不含.)
	 * 
	 * @param fileName
	 *            完整文件名
	 * @return 扩展名，没有扩展名则返回完整文件名。
	 */
	public static final String getFileExtensionName(String fileName) {
		if ((fileName != null) && (fileName.length() > 0)) {
			int dot = fileName.lastIndexOf('.');
			if ((dot > -1) && (dot < (fileName.length() - 1))) {
				return fileName.substring(dot + 1);
			}
		}
		return fileName;
	}

	/**
	 * 取文件夹下全部扩展名为extName中的一个的文件路径<br>
	 * 不包含子文件夹
	 * 
	 * @param folder
	 *            文件夹路径<br>
	 * @param extNames
	 *            扩展名数组<br>
	 * @return 文件数组
	 */
	public static final File[] getFiles(String folder, String[] extNames) {
		File file = new File(folder);
		if (!file.exists() || !file.isDirectory()) {
			return null;
		}
		List<File> folderList = new ArrayList<File>();
		List<File> fileList = new ArrayList<File>();
		for (File f : file.listFiles()) {
			if (f.isDirectory()) {
				folderList.add(f);
				continue;
			}
			if (extNames == null || extNames.length == 0
					|| ArrayUtils.isExist(extNames, getFileExtensionName(f.getName()))) {
				fileList.add(f);
			}
		}
		File[] files = new File[fileList.size()];
		return fileList.toArray(files);
	}

	/**
	 * 取文件夹下全部扩展名为extName中的一个的文件路径<br>
	 * 
	 * @param folder
	 *            文件夹路径<br>
	 * @param extNames
	 *            扩展名数组<br>
	 * @param recursive
	 *            是否递归全部子文件夹
	 * @return 文件数组
	 */
	public static final File[] getFiles(String folder, String[] extNames, boolean recursive) {
		if (!recursive) {
			return getFiles(folder, extNames);
		}
		File file = new File(folder);
		List<File> folderList = new ArrayList<File>();
		List<File> fileList = new ArrayList<File>();
		for (File f : file.listFiles()) {
			if (f.isDirectory()) {
				folderList.add(f);
				continue;
			}
			if (extNames == null || extNames.length == 0
					|| ArrayUtils.isExist(extNames, getFileExtensionName(f.getName()))) {
				fileList.add(f);
			}
		}
		File temp_file;
		File[] files;
		while (!folderList.isEmpty()) {
			temp_file = folderList.remove(0);
			files = temp_file.listFiles();
			for (File file2 : files) {
				if (file2.isDirectory()) {
					folderList.add(file2);
				} else if (extNames == null || extNames.length == 0
						|| ArrayUtils.isExist(extNames, getFileExtensionName(file2.getName()))) {
					fileList.add(file2);
				}
			}
		}
		File[] rsFiles = new File[fileList.size()];
		return fileList.toArray(rsFiles);
	}

	/**
	 * 文件或文件夹是否存在
	 * 
	 * @param fileFullPath
	 *            文件路径<br>
	 * @return true:存在，false不存在
	 */
	public static final boolean isExists(String fileFullPath) {
		return new File(fileFullPath).exists();
	}

	/**
	 * 是文件夹
	 * 
	 * @param fileFullPath
	 *            文件路径<br>
	 * @return true:是，false不是
	 */
	public static final boolean isFolder(String fileFullPath) {
		return new File(fileFullPath).isDirectory();
	}

	/**
	 * 文件或文件夹是否可写
	 * 
	 * @param fileFullPath
	 *            文件路径<br>
	 * @return true:可写，false不可写
	 */
	public static final boolean isFileCanWrite(String fileFullPath) {
		return new File(fileFullPath).canWrite();
	}

	/**
	 * 写字符文件
	 * 
	 * @param filePath
	 *            文件路径<br>
	 * @param content
	 *            以UTF-8格式写入
	 */
	public static final void writeTextFile(String filePath, String content) {
		Charset charset = Charset.forName("UTF-8");
		writeTextFile(filePath, content, charset);
	}

	/**
	 * 写字符文件
	 * 
	 * @param filePath
	 *            文件路径<br>
	 * @param content
	 *            文本内容<br>
	 * @param charsetName
	 *            编码格式<br>
	 */
	public static final void writeTextFile(String filePath, String content, String charsetName) {
		Charset charset = Charset.forName(charsetName);
		writeTextFile(filePath, content, charset);
	}

	/**
	 * 写字符文件
	 * 
	 * @param filePath
	 *            文件路径<br>
	 * @param content
	 *            文件路径<br>
	 *            文本内容<br>
	 * @param charset
	 *            编码格式<br>
	 */
	public static final void writeTextFile(String filePath, String content, Charset charset) {
		File file = null;
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		try {
			file = new File(filePath);
			if (!file.exists()) {
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			osw = new OutputStreamWriter(fos, charset);
			osw.write(content);
			osw.flush();
			osw.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (osw != null) {
					osw.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 写二进制文件
	 * 
	 * @param filePath
	 *            文件路径<br>
	 * @param content
	 *            文本内容<br>
	 */
	public static final void writeBinaryFile(String filePath, byte[] content) {
		FileOutputStream fos = null;
		File file = null;
		try {
			file = new File(filePath);
			if (!file.exists()) {
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			fos.write(content);
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读取字符文件内容，默认utf-8格式
	 * 
	 * @param filePath
	 *            文件路径
	 * @return 文本内容
	 */
	public static final String readFileContent(String filePath) {
		return readFileContent(filePath, "UTF-8");
	}

	/**
	 * 读取字符文件内容
	 * 
	 * @param filePath
	 *            文件路径
	 * @param charsetName
	 *            字符集
	 * @return 文本内容
	 */
	public static final String readFileContent(String filePath, String charsetName) {
		Charset charset = Charset.forName(charsetName);
		return readFileContent(filePath, charset);
	}

	/**
	 * 读取字符文件内容
	 * 
	 * @param filePath
	 *            文件路径
	 * @param charset
	 *            字符集
	 * @return 文本内容
	 */
	public static final String readFileContent(String filePath, Charset charset) {
		File file = new File(filePath);
		BufferedReader fr = null;
		StringBuilder sb = new StringBuilder("");
		try {
			fr = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
			boolean first = true;
			while (fr.ready()) {
				if (first) {
					first = false;
					sb.append(fr.readLine());
				} else {
					sb.append(System.lineSeparator() + fr.readLine());
				}
			}
			fr.close();
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (null != fr) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 读二进制文件内容<br>
	 * 只适用于小文件
	 * 
	 * @param filePath
	 *            文件路径
	 * @return 字节数组
	 */
	public static final byte[] readBinaryContent(String filePath) {
		File file = new File(filePath);
		int len = (int) file.length();
		byte[] rs = new byte[len];
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			bis.read(rs, 0, len);
			bis.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != bis) {
					bis.close();
				}
				if (null != fis) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
}
