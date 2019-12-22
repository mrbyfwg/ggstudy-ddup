package com.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DdupPptcontentEntityPK implements Serializable {
    private String ddupPptNo;
    private int ddupPptPageNum;

    @Column(name = "ddup_pptNo")
    @Id
    public String getDdupPptNo() {
        return ddupPptNo;
    }

    public void setDdupPptNo(String ddupPptNo) {
        this.ddupPptNo = ddupPptNo;
    }

    @Column(name = "ddup_pptPageNum")
    @Id
    public int getDdupPptPageNum() {
        return ddupPptPageNum;
    }

    public void setDdupPptPageNum(int ddupPptPageNum) {
        this.ddupPptPageNum = ddupPptPageNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DdupPptcontentEntityPK that = (DdupPptcontentEntityPK) o;

        if (ddupPptPageNum != that.ddupPptPageNum) return false;
        if (ddupPptNo != null ? !ddupPptNo.equals(that.ddupPptNo) : that.ddupPptNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ddupPptNo != null ? ddupPptNo.hashCode() : 0;
        result = 31 * result + ddupPptPageNum;
        return result;
    }
}
