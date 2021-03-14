package cn.WindTech.store.entity;
//删除新闻类
public class delActivity extends BaseEntity{
    private static final long serialVersionUID = 1L;
    private Integer aid;
    private String activity_rules;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getActivity_rules() {
        return activity_rules;
    }

    public void setActivity_rules(String activity_rules) {
        this.activity_rules = activity_rules;
    }

    @Override
    public String toString() {
        return "delActivity{" +
                "aid=" + aid +
                ", activity_rules='" + activity_rules + '\'' +
                '}';
    }
}
