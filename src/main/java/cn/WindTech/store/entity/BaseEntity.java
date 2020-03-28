package cn.WindTech.store.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类的基类
 */
abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -5882064199939706583L;

	private String modifiedUser;
	private Date modifiedTime;

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "BaseEntity [modifiedUser=" + modifiedUser + ", modifiedTime=" + modifiedTime + "]";
	}

}
