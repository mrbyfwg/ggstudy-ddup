package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "ddup_teachbuilding", schema = "ddupmis", catalog = "")
public class DdupTeachbuildingEntity {
    private String ddupTeachBuildingId;
    private String ddupTeachBuildingName;

    @Id
    @Column(name = "ddup_teachBuildingID")
    public String getDdupTeachBuildingId() {
        return ddupTeachBuildingId;
    }

    public void setDdupTeachBuildingId(String ddupTeachBuildingId) {
        this.ddupTeachBuildingId = ddupTeachBuildingId;
    }

    @Basic
    @Column(name = "ddup_teachBuildingName")
    public String getDdupTeachBuildingName() {
        return ddupTeachBuildingName;
    }

    public void setDdupTeachBuildingName(String ddupTeachBuildingName) {
        this.ddupTeachBuildingName = ddupTeachBuildingName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DdupTeachbuildingEntity that = (DdupTeachbuildingEntity) o;

        if (ddupTeachBuildingId != null ? !ddupTeachBuildingId.equals(that.ddupTeachBuildingId) : that.ddupTeachBuildingId != null)
        {
            return false;
        }
        if (ddupTeachBuildingName != null ? !ddupTeachBuildingName.equals(that.ddupTeachBuildingName) : that.ddupTeachBuildingName != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = ddupTeachBuildingId != null ? ddupTeachBuildingId.hashCode() : 0;
        result = 31 * result + (ddupTeachBuildingName != null ? ddupTeachBuildingName.hashCode() : 0);
        return result;
    }
}
