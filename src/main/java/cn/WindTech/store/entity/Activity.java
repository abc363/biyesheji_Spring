package cn.WindTech.store.entity;
//新闻实体类
public class Activity extends BaseEntity{
    private static final long serialVersionUID = 1L;
    private Integer aid;
    private String activity_name;
    private String activity_rules;
    private String startTime;
    private String endTime;
    private String activity_state;
    private String awards;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getActivity_rules() {
        return activity_rules;
    }

    public void setActivity_rules(String activity_rules) {
        this.activity_rules = activity_rules;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getActivity_state() {
        return activity_state;
    }

    public void setActivity_state(String activity_state) {
        this.activity_state = activity_state;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "aid=" + aid +
                ", activity_name='" + activity_name + '\'' +
                ", activity_rules='" + activity_rules + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", activity_state='" + activity_state + '\'' +
                ", awards='" + awards + '\'' +
                '}';
    }
}
