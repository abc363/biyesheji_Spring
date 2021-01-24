package cn.WindTech.store.entity;
//搜索产品基类
public class Search {
    private static final long serialVersionUID = 1L;
    private String pro_State;
    private String pro_Type;
    private String pro_Name;
    private Integer startPage;
    private Integer pageSize;

    public String getPro_State() {
        return pro_State;
    }

    public void setPro_State(String pro_State) {
        this.pro_State = pro_State;
    }

    public String getPro_Type() {
        return pro_Type;
    }

    public void setPro_Type(String pro_Type) {
        this.pro_Type = pro_Type;
    }

    public String getPro_Name() {
        return pro_Name;
    }

    public void setPro_Name(String pro_Name) {
        this.pro_Name = pro_Name;
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
        return "Search{" +
                "pro_State='" + pro_State + '\'' +
                ", pro_Type='" + pro_Type + '\'' +
                ", pro_Name='" + pro_Name + '\'' +
                ", startPage=" + startPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
