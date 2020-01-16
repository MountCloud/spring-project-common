package org.mountcloud.springproject.common.util.part;

/**
 * 分片
 * @author zhanghaishan
 * @version V1.0
 * TODO: 分片
 * 2019年12月23日.
 */
public class Part {
	/**
	 * 开始下标 0开始
	 */
	private Long start;
	/**
	 * 结束下标 0开始
	 */
	private Long end;

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public Long getEnd() {
		return end;
	}

	public void setEnd(Long end) {
		this.end = end;
	}
}
