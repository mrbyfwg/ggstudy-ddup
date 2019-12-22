package com.bean;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ddup_pptmanage", schema = "ddupmis", catalog = "")
public class DdupPptmanageEntity {
    private String ddupPptNo;
    private String ddupName;
    private Integer ddupPptPageNum;
    private Integer ddupPptDownloadNum;
    private Collection<DdupPptstudentcontentEntity> ddupPptstudentcontentsByDdupPptNo;
    private Collection<DdupPptteachercontenthardEntity> ddupPptteachercontenthardsByDdupPptNo;
    private Collection<DdupPptteachercontentimportantEntity> ddupPptteachercontentimportantsByDdupPptNo;
    private Collection<DdupPptteachercontentimportanthardEntity> ddupPptteachercontentimportanthardsByDdupPptNo;

    @Id
    @Column(name = "ddup_pptNo")
    public String getDdupPptNo() {
        return ddupPptNo;
    }

    public void setDdupPptNo(String ddupPptNo) {
        this.ddupPptNo = ddupPptNo;
    }

    @Basic
    @Column(name = "ddup_name")
    public String getDdupName() {
        return ddupName;
    }

    public void setDdupName(String ddupName) {
        this.ddupName = ddupName;
    }

    @Basic
    @Column(name = "ddup_pptPageNum")
    public Integer getDdupPptPageNum() {
        return ddupPptPageNum;
    }

    public void setDdupPptPageNum(Integer ddupPptPageNum) {
        this.ddupPptPageNum = ddupPptPageNum;
    }

    @Basic
    @Column(name = "ddup_pptDownloadNum")
    public Integer getDdupPptDownloadNum() {
        return ddupPptDownloadNum;
    }

    public void setDdupPptDownloadNum(Integer ddupPptDownloadNum) {
        this.ddupPptDownloadNum = ddupPptDownloadNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DdupPptmanageEntity that = (DdupPptmanageEntity) o;

        if (ddupPptNo != null ? !ddupPptNo.equals(that.ddupPptNo) : that.ddupPptNo != null) return false;
        if (ddupName != null ? !ddupName.equals(that.ddupName) : that.ddupName != null) return false;
        if (ddupPptPageNum != null ? !ddupPptPageNum.equals(that.ddupPptPageNum) : that.ddupPptPageNum != null)
            return false;
        if (ddupPptDownloadNum != null ? !ddupPptDownloadNum.equals(that.ddupPptDownloadNum) : that.ddupPptDownloadNum != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ddupPptNo != null ? ddupPptNo.hashCode() : 0;
        result = 31 * result + (ddupName != null ? ddupName.hashCode() : 0);
        result = 31 * result + (ddupPptPageNum != null ? ddupPptPageNum.hashCode() : 0);
        result = 31 * result + (ddupPptDownloadNum != null ? ddupPptDownloadNum.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ddupPptmanageByDdupPptNo")
    public Collection<DdupPptstudentcontentEntity> getDdupPptstudentcontentsByDdupPptNo() {
        return ddupPptstudentcontentsByDdupPptNo;
    }

    public void setDdupPptstudentcontentsByDdupPptNo(Collection<DdupPptstudentcontentEntity> ddupPptstudentcontentsByDdupPptNo) {
        this.ddupPptstudentcontentsByDdupPptNo = ddupPptstudentcontentsByDdupPptNo;
    }

    @OneToMany(mappedBy = "ddupPptmanageByDdupPptNo")
    public Collection<DdupPptteachercontenthardEntity> getDdupPptteachercontenthardsByDdupPptNo() {
        return ddupPptteachercontenthardsByDdupPptNo;
    }

    public void setDdupPptteachercontenthardsByDdupPptNo(Collection<DdupPptteachercontenthardEntity> ddupPptteachercontenthardsByDdupPptNo) {
        this.ddupPptteachercontenthardsByDdupPptNo = ddupPptteachercontenthardsByDdupPptNo;
    }

    @OneToMany(mappedBy = "ddupPptmanageByDdupPptNo")
    public Collection<DdupPptteachercontentimportantEntity> getDdupPptteachercontentimportantsByDdupPptNo() {
        return ddupPptteachercontentimportantsByDdupPptNo;
    }

    public void setDdupPptteachercontentimportantsByDdupPptNo(Collection<DdupPptteachercontentimportantEntity> ddupPptteachercontentimportantsByDdupPptNo) {
        this.ddupPptteachercontentimportantsByDdupPptNo = ddupPptteachercontentimportantsByDdupPptNo;
    }

    @OneToMany(mappedBy = "ddupPptmanageByDdupPptNo")
    public Collection<DdupPptteachercontentimportanthardEntity> getDdupPptteachercontentimportanthardsByDdupPptNo() {
        return ddupPptteachercontentimportanthardsByDdupPptNo;
    }

    public void setDdupPptteachercontentimportanthardsByDdupPptNo(Collection<DdupPptteachercontentimportanthardEntity> ddupPptteachercontentimportanthardsByDdupPptNo) {
        this.ddupPptteachercontentimportanthardsByDdupPptNo = ddupPptteachercontentimportanthardsByDdupPptNo;
    }
}
