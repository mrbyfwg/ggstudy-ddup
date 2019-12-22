package com.bean;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ddup_major", schema = "ddupmis", catalog = "")
public class DdupMajorEntity {
    private int ddupId;
    private String ddupName;
    private Collection<DdupClassEntity> ddupClassesByDdupId;

    @Id
    @Column(name = "ddup_id")
    public int getDdupId() {
        return ddupId;
    }

    public void setDdupId(int ddupId) {
        this.ddupId = ddupId;
    }

    @Basic
    @Column(name = "ddup_name")
    public String getDdupName() {
        return ddupName;
    }

    public void setDdupName(String ddupName) {
        this.ddupName = ddupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DdupMajorEntity that = (DdupMajorEntity) o;

        if (ddupId != that.ddupId) return false;
        if (ddupName != null ? !ddupName.equals(that.ddupName) : that.ddupName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ddupId;
        result = 31 * result + (ddupName != null ? ddupName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ddupMajorByDdupMajor")
    public Collection<DdupClassEntity> getDdupClassesByDdupId() {
        return ddupClassesByDdupId;
    }

    public void setDdupClassesByDdupId(Collection<DdupClassEntity> ddupClassesByDdupId) {
        this.ddupClassesByDdupId = ddupClassesByDdupId;
    }
}
