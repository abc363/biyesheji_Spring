package cn.WindTech.store.entity;
//新闻实体类
public class News extends BaseEntity{
    private static final long serialVersionUID = 1L;
    private Integer nid;
    private Integer uaid;
    private String news_title;
    private String news_image;
    private String news_date;
    private String news_tag;
    private String news_intro;
    private String news_content;
    private Integer news_praise;
    private Integer news_comment;
    private Integer news_isPass;
    private Integer news_view;
    private Integer news_share;
    private Integer news_hot;
    private Integer news_isCold;
    private String news_activity;
    private String news_refuselog;
    private String news_award;
    private String news_activitylog;
    private String news_praiseArr;
    private String news_keywords;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getUaid() {
        return uaid;
    }

    public void setUaid(Integer uaid) {
        this.uaid = uaid;
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

    public Integer getNews_praise() {
        return news_praise;
    }

    public void setNews_praise(Integer news_praise) {
        this.news_praise = news_praise;
    }

    public Integer getNews_comment() {
        return news_comment;
    }

    public void setNews_comment(Integer news_comment) {
        this.news_comment = news_comment;
    }

    public Integer getNews_isPass() {
        return news_isPass;
    }

    public void setNews_isPass(Integer news_isPass) {
        this.news_isPass = news_isPass;
    }

    public Integer getNews_view() {
        return news_view;
    }

    public void setNews_view(Integer news_view) {
        this.news_view = news_view;
    }

    public Integer getNews_share() {
        return news_share;
    }

    public void setNews_share(Integer news_share) {
        this.news_share = news_share;
    }

    public Integer getNews_hot() {
        return news_hot;
    }

    public void setNews_hot(Integer news_hot) {
        this.news_hot = news_hot;
    }

    public Integer getNews_isCold() {
        return news_isCold;
    }

    public void setNews_isCold(Integer news_isCold) {
        this.news_isCold = news_isCold;
    }

    public String getNews_activity() {
        return news_activity;
    }

    public void setNews_activity(String news_activity) {
        this.news_activity = news_activity;
    }

    public String getNews_refuselog() {
        return news_refuselog;
    }

    public void setNews_refuselog(String news_refuselog) {
        this.news_refuselog = news_refuselog;
    }

    public String getNews_award() {
        return news_award;
    }

    public void setNews_award(String news_award) {
        this.news_award = news_award;
    }

    public String getNews_activitylog() {
        return news_activitylog;
    }

    public void setNews_activitylog(String news_activitylog) {
        this.news_activitylog = news_activitylog;
    }

    public String getNews_praiseArr() {
        return news_praiseArr;
    }

    public void setNews_praiseArr(String news_praiseArr) {
        this.news_praiseArr = news_praiseArr;
    }

    public String getNews_keywords() {
        return news_keywords;
    }

    public void setNews_keywords(String news_keywords) {
        this.news_keywords = news_keywords;
    }

    @Override
    public String toString() {
        return "News{" +
                "nid=" + nid +
                ", uaid=" + uaid +
                ", news_title='" + news_title + '\'' +
                ", news_image='" + news_image + '\'' +
                ", news_date='" + news_date + '\'' +
                ", news_tag='" + news_tag + '\'' +
                ", news_intro='" + news_intro + '\'' +
                ", news_content='" + news_content + '\'' +
                ", news_praise=" + news_praise +
                ", news_comment=" + news_comment +
                ", news_isPass=" + news_isPass +
                ", news_view=" + news_view +
                ", news_share=" + news_share +
                ", news_hot=" + news_hot +
                ", news_isCold=" + news_isCold +
                ", news_activity='" + news_activity + '\'' +
                ", news_refuselog='" + news_refuselog + '\'' +
                ", news_award='" + news_award + '\'' +
                ", news_activitylog='" + news_activitylog + '\'' +
                ", news_praiseArr='" + news_praiseArr + '\'' +
                ", news_keywords='" + news_keywords + '\'' +
                '}';
    }
}
