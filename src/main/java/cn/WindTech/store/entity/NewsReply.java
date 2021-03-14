package cn.WindTech.store.entity;
//新闻实体类
public class NewsReply extends BaseEntity{
    private static final long serialVersionUID = 1L;
    private Integer rid;
    private String comment_id;
    private String user_name;
    private String reply_date;
    private String reply_praise;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getReply_date() {
        return reply_date;
    }

    public void setReply_date(String reply_date) {
        this.reply_date = reply_date;
    }

    public String getReply_praise() {
        return reply_praise;
    }

    public void setReply_praise(String reply_praise) {
        this.reply_praise = reply_praise;
    }

    @Override
    public String toString() {
        return "NewsReply{" +
                "rid=" + rid +
                ", comment_id='" + comment_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", reply_date='" + reply_date + '\'' +
                ", reply_praise='" + reply_praise + '\'' +
                '}';
    }
}
