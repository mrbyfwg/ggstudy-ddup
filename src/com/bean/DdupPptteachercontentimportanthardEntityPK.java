package com.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DdupPptteachercontentimportanthardEntityPK implements Serializable {
    private String ddupTno;
    private String ddupPptNo;
    private Integer ddupPptPageNum;

    @Column(name = "ddup_tno")
    @Basic
    @Id
    public String getDdupTno() {
        return ddupTno;
    }

    public void setDdupTno(String ddupTno) {
        this.ddupTno = ddupTno;
    }

    @Column(name = "ddup_pptNo")
    @Basic
    @Id
    public String getDdupPptNo() {
        return ddupPptNo;
    }

    public void setDdupPptNo(String ddupPptNo) {
        this.ddupPptNo = ddupPptNo;
    }

    @Column(name = "ddup_pptPageNum")
    @Basic
    @Id
    public Integer getDdupPptPageNum() {
        return ddupPptPageNum;
    }

    public void setDdupPptPageNum(Integer ddupPptPageNum) {
        this.ddupPptPageNum = ddupPptPageNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DdupPptteachercontentimportanthardEntityPK that = (DdupPptteachercontentimportanthardEntityPK) o;

        if (ddupTno != null ? !ddupTno.equals(that.ddupTno) : that.ddupTno != null) return false;
        if (ddupPptNo != null ? !ddupPptNo.equals(that.ddupPptNo) : that.ddupPptNo != null) return false;
        if (ddupPptPageNum != null ? !ddupPptPageNum.equals(that.ddupPptPageNum) : that.ddupPptPageNum != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ddupTno != null ? ddupTno.hashCode() : 0;
        result = 31 * result + (ddupPptNo != null ? ddupPptNo.hashCode() : 0);
        result = 31 * result + (ddupPptPageNum != null ? ddupPptPageNum.hashCode() : 0);
        return result;
    }
}
