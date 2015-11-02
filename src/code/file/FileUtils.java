package code.file;

public class FileUtils {
	/**
	 * 计算文件的文件名(去掉.扩展名)
	 * 
	 * @param fileName
	 * @return
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
	 * @return
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
}
