package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "ddup_teacherpasswordmanage", schema = "ddupmis", catalog = "")
public class DdupTeacherpasswordmanageEntity {
    private String ddupTno;
    private String ddupPassword;

    @Id
    @Column(name = "ddup_tno")
    public String getDdupTno() {
        return ddupTno;
    }

    public void setDdupTno(String ddupTno) {
        this.ddupTno = ddupTno;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DdupTeacherpasswordmanageEntity that = (DdupTeacherpasswordmanageEntity) o;

        if (ddupTno != null ? !ddupTno.equals(that.ddupTno) : that.ddupTno != null){
            return false;
        }
        if (ddupPassword != null ? !ddupPassword.equals(that.ddupPassword) : that.ddupPassword != null){
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = ddupTno != null ? ddupTno.hashCode() : 0;
        result = 31 * result + (ddupPassword != null ? ddupPassword.hashCode() : 0);
        return result;
    }
}
