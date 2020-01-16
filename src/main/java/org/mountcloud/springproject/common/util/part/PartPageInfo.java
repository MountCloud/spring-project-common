package org.mountcloud.springproject.common.util.part;

import java.math.BigDecimal;

/**
 * 分片分页信息，用来做分片中的分页
 * @author zhanghaishan
 * @version V1.0
 * TODO:
 * 2019年12月23日.
 */
public class PartPageInfo {
	
	/**
	 * 页码
	 */
	private Long pageIndex;

	/**
	 * 每页数量
	 */
	private Long pageSize;

	/**
	 * 跳过多少
	 */
	private Long skip;

	/**
	 * 长度
	 */
	private Long limit;

	/**
	 * 分段
	 */
	private Part part;

	/**
	 * 在片段中创建分页信息，比如此片段是从 数据库中的第100开始到1000，我需要这个片段第一页，的数据则会自动计算我应该从下标多少开始到结束
	 * @param pageIndex 页码
	 * @param pageSize 每页数量
	 * @param part 片段
	 * @return 片段计算出来的分页信息
	 */
	public static PartPageInfo createPageInfo(Long pageIndex, Long pageSize, Part part) {
		BigDecimal pageSkipDecimal = new BigDecimal((pageIndex - 1)).multiply(new BigDecimal(pageSize));
		BigDecimal endDecimal = new BigDecimal((part.getEnd() + 1));
		if (pageSkipDecimal.compareTo(endDecimal) >= 0) {
			return null;
		}
		Long skip = pageSkipDecimal.longValue();
		Long limit = null;
		BigDecimal pageEndDecimal = pageSkipDecimal.add(new BigDecimal(pageSize));
		if (pageEndDecimal.compareTo(endDecimal) == 1) {
			limit = new BigDecimal(pageSize).add(endDecimal.subtract(pageEndDecimal)).longValue();
		} else {
			limit = pageSize;
		}
		PartPageInfo partPageInfo = new PartPageInfo();
		partPageInfo.setPart(part);
		partPageInfo.setPageIndex(pageIndex);
		partPageInfo.setPageSize(pageSize);
		partPageInfo.setSkip(skip);
		partPageInfo.setLimit(limit);
		return partPageInfo;
	}

	public Long getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Long pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getSkip() {
		return skip;
	}

	public void setSkip(Long skip) {
		this.skip = skip;
	}

	public Long getLimit() {
		return limit;
	}

	public void setLimit(Long limit) {
		this.limit = limit;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}
}
