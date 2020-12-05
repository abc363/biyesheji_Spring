package cn.WindTech.store.vo;

import java.io.Serializable;

public class FileVO implements Serializable {
    private static final long serialVersionUID = -1375921507047753775L;
    private String path;
    private String name;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FileVO{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
