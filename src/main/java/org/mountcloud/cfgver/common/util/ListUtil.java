package org.mountcloud.cfgver.common.util;

import java.util.List;

/**
  * @author zhanghaishan
  * @version V1.0
  *
  * TODO: 数组工具
  * 2020/1/16.
  */
public class ListUtil {

	/**
	 * Object强转数组，非List或者为null则返回null
	 * @param obj 对象
	 * @return 数组
	 */
	public static List toList(Object obj) {
		if(obj!=null&&obj instanceof List) {
			return (List) obj;
		}
		return null;
	}
}
