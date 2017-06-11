package code.error;

public class ThrowableUtil {
	public static final String getPrintStackTrace(Throwable e) {
		StringBuilder sb = new StringBuilder();
		sb.append(e + "\n");
		for (StackTraceElement ste : e.getStackTrace()) {
			sb.append("\t at  " + ste + "\n");
		}
		return sb.toString();
	}
}
