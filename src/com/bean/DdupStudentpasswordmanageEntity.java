package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "ddup_studentpasswordmanage", schema = "ddupmis", catalog = "")
public class DdupStudentpasswordmanageEntity {
    private String ddupSno;
    private String ddupPassword;

    @Id
    @Column(name = "ddup_sno")
    public String getDdupSno() {
        return ddupSno;
    }

    public void setDdupSno(String ddupSno) {
        this.ddupSno = ddupSno;
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

        DdupStudentpasswordmanageEntity that = (DdupStudentpasswordmanageEntity) o;

        if (ddupSno != null ? !ddupSno.equals(that.ddupSno) : that.ddupSno != null) return false;
        if (ddupPassword != null ? !ddupPassword.equals(that.ddupPassword) : that.ddupPassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ddupSno != null ? ddupSno.hashCode() : 0;
        result = 31 * result + (ddupPassword != null ? ddupPassword.hashCode() : 0);
        return result;
    }
}
