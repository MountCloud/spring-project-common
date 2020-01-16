package org.mountcloud.cfgver.common.util;

import org.mountcloud.cfgver.common.result.RestfulResult;

/**
 * @author zhanghaishan
 * @version V1.0
 * TODO: 返回值工具，方便取返回值，省点代码量
 * 2020年1月6日.
 */
public class ResultUtil {

	/**
	 * 返回结果，如果没有结果则返回null
	 * @param restfulResult result bean
	 * @param <T> T
	 * @return result
	 */
	public static <T> T getResult(RestfulResult<T> restfulResult) {
		T result = null;
		if(restfulResult!=null) {
			result = restfulResult.getData();
		}
		return result;
	}
	
}
