package cn.WindTech.store.entity;

public class Product extends BaseEntity{
    private static final long serialVersionUID = 1L;
    private Integer pid;
    private String pro_Name;
    private String pro_Type;
    private Integer pro_Num;
    private String pro_State;
    private String  pro_fontTiltOne;
    private String pro_file;
    private String pro_fileName;
    private String pro_finger;
    private String pro_fingerName;
    private String pro_driver;
    private String pro_driverName;
    private String pro_info;
    private String pro_video;
    private String pro_videoName;
    private String pro_fontTiltTwo;
    private String pro_backTiltOne;
    private String pro_backTiltTwo;
    private String pro_font;
    private String pro_back;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPro_Name() {
        return pro_Name;
    }

    public void setPro_Name(String pro_Name) {
        this.pro_Name = pro_Name;
    }

    public String getPro_Type() {
        return pro_Type;
    }

    public void setPro_Type(String pro_Type) {
        this.pro_Type = pro_Type;
    }

    public Integer getPro_Num() {
        return pro_Num;
    }

    public void setPro_Num(Integer pro_Num) {
        this.pro_Num = pro_Num;
    }

    public String getPro_State() {
        return pro_State;
    }

    public void setPro_State(String pro_State) {
        this.pro_State = pro_State;
    }

    public String getPro_fontTiltOne() {
        return pro_fontTiltOne;
    }

    public void setPro_fontTiltOne(String pro_fontTiltOne) {
        this.pro_fontTiltOne = pro_fontTiltOne;
    }

    public String getPro_file() {
        return pro_file;
    }

    public void setPro_file(String pro_file) {
        this.pro_file = pro_file;
    }

    public String getPro_fileName() {
        return pro_fileName;
    }

    public void setPro_fileName(String pro_fileName) {
        this.pro_fileName = pro_fileName;
    }

    public String getPro_finger() {
        return pro_finger;
    }

    public void setPro_finger(String pro_finger) {
        this.pro_finger = pro_finger;
    }

    public String getPro_fingerName() {
        return pro_fingerName;
    }

    public void setPro_fingerName(String pro_fingerName) {
        this.pro_fingerName = pro_fingerName;
    }

    public String getPro_driver() {
        return pro_driver;
    }

    public void setPro_driver(String pro_driver) {
        this.pro_driver = pro_driver;
    }

    public String getPro_driverName() {
        return pro_driverName;
    }

    public void setPro_driverName(String pro_driverName) {
        this.pro_driverName = pro_driverName;
    }

    public String getPro_info() {
        return pro_info;
    }

    public void setPro_info(String pro_info) {
        this.pro_info = pro_info;
    }

    public String getPro_video() {
        return pro_video;
    }

    public void setPro_video(String pro_video) {
        this.pro_video = pro_video;
    }

    public String getPro_videoName() {
        return pro_videoName;
    }

    public void setPro_videoName(String pro_videoName) {
        this.pro_videoName = pro_videoName;
    }

    public String getPro_fontTiltTwo() {
        return pro_fontTiltTwo;
    }

    public void setPro_fontTiltTwo(String pro_fontTiltTwo) {
        this.pro_fontTiltTwo = pro_fontTiltTwo;
    }

    public String getPro_backTiltOne() {
        return pro_backTiltOne;
    }

    public void setPro_backTiltOne(String pro_backTiltOne) {
        this.pro_backTiltOne = pro_backTiltOne;
    }

    public String getPro_backTiltTwo() {
        return pro_backTiltTwo;
    }

    public void setPro_backTiltTwo(String pro_backTiltTwo) {
        this.pro_backTiltTwo = pro_backTiltTwo;
    }

    public String getPro_font() {
        return pro_font;
    }

    public void setPro_font(String pro_font) {
        this.pro_font = pro_font;
    }

    public String getPro_back() {
        return pro_back;
    }

    public void setPro_back(String pro_back) {
        this.pro_back = pro_back;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pro_Name='" + pro_Name + '\'' +
                ", pro_Type='" + pro_Type + '\'' +
                ", pro_Num=" + pro_Num +
                ", pro_State=" + pro_State +
                ", pro_fontTiltOne='" + pro_fontTiltOne + '\'' +
                ", pro_file='" + pro_file + '\'' +
                ", pro_fileName='" + pro_fileName + '\'' +
                ", pro_finger='" + pro_finger + '\'' +
                ", pro_fingerName='" + pro_fingerName + '\'' +
                ", pro_driver='" + pro_driver + '\'' +
                ", pro_driverName='" + pro_driverName + '\'' +
                ", pro_info='" + pro_info + '\'' +
                ", pro_video='" + pro_video + '\'' +
                ", pro_videoName='" + pro_videoName + '\'' +
                ", pro_fontTiltTwo='" + pro_fontTiltTwo + '\'' +
                ", pro_backTiltOne='" + pro_backTiltOne + '\'' +
                ", pro_backTiltTwo='" + pro_backTiltTwo + '\'' +
                ", pro_font='" + pro_font + '\'' +
                ", pro_back='" + pro_back + '\'' +
                '}';
    }
}
