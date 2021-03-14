package cn.WindTech.store.entity;
//新闻实体类
public class UsersActivity extends BaseEntity{
    private static final long serialVersionUID = 1L;
    private Integer bid;
    private String user_id;
    private String news_tag;
    private String tag_praise;
    private String tag_comment;
    private String tag_view;
    private String tag_search;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNews_tag() {
        return news_tag;
    }

    public void setNews_tag(String news_tag) {
        this.news_tag = news_tag;
    }

    public String getTag_praise() {
        return tag_praise;
    }

    public void setTag_praise(String tag_praise) {
        this.tag_praise = tag_praise;
    }

    public String getTag_comment() {
        return tag_comment;
    }

    public void setTag_comment(String tag_comment) {
        this.tag_comment = tag_comment;
    }

    public String getTag_view() {
        return tag_view;
    }

    public void setTag_view(String tag_view) {
        this.tag_view = tag_view;
    }

    public String getTag_search() {
        return tag_search;
    }

    public void setTag_search(String tag_search) {
        this.tag_search = tag_search;
    }

    @Override
    public String toString() {
        return "UsersActivity{" +
                "bid=" + bid +
                ", user_id='" + user_id + '\'' +
                ", news_tag='" + news_tag + '\'' +
                ", tag_praise='" + tag_praise + '\'' +
                ", tag_comment='" + tag_comment + '\'' +
                ", tag_view='" + tag_view + '\'' +
                ", tag_search='" + tag_search + '\'' +
                '}';
    }
}
