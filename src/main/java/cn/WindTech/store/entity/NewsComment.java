package cn.WindTech.store.entity;
//新闻实体类
public class NewsComment extends BaseEntity{
    private static final long serialVersionUID = 1L;
    private Integer cid;
    private String news_id;
    private String user_name;
    private String comment_date;
    private String user_avatar;
    private String comment_praise;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getComment_date() {
        return comment_date;
    }

    public void setComment_date(String comment_date) {
        this.comment_date = comment_date;
    }

    public String getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    public String getComment_praise() {
        return comment_praise;
    }

    public void setComment_praise(String comment_praise) {
        this.comment_praise = comment_praise;
    }

    @Override
    public String toString() {
        return "NewsComment{" +
                "cid=" + cid +
                ", news_id='" + news_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", comment_date='" + comment_date + '\'' +
                ", user_avatar='" + user_avatar + '\'' +
                ", comment_praise='" + comment_praise + '\'' +
                '}';
    }
}
