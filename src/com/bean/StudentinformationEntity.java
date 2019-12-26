package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "studentinformation", schema = "ddupmis", catalog = "")
public class StudentinformationEntity {
    private String ddupSno;
    private String ddupName;
    private String ddupMajor;
    private String ddupClass;
    private String ddupSex;
    private Integer ddupAge;
    private String ddupOriginPlace;

    @Id
    @Column(name = "ddup_Sno")
    public String getDdupSno() {
        return ddupSno;
    }

    public void setDdupSno(String ddupSno) {
        this.ddupSno = ddupSno;
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
    public String getDdupMajor() {
        return ddupMajor;
    }

    public void setDdupMajor(String ddupMajor) {
        this.ddupMajor = ddupMajor;
    }

    @Basic
    @Column(name = "ddup_class")
    public String getDdupClass() {
        return ddupClass;
    }

    public void setDdupClass(String ddupClass) {
        this.ddupClass = ddupClass;
    }

    @Basic
    @Column(name = "ddup_sex")
    public String getDdupSex() {
        return ddupSex;
    }

    public void setDdupSex(String ddupSex) {
        this.ddupSex = ddupSex;
    }

    @Basic
    @Column(name = "ddup_age")
    public Integer getDdupAge() {
        return ddupAge;
    }

    public void setDdupAge(Integer ddupAge) {
        this.ddupAge = ddupAge;
    }

    @Basic
    @Column(name = "ddup_originPlace")
    public String getDdupOriginPlace() {
        return ddupOriginPlace;
    }

    public void setDdupOriginPlace(String ddupOriginPlace) {
        this.ddupOriginPlace = ddupOriginPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentinformationEntity that = (StudentinformationEntity) o;

        if (ddupSno != null ? !ddupSno.equals(that.ddupSno) : that.ddupSno != null) return false;
        if (ddupName != null ? !ddupName.equals(that.ddupName) : that.ddupName != null) return false;
        if (ddupMajor != null ? !ddupMajor.equals(that.ddupMajor) : that.ddupMajor != null) return false;
        if (ddupClass != null ? !ddupClass.equals(that.ddupClass) : that.ddupClass != null) return false;
        if (ddupSex != null ? !ddupSex.equals(that.ddupSex) : that.ddupSex != null) return false;
        if (ddupAge != null ? !ddupAge.equals(that.ddupAge) : that.ddupAge != null) return false;
        if (ddupOriginPlace != null ? !ddupOriginPlace.equals(that.ddupOriginPlace) : that.ddupOriginPlace != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ddupSno != null ? ddupSno.hashCode() : 0;
        result = 31 * result + (ddupName != null ? ddupName.hashCode() : 0);
        result = 31 * result + (ddupMajor != null ? ddupMajor.hashCode() : 0);
        result = 31 * result + (ddupClass != null ? ddupClass.hashCode() : 0);
        result = 31 * result + (ddupSex != null ? ddupSex.hashCode() : 0);
        result = 31 * result + (ddupAge != null ? ddupAge.hashCode() : 0);
        result = 31 * result + (ddupOriginPlace != null ? ddupOriginPlace.hashCode() : 0);
        return result;
    }
}
