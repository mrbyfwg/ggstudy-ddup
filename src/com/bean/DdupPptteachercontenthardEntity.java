package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "ddup_pptteachercontenthard", schema = "ddupmis", catalog = "")
@IdClass(DdupPptteachercontenthardEntityPK.class)
public class DdupPptteachercontenthardEntity {
    private String ddupTno;
    private String ddupPptNo;
    private Integer ddupPptPageNum;
    private DdupTeacherEntity ddupTeacherByDdupTno;
    private DdupPptmanageEntity ddupPptmanageByDdupPptNo;

    @Id
    @Basic
    @Column(name = "ddup_tno")
    public String getDdupTno() {
        return ddupTno;
    }

    public void setDdupTno(String ddupTno) {
        this.ddupTno = ddupTno;
    }

    @Id
    @Basic
    @Column(name = "ddup_pptNo")
    public String getDdupPptNo() {
        return ddupPptNo;
    }

    public void setDdupPptNo(String ddupPptNo) {
        this.ddupPptNo = ddupPptNo;
    }

    @Id
    @Basic
    @Column(name = "ddup_pptPageNum")
    public Integer getDdupPptPageNum() {
        return ddupPptPageNum;
    }

    public void setDdupPptPageNum(int ddupPptPageNum) {
        this.ddupPptPageNum = ddupPptPageNum;
    }

    public void setDdupPptPageNum(Integer ddupPptPageNum) {
        this.ddupPptPageNum = ddupPptPageNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DdupPptteachercontenthardEntity that = (DdupPptteachercontenthardEntity) o;

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

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "ddup_tno", referencedColumnName = "ddup_Tno"), @JoinColumn(name = "ddup_tno", referencedColumnName = "ddup_Tno", nullable = false)})
    public DdupTeacherEntity getDdupTeacherByDdupTno() {
        return ddupTeacherByDdupTno;
    }

    public void setDdupTeacherByDdupTno(DdupTeacherEntity ddupTeacherByDdupTno) {
        this.ddupTeacherByDdupTno = ddupTeacherByDdupTno;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "ddup_pptNo", referencedColumnName = "ddup_pptNo"), @JoinColumn(name = "ddup_pptNo", referencedColumnName = "ddup_pptNo", nullable = false)})
    public DdupPptmanageEntity getDdupPptmanageByDdupPptNo() {
        return ddupPptmanageByDdupPptNo;
    }

    public void setDdupPptmanageByDdupPptNo(DdupPptmanageEntity ddupPptmanageByDdupPptNo) {
        this.ddupPptmanageByDdupPptNo = ddupPptmanageByDdupPptNo;
    }
}
