package org.mountcloud.springproject.common.util.part;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 分片工具
 * @author zhanghaishan
 * @version V1.0
 * TODO:
 * 2019年12月23日.
 */
public class PartUtil {
	
	/**
	 * 获取分片信息
	 * @param count 总数据长度
	 * @param partLength 需要分几片
	 * @return 返回片段信息
	 * @throws IllegalAccessException 异常
	 */
	public static List<Part> getParts(Long count, Integer partLength) throws IllegalAccessException {
		BigDecimal countPartDecimal = new BigDecimal(count).divide(new BigDecimal(partLength),
				BigDecimal.ROUND_HALF_UP);
		Long countPartLength = countPartDecimal.longValue();
		List<Part> partsList = new ArrayList<>();
		for (int i = 0; i < partLength; i++) {
			Part part = new Part();
			BigDecimal nowPartStartDecimal = new BigDecimal(countPartLength).multiply(new BigDecimal(i));
			Long nowPartStart = nowPartStartDecimal.longValue();
			Long nowPartEnd = null;
			if (i == partLength - 1) {
				nowPartEnd = count - 1;
			} else {
				nowPartEnd = nowPartStartDecimal.add(countPartDecimal).longValue() - 1;
			}
			part.setStart(nowPartStart);
			part.setEnd(nowPartEnd);
			partsList.add(part);
		}
		return partsList;
	}
}
