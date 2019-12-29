package com.bean;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ddup_course", schema = "ddupmis", catalog = "")
public class DdupCourseEntity {
    private String ddupCno;
    private String ddupName;
    private String ddupPeriod;
    private Integer ddupLearnTime;
    private String ddupTestMethod;
    private Integer ddupCredit;
    private Collection<DdupHomeworkEntity> ddupHomeworksByDdupCno;
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
    @Column(name = "ddup_period")
    public String getDdupPeriod() {
        return ddupPeriod;
    }

    public void setDdupPeriod(String ddupPeriod) {
        this.ddupPeriod = ddupPeriod;
    }

    @Basic
    @Column(name = "ddup_learn_time")
    public Integer getDdupLearnTime() {
        return ddupLearnTime;
    }

    public void setDdupLearnTime(Integer ddupLearnTime) {
        this.ddupLearnTime = ddupLearnTime;
    }

    @Basic
    @Column(name = "ddup_test_method")
    public String getDdupTestMethod() {
        return ddupTestMethod;
    }

    public void setDdupTestMethod(String ddupTestMethod) {
        this.ddupTestMethod = ddupTestMethod;
    }

    @Basic
    @Column(name = "ddup_credit")
    public Integer getDdupCredit() {
        return ddupCredit;
    }

    public void setDdupCredit(Integer ddupCredit) {
        this.ddupCredit = ddupCredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        DdupCourseEntity that = (DdupCourseEntity) o;

        if (ddupCno != null ? !ddupCno.equals(that.ddupCno) : that.ddupCno != null) {
            return false;
        }
        if (ddupName != null ? !ddupName.equals(that.ddupName) : that.ddupName != null) {
            return false;
        }
        if (ddupPeriod != null ? !ddupPeriod.equals(that.ddupPeriod) : that.ddupPeriod != null) {
            return false;
        }
        if (ddupLearnTime != null ? !ddupLearnTime.equals(that.ddupLearnTime) : that.ddupLearnTime != null)
        {
            return false;
        }
        if (ddupTestMethod != null ? !ddupTestMethod.equals(that.ddupTestMethod) : that.ddupTestMethod != null)
        {
            return false;
        }
        if (ddupCredit != null ? !ddupCredit.equals(that.ddupCredit) : that.ddupCredit != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = ddupCno != null ? ddupCno.hashCode() : 0;
        result = 31 * result + (ddupName != null ? ddupName.hashCode() : 0);
        result = 31 * result + (ddupPeriod != null ? ddupPeriod.hashCode() : 0);
        result = 31 * result + (ddupLearnTime != null ? ddupLearnTime.hashCode() : 0);
        result = 31 * result + (ddupTestMethod != null ? ddupTestMethod.hashCode() : 0);
        result = 31 * result + (ddupCredit != null ? ddupCredit.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ddupCourseByDdupCno")
    public Collection<DdupHomeworkEntity> getDdupHomeworksByDdupCno() {
        return ddupHomeworksByDdupCno;
    }

    public void setDdupHomeworksByDdupCno(Collection<DdupHomeworkEntity> ddupHomeworksByDdupCno) {
        this.ddupHomeworksByDdupCno = ddupHomeworksByDdupCno;
    }

    @OneToMany(mappedBy = "ddupCourseByDdupCno")
    public Collection<DdupTeachEntity> getDdupTeachesByDdupCno() {
        return ddupTeachesByDdupCno;
    }

    public void setDdupTeachesByDdupCno(Collection<DdupTeachEntity> ddupTeachesByDdupCno) {
        this.ddupTeachesByDdupCno = ddupTeachesByDdupCno;
    }
}
