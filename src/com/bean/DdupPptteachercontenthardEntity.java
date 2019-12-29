package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "ddup_pptteachercontenthard", schema = "ddupmis", catalog = "")
public class DdupPptteachercontenthardEntity {
    private String ddupTno;
    private String ddupPptNo;
    private int ddupPptPageNum;

    @Id
    @Column(name = "ddup_tno")
    public String getDdupTno() {
        return ddupTno;
    }

    public void setDdupTno(String ddupTno) {
        this.ddupTno = ddupTno;
    }

    @Basic
    @Column(name = "ddup_pptNo")
    public String getDdupPptNo() {
        return ddupPptNo;
    }

    public void setDdupPptNo(String ddupPptNo) {
        this.ddupPptNo = ddupPptNo;
    }

    @Basic
    @Column(name = "ddup_pptPageNum")
    public int getDdupPptPageNum() {
        return ddupPptPageNum;
    }

    public void setDdupPptPageNum(int ddupPptPageNum) {
        this.ddupPptPageNum = ddupPptPageNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DdupPptteachercontenthardEntity that = (DdupPptteachercontenthardEntity) o;

        if (ddupPptPageNum != that.ddupPptPageNum) {
            return false;
        }
        if (ddupTno != null ? !ddupTno.equals(that.ddupTno) : that.ddupTno != null){
            return false;
        }
        if (ddupPptNo != null ? !ddupPptNo.equals(that.ddupPptNo) : that.ddupPptNo != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = ddupTno != null ? ddupTno.hashCode() : 0;
        result = 31 * result + (ddupPptNo != null ? ddupPptNo.hashCode() : 0);
        result = 31 * result + ddupPptPageNum;
        return result;
    }
}
