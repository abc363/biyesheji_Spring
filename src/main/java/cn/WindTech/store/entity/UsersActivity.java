package cn.WindTech.store.entity;
//新闻实体类
public class UsersActivity extends BaseEntity{
    private static final long serialVersionUID = 1L;
    private Integer bid;
    private Integer uaid;
    private Integer news_id;
    private String news_tag;
    private Integer tag_praise;
    private Integer tag_comment;
    private Integer tag_view;
    private Integer tag_share;
    private String add_tag;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getUaid() {
        return uaid;
    }

    public void setUaid(Integer uaid) {
        this.uaid = uaid;
    }

    public Integer getNews_id() {
        return news_id;
    }

    public void setNews_id(Integer news_id) {
        this.news_id = news_id;
    }

    public String getNews_tag() {
        return news_tag;
    }

    public void setNews_tag(String news_tag) {
        this.news_tag = news_tag;
    }

    public Integer getTag_praise() {
        return tag_praise;
    }

    public void setTag_praise(Integer tag_praise) {
        this.tag_praise = tag_praise;
    }

    public Integer getTag_comment() {
        return tag_comment;
    }

    public void setTag_comment(Integer tag_comment) {
        this.tag_comment = tag_comment;
    }

    public Integer getTag_view() {
        return tag_view;
    }

    public void setTag_view(Integer tag_view) {
        this.tag_view = tag_view;
    }

    public Integer getTag_share() {
        return tag_share;
    }

    public void setTag_share(Integer tag_share) {
        this.tag_share = tag_share;
    }

    public String getAdd_tag() {
        return add_tag;
    }

    public void setAdd_tag(String add_tag) {
        this.add_tag = add_tag;
    }

    @Override
    public String toString() {
        return "UsersActivity{" +
                "bid=" + bid +
                ", uaid=" + uaid +
                ", news_id=" + news_id +
                ", news_tag='" + news_tag + '\'' +
                ", tag_praise=" + tag_praise +
                ", tag_comment=" + tag_comment +
                ", tag_view=" + tag_view +
                ", tag_share=" + tag_share +
                ", add_tag='" + add_tag + '\'' +
                '}';
    }
}
