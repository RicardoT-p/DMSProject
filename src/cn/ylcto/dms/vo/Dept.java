package cn.ylcto.dms.vo;

import java.io.Serializable;
import java.util.List;

public class Dept implements Serializable {
    private Integer did;
    private String title;
    private String note;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
