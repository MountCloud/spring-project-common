package org.mountcloud.cfgver.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.mountcloud.cfgver.common.entity.annotation.EntityId;

/**
  * @author zhanghaishan
  * @version V1.0
  *
  * TODO: 基础的实体
  * 2020/1/16.
  */
@SuppressWarnings("serial")
public class BaseEntity implements Serializable{
	
	@EntityId("id")
	private Long id;
	
	private Date createTime;
	
	private Date updateTime;
	
	public BaseEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	
}
