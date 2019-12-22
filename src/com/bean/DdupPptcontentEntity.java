package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "ddup_pptcontent", schema = "ddupmis", catalog = "")
@IdClass(DdupPptcontentEntityPK.class)
public class DdupPptcontentEntity {
    private String ddupPptNo;
    private int ddupPptPageNum;
    private Integer ddupPptImportant;
    private Integer ddupPptHard;
    private Integer ddupPptImportantHard;
    private Integer ddupPptQuestionNum;

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

    @Basic
    @Column(name = "ddup_pptImportant")
    public Integer getDdupPptImportant() {
        return ddupPptImportant;
    }

    public void setDdupPptImportant(Integer ddupPptImportant) {
        this.ddupPptImportant = ddupPptImportant;
    }

    @Basic
    @Column(name = "ddup_pptHard")
    public Integer getDdupPptHard() {
        return ddupPptHard;
    }

    public void setDdupPptHard(Integer ddupPptHard) {
        this.ddupPptHard = ddupPptHard;
    }

    @Basic
    @Column(name = "ddup_pptImportantHard")
    public Integer getDdupPptImportantHard() {
        return ddupPptImportantHard;
    }

    public void setDdupPptImportantHard(Integer ddupPptImportantHard) {
        this.ddupPptImportantHard = ddupPptImportantHard;
    }

    @Basic
    @Column(name = "ddup_pptQuestionNum")
    public Integer getDdupPptQuestionNum() {
        return ddupPptQuestionNum;
    }

    public void setDdupPptQuestionNum(Integer ddupPptQuestionNum) {
        this.ddupPptQuestionNum = ddupPptQuestionNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DdupPptcontentEntity that = (DdupPptcontentEntity) o;

        if (ddupPptPageNum != that.ddupPptPageNum) return false;
        if (ddupPptNo != null ? !ddupPptNo.equals(that.ddupPptNo) : that.ddupPptNo != null) return false;
        if (ddupPptImportant != null ? !ddupPptImportant.equals(that.ddupPptImportant) : that.ddupPptImportant != null)
            return false;
        if (ddupPptHard != null ? !ddupPptHard.equals(that.ddupPptHard) : that.ddupPptHard != null) return false;
        if (ddupPptImportantHard != null ? !ddupPptImportantHard.equals(that.ddupPptImportantHard) : that.ddupPptImportantHard != null)
            return false;
        if (ddupPptQuestionNum != null ? !ddupPptQuestionNum.equals(that.ddupPptQuestionNum) : that.ddupPptQuestionNum != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ddupPptNo != null ? ddupPptNo.hashCode() : 0;
        result = 31 * result + ddupPptPageNum;
        result = 31 * result + (ddupPptImportant != null ? ddupPptImportant.hashCode() : 0);
        result = 31 * result + (ddupPptHard != null ? ddupPptHard.hashCode() : 0);
        result = 31 * result + (ddupPptImportantHard != null ? ddupPptImportantHard.hashCode() : 0);
        result = 31 * result + (ddupPptQuestionNum != null ? ddupPptQuestionNum.hashCode() : 0);
        return result;
    }
}
