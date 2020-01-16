package org.mountcloud.springproject.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author zhanghaishan
 * @version V1.0
 * TODO: 异常工具
 * 2020年1月7日.
 */
public class ExceptionUtil {

	/**
	 * 将异常转为字符串
	 * @param e 异常
	 * @return 字符串
	 */
	public static String toString(Throwable e) {
		if (e == null){
			return "";
		}
		StringWriter stringWriter = new StringWriter();
		e.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}

}
