package cn.WindTech.store.entity;
//新闻实体类
public class ActivityNews extends BaseEntity{
    private static final long serialVersionUID = 1L;
    private Integer anid;
    private String news_title;
    private String users_name;
    private String users_id;
    private String news_view;
    private String news_praise;
    private String news_comment;
    private String news_date;
    private String news_award;

    public Integer getAnid() {
        return anid;
    }

    public void setAnid(Integer anid) {
        this.anid = anid;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getUsers_name() {
        return users_name;
    }

    public void setUsers_name(String users_name) {
        this.users_name = users_name;
    }

    public String getUsers_id() {
        return users_id;
    }

    public void setUsers_id(String users_id) {
        this.users_id = users_id;
    }

    public String getNews_view() {
        return news_view;
    }

    public void setNews_view(String news_view) {
        this.news_view = news_view;
    }

    public String getNews_praise() {
        return news_praise;
    }

    public void setNews_praise(String news_praise) {
        this.news_praise = news_praise;
    }

    public String getNews_comment() {
        return news_comment;
    }

    public void setNews_comment(String news_comment) {
        this.news_comment = news_comment;
    }

    public String getNews_date() {
        return news_date;
    }

    public void setNews_date(String news_date) {
        this.news_date = news_date;
    }

    public String getNews_award() {
        return news_award;
    }

    public void setNews_award(String news_award) {
        this.news_award = news_award;
    }

    @Override
    public String toString() {
        return "ActivityNews{" +
                "anid=" + anid +
                ", news_title='" + news_title + '\'' +
                ", users_name='" + users_name + '\'' +
                ", users_id='" + users_id + '\'' +
                ", news_view='" + news_view + '\'' +
                ", news_praise='" + news_praise + '\'' +
                ", news_comment='" + news_comment + '\'' +
                ", news_date='" + news_date + '\'' +
                ", news_award='" + news_award + '\'' +
                '}';
    }
}
