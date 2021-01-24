package cn.WindTech.store.entity;
//删除新闻类
public class delNews extends BaseEntity{
    private static final long serialVersionUID = 1L;
    private Integer nid;
    private String filePath;
    private String fileName;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "delNews{" +
                "nid=" + nid +
                ", filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
