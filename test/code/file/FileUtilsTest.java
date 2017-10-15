package code.file;

import org.junit.Test;

public class FileUtilsTest {

	@Test
	public void testWriteFileWithFolder() {
		String content = "顶你个肺";
		FileUtils.writeTextFile("D:\\aa\\a.text", content);
	}

}
