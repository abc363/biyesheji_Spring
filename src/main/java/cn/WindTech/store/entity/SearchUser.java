package cn.WindTech.store.entity;
//搜索新闻基类
public class SearchUser {
    private static final long serialVersionUID = 1L;
    private String username;
    private Integer startPage;
    private Integer pageSize;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return "SearchUser{" +
                "username='" + username + '\'' +
                ", startPage=" + startPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
