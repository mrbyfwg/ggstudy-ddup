package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "ddup_pptstudentcontent", schema = "ddupmis", catalog = "")
@IdClass(DdupPptstudentcontentEntityPK.class)
public class DdupPptstudentcontentEntity {
    private String ddupSno;
    private String ddupPptNo;
    private int ddupPptPageNum;
    private DdupStudentEntity ddupStudentByDdupSno;
    private DdupPptmanageEntity ddupPptmanageByDdupPptNo;

    @Id
    @Column(name = "ddup_sno")
    public String getDdupSno() {
        return ddupSno;
    }

    public void setDdupSno(String ddupSno) {
        this.ddupSno = ddupSno;
    }

    @Id
    @Column(name = "ddup_pptNo")
    public String getDdupPptNo() {
        return ddupPptNo;
    }

    public void setDdupPptNo(String ddupPptNo) {
        this.ddupPptNo = ddupPptNo;
    }

    @Id
    @Column(name = "ddup_pptPageNum")
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

        DdupPptstudentcontentEntity that = (DdupPptstudentcontentEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "ddup_sno", referencedColumnName = "ddup_Sno", nullable = false)
    public DdupStudentEntity getDdupStudentByDdupSno() {
        return ddupStudentByDdupSno;
    }

    public void setDdupStudentByDdupSno(DdupStudentEntity ddupStudentByDdupSno) {
        this.ddupStudentByDdupSno = ddupStudentByDdupSno;
    }

    @ManyToOne
    @JoinColumn(name = "ddup_pptNo", referencedColumnName = "ddup_pptNo", nullable = false)
    public DdupPptmanageEntity getDdupPptmanageByDdupPptNo() {
        return ddupPptmanageByDdupPptNo;
    }

    public void setDdupPptmanageByDdupPptNo(DdupPptmanageEntity ddupPptmanageByDdupPptNo) {
        this.ddupPptmanageByDdupPptNo = ddupPptmanageByDdupPptNo;
    }
}
