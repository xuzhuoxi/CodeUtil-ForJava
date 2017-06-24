package code.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
	 * @param extName
	 * @return
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
	 * @param extNames
	 * @param recursive
	 *            是否递归全部子文件夹
	 * @return
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
	 * @return
	 */
	public static final boolean isExists(String fileFullPath) {
		return new File(fileFullPath).exists();
	}

	/**
	 * 是文件夹
	 * 
	 * @param fileFullPath
	 * @return
	 */
	public static final boolean isFolder(String fileFullPath) {
		return new File(fileFullPath).isDirectory();
	}

	/**
	 * 文件或文件夹是否可写
	 * 
	 * @param fileFullPath
	 * @return
	 */
	public static final boolean isFileCanWrite(String fileFullPath) {
		return new File(fileFullPath).canWrite();
	}

	/**
	 * 读取字符文件内容，默认utf-8格式
	 * 
	 * @param filePath
	 *            文件路径
	 * @return
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
	 * @return
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
	 * @param charsetName
	 *            字符集
	 * @return
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
}
