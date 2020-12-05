package cn.WindTech.store.vo;

import java.io.Serializable;

public class TypeVO implements Serializable {
    private static final long serialVersionUID = -1375921507047753775L;
    private String pro_Type;

    public String getPro_Type() {
        return pro_Type;
    }

    public void setPro_Type(String pro_Type) {
        this.pro_Type = pro_Type;
    }

    @Override
    public String toString() {
        return "TypeVO{" +
                "pro_Type='" + pro_Type + '\'' +
                '}';
    }
}
