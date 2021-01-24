package cn.WindTech.store.entity;
//新闻实体类
public class News extends BaseEntity{
    private static final long serialVersionUID = 1L;
    private Integer nid;
    private String new_title;
    private String new_image;
    private String new_date;
    private String new_type;
    private String new_intro;
    private String new_content;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getNew_title() {
        return new_title;
    }

    public void setNew_title(String new_title) {
        this.new_title = new_title;
    }

    public String getNew_image() {
        return new_image;
    }

    public void setNew_image(String new_image) {
        this.new_image = new_image;
    }

    public String getNew_date() {
        return new_date;
    }

    public void setNew_date(String new_date) {
        this.new_date = new_date;
    }

    public String getNew_type() {
        return new_type;
    }

    public void setNew_type(String new_type) {
        this.new_type = new_type;
    }

    public String getNew_intro() {
        return new_intro;
    }

    public void setNew_intro(String new_intro) {
        this.new_intro = new_intro;
    }

    public String getNew_content() {
        return new_content;
    }

    public void setNew_content(String new_content) {
        this.new_content = new_content;
    }

    @Override
    public String toString() {
        return "News{" +
                "nid=" + nid +
                ", new_title='" + new_title + '\'' +
                ", new_image='" + new_image + '\'' +
                ", new_date='" + new_date + '\'' +
                ", new_type='" + new_type + '\'' +
                ", new_intro='" + new_intro + '\'' +
                ", new_content='" + new_content + '\'' +
                '}';
    }
}
