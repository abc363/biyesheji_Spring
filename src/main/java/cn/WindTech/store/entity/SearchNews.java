package cn.WindTech.store.entity;
//搜索新闻基类
public class SearchNews {
    private static final long serialVersionUID = 1L;
    private String new_title;
    private String new_type;
    private Integer startPage;
    private Integer pageSize;

    public String getNew_title() {
        return new_title;
    }

    public void setNew_title(String new_title) {
        this.new_title = new_title;
    }

    public String getNew_type() {
        return new_type;
    }

    public void setNew_type(String new_type) {
        this.new_type = new_type;
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
                "new_title='" + new_title + '\'' +
                ", new_type='" + new_type + '\'' +
                ", startPage=" + startPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
