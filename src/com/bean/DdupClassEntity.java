package com.bean;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ddup_class", schema = "ddupmis", catalog = "")
public class DdupClassEntity {
    private String ddupCno;
    private String ddupName;
    private int ddupMajor;
    private DdupMajorEntity ddupMajorByDdupMajor;
    private Collection<DdupStudentEntity> ddupStudentsByDdupCno;
    private Collection<DdupTeachEntity> ddupTeachesByDdupCno;

    @Id
    @Column(name = "ddup_Cno")
    public String getDdupCno() {
        return ddupCno;
    }

    public void setDdupCno(String ddupCno) {
        this.ddupCno = ddupCno;
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
    @Column(name = "ddup_major")
    public int getDdupMajor() {
        return ddupMajor;
    }

    public void setDdupMajor(int ddupMajor) {
        this.ddupMajor = ddupMajor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        DdupClassEntity that = (DdupClassEntity) o;

        if (ddupMajor != that.ddupMajor) {
            return false;
        }
        if (ddupCno != null ? !ddupCno.equals(that.ddupCno) : that.ddupCno != null) {
            return false;
        }
        if (ddupName != null ? !ddupName.equals(that.ddupName) : that.ddupName != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = ddupCno != null ? ddupCno.hashCode() : 0;
        result = 31 * result + (ddupName != null ? ddupName.hashCode() : 0);
        result = 31 * result + ddupMajor;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ddup_major", referencedColumnName = "ddup_id", nullable = false)
    public DdupMajorEntity getDdupMajorByDdupMajor() {
        return ddupMajorByDdupMajor;
    }

    public void setDdupMajorByDdupMajor(DdupMajorEntity ddupMajorByDdupMajor) {
        this.ddupMajorByDdupMajor = ddupMajorByDdupMajor;
    }

    @OneToMany(mappedBy = "ddupClassByDdupClass")
    public Collection<DdupStudentEntity> getDdupStudentsByDdupCno() {
        return ddupStudentsByDdupCno;
    }

    public void setDdupStudentsByDdupCno(Collection<DdupStudentEntity> ddupStudentsByDdupCno) {
        this.ddupStudentsByDdupCno = ddupStudentsByDdupCno;
    }

    @OneToMany(mappedBy = "ddupClassByDdupClassno")
    public Collection<DdupTeachEntity> getDdupTeachesByDdupCno() {
        return ddupTeachesByDdupCno;
    }

    public void setDdupTeachesByDdupCno(Collection<DdupTeachEntity> ddupTeachesByDdupCno) {
        this.ddupTeachesByDdupCno = ddupTeachesByDdupCno;
    }
}
