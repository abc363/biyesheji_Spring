package cn.WindTech.store.entity;
//搜索新闻基类
public class SearchNews {
    private static final long serialVersionUID = 1L;
    private String news_title;
    private String news_tag;
    private Integer startPage;
    private Integer pageSize;

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_tag() {
        return news_tag;
    }

    public void setNews_tag(String news_tag) {
        this.news_tag = news_tag;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "SearchNews{" +
                "news_title='" + news_title + '\'' +
                ", news_tag='" + news_tag + '\'' +
                ", startPage=" + startPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
