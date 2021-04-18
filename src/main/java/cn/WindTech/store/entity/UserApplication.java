package cn.WindTech.store.entity;
//应用用户基类
public class UserApplication extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private Integer uaid;
	private String username;
	private String password;
	private String user_avatar;
	private Integer isDelete;
	private Integer news_isPublish;
	private Integer news_isNow;
	private Integer isCold;

	public Integer getUaid() {
		return uaid;
	}

	public void setUaid(Integer uaid) {
		this.uaid = uaid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_avatar() {
		return user_avatar;
	}

	public void setUser_avatar(String user_avatar) {
		this.user_avatar = user_avatar;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getNews_isPublish() {
		return news_isPublish;
	}

	public void setNews_isPublish(Integer news_isPublish) {
		this.news_isPublish = news_isPublish;
	}

	public Integer getNews_isNow() {
		return news_isNow;
	}

	public void setNews_isNow(Integer news_isNow) {
		this.news_isNow = news_isNow;
	}

	public Integer getIsCold() {
		return isCold;
	}

	public void setIsCold(Integer isCold) {
		this.isCold = isCold;
	}

	@Override
	public String toString() {
		return "UserApplication{" +
				"uaid=" + uaid +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", user_avatar='" + user_avatar + '\'' +
				", isDelete=" + isDelete +
				", news_isPublish=" + news_isPublish +
				", news_isNow=" + news_isNow +
				", isCold=" + isCold +
				'}';
	}
}
