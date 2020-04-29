package cn.WindTech.store.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类的基类
 */
abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -5882064199939706583L;

	private String modifiedUser;
	private String modifiedTime;
	private String createdUser;
	private String createdTime;

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public String getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public String toString() {
		return "BaseEntity{" +
				"modifiedUser='" + modifiedUser + '\'' +
				", modifiedTime=" + modifiedTime +
				", createdUser='" + createdUser + '\'' +
				", createdTime=" + createdTime +
				'}';
	}
}
