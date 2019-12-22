package com.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DdupPptstudentcontentEntityPK implements Serializable {
    private String ddupSno;
    private String ddupPptNo;
    private int ddupPptPageNum;

    @Column(name = "ddup_sno")
    @Id
    public String getDdupSno() {
        return ddupSno;
    }

    public void setDdupSno(String ddupSno) {
        this.ddupSno = ddupSno;
    }

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

        DdupPptstudentcontentEntityPK that = (DdupPptstudentcontentEntityPK) o;

        if (ddupPptPageNum != that.ddupPptPageNum) return false;
        if (ddupSno != null ? !ddupSno.equals(that.ddupSno) : that.ddupSno != null) return false;
        if (ddupPptNo != null ? !ddupPptNo.equals(that.ddupPptNo) : that.ddupPptNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ddupSno != null ? ddupSno.hashCode() : 0;
        result = 31 * result + (ddupPptNo != null ? ddupPptNo.hashCode() : 0);
        result = 31 * result + ddupPptPageNum;
        return result;
    }
}
