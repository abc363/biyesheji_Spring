package cn.WindTech.store.entity;
//新闻实体类
public class News extends BaseEntity{
    private static final long serialVersionUID = 1L;
    private Integer nid;
    private String news_title;
    private String news_image;
    private String news_date;
    private String news_tag;
    private String news_intro;
    private String news_content;
    private String news_praise;
    private String news_comment;
    private String news_isPass;
    private String news_view;
    private String news_share;
    private String news_hot;
    private String news_activity;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_image() {
        return news_image;
    }

    public void setNews_image(String news_image) {
        this.news_image = news_image;
    }

    public String getNews_date() {
        return news_date;
    }

    public void setNews_date(String news_date) {
        this.news_date = news_date;
    }

    public String getNews_tag() {
        return news_tag;
    }

    public void setNews_tag(String news_tag) {
        this.news_tag = news_tag;
    }

    public String getNews_intro() {
        return news_intro;
    }

    public void setNews_intro(String news_intro) {
        this.news_intro = news_intro;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
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

    public String getNews_isPass() {
        return news_isPass;
    }

    public void setNews_isPass(String news_isPass) {
        this.news_isPass = news_isPass;
    }

    public String getNews_view() {
        return news_view;
    }

    public void setNews_view(String news_view) {
        this.news_view = news_view;
    }

    public String getNews_share() {
        return news_share;
    }

    public void setNews_share(String news_share) {
        this.news_share = news_share;
    }

    public String getNews_hot() {
        return news_hot;
    }

    public void setNews_hot(String news_hot) {
        this.news_hot = news_hot;
    }

    public String getNews_activity() {
        return news_activity;
    }

    public void setNews_activity(String news_activity) {
        this.news_activity = news_activity;
    }

    @Override
    public String toString() {
        return "News{" +
                "nid=" + nid +
                ", news_title='" + news_title + '\'' +
                ", news_image='" + news_image + '\'' +
                ", news_date='" + news_date + '\'' +
                ", news_tag='" + news_tag + '\'' +
                ", news_intro='" + news_intro + '\'' +
                ", news_content='" + news_content + '\'' +
                ", news_praise='" + news_praise + '\'' +
                ", news_comment='" + news_comment + '\'' +
                ", news_isPass='" + news_isPass + '\'' +
                ", news_view='" + news_view + '\'' +
                ", news_share='" + news_share + '\'' +
                ", news_hot='" + news_hot + '\'' +
                ", news_activity='" + news_activity + '\'' +
                '}';
    }
}
