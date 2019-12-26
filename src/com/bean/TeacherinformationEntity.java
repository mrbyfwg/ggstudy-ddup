package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "teacherinformation", schema = "ddupmis", catalog = "")
public class TeacherinformationEntity {
    private String ddupTno;
    private String ddupName;
    private String ddupSex;
    private Integer ddupAge;
    private String ddupPhone;
    private String ddupTitle;
    private String ddupPassword;

    @Id
    @Column(name = "ddup_Tno")
    public String getDdupTno() {
        return ddupTno;
    }

    public void setDdupTno(String ddupTno) {
        this.ddupTno = ddupTno;
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
    @Column(name = "ddup_phone")
    public String getDdupPhone() {
        return ddupPhone;
    }

    public void setDdupPhone(String ddupPhone) {
        this.ddupPhone = ddupPhone;
    }

    @Basic
    @Column(name = "ddup_title")
    public String getDdupTitle() {
        return ddupTitle;
    }

    public void setDdupTitle(String ddupTitle) {
        this.ddupTitle = ddupTitle;
    }

    @Basic
    @Column(name = "ddup_password")
    public String getDdupPassword() {
        return ddupPassword;
    }

    public void setDdupPassword(String ddupPassword) {
        this.ddupPassword = ddupPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherinformationEntity that = (TeacherinformationEntity) o;

        if (ddupTno != null ? !ddupTno.equals(that.ddupTno) : that.ddupTno != null) return false;
        if (ddupName != null ? !ddupName.equals(that.ddupName) : that.ddupName != null) return false;
        if (ddupSex != null ? !ddupSex.equals(that.ddupSex) : that.ddupSex != null) return false;
        if (ddupAge != null ? !ddupAge.equals(that.ddupAge) : that.ddupAge != null) return false;
        if (ddupPhone != null ? !ddupPhone.equals(that.ddupPhone) : that.ddupPhone != null) return false;
        if (ddupTitle != null ? !ddupTitle.equals(that.ddupTitle) : that.ddupTitle != null) return false;
        if (ddupPassword != null ? !ddupPassword.equals(that.ddupPassword) : that.ddupPassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ddupTno != null ? ddupTno.hashCode() : 0;
        result = 31 * result + (ddupName != null ? ddupName.hashCode() : 0);
        result = 31 * result + (ddupSex != null ? ddupSex.hashCode() : 0);
        result = 31 * result + (ddupAge != null ? ddupAge.hashCode() : 0);
        result = 31 * result + (ddupPhone != null ? ddupPhone.hashCode() : 0);
        result = 31 * result + (ddupTitle != null ? ddupTitle.hashCode() : 0);
        result = 31 * result + (ddupPassword != null ? ddupPassword.hashCode() : 0);
        return result;
    }
}
