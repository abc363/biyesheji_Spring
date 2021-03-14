package cn.WindTech.store.entity;
//搜索新闻基类
public class SearchActivity {
    private static final long serialVersionUID = 1L;
    private String activity_name;
    private String activity_stage;
    private Integer startPage;
    private Integer pageSize;

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getActivity_stage() {
        return activity_stage;
    }

    public void setActivity_stage(String activity_stage) {
        this.activity_stage = activity_stage;
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
        return "SearchActivity{" +
                "activity_name='" + activity_name + '\'' +
                ", activity_stage='" + activity_stage + '\'' +
                ", startPage=" + startPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
