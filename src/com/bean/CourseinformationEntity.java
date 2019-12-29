package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "courseinformation", schema = "ddupmis", catalog = "")
public class CourseinformationEntity {
    private String ddupCourseName;
    private String ddupCno;
    private String ddupTeacherName;
    private String ddupTno;
    private String ddupClassno;
    private String ddupPeriod;
    private Integer ddupLearnTime;
    private String ddupTestMethod;
    private Integer ddupCredit;
    private String ddupTeachRoomId;
    private String ddupTeachBuildingName;

    @Id
    @Column(name = "ddup_courseName")
    public String getDdupCourseName() {
        return ddupCourseName;
    }

    public void setDdupCourseName(String ddupCourseName) {
        this.ddupCourseName = ddupCourseName;
    }

    @Basic
    @Column(name = "ddup_Cno")
    public String getDdupCno() {
        return ddupCno;
    }

    public void setDdupCno(String ddupCno) {
        this.ddupCno = ddupCno;
    }

    @Basic
    @Column(name = "ddup_teacherName")
    public String getDdupTeacherName() {
        return ddupTeacherName;
    }

    public void setDdupTeacherName(String ddupTeacherName) {
        this.ddupTeacherName = ddupTeacherName;
    }

    @Basic
    @Column(name = "ddup_Tno")
    public String getDdupTno() {
        return ddupTno;
    }

    public void setDdupTno(String ddupTno) {
        this.ddupTno = ddupTno;
    }

    @Basic
    @Column(name = "ddup_Classno")
    public String getDdupClassno() {
        return ddupClassno;
    }

    public void setDdupClassno(String ddupClassno) {
        this.ddupClassno = ddupClassno;
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

    @Basic
    @Column(name = "ddup_teachRoomID")
    public String getDdupTeachRoomId() {
        return ddupTeachRoomId;
    }

    public void setDdupTeachRoomId(String ddupTeachRoomId) {
        this.ddupTeachRoomId = ddupTeachRoomId;
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

        CourseinformationEntity that = (CourseinformationEntity) o;

        if (ddupCourseName != null ? !ddupCourseName.equals(that.ddupCourseName) : that.ddupCourseName != null)
        {
            return false;
        }
        if (ddupCno != null ? !ddupCno.equals(that.ddupCno) : that.ddupCno != null) {
            return false;
        }
        if (ddupTeacherName != null ? !ddupTeacherName.equals(that.ddupTeacherName) : that.ddupTeacherName != null)
        {
            return false;
        }
        if (ddupTno != null ? !ddupTno.equals(that.ddupTno) : that.ddupTno != null){
            return false;
        }
        if (ddupClassno != null ? !ddupClassno.equals(that.ddupClassno) : that.ddupClassno != null) {
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
        if (ddupCredit != null ? !ddupCredit.equals(that.ddupCredit) : that.ddupCredit != null){
            return false;
        }
        if (ddupTeachRoomId != null ? !ddupTeachRoomId.equals(that.ddupTeachRoomId) : that.ddupTeachRoomId != null)
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
        int result = ddupCourseName != null ? ddupCourseName.hashCode() : 0;
        result = 31 * result + (ddupCno != null ? ddupCno.hashCode() : 0);
        result = 31 * result + (ddupTeacherName != null ? ddupTeacherName.hashCode() : 0);
        result = 31 * result + (ddupTno != null ? ddupTno.hashCode() : 0);
        result = 31 * result + (ddupClassno != null ? ddupClassno.hashCode() : 0);
        result = 31 * result + (ddupPeriod != null ? ddupPeriod.hashCode() : 0);
        result = 31 * result + (ddupLearnTime != null ? ddupLearnTime.hashCode() : 0);
        result = 31 * result + (ddupTestMethod != null ? ddupTestMethod.hashCode() : 0);
        result = 31 * result + (ddupCredit != null ? ddupCredit.hashCode() : 0);
        result = 31 * result + (ddupTeachRoomId != null ? ddupTeachRoomId.hashCode() : 0);
        result = 31 * result + (ddupTeachBuildingName != null ? ddupTeachBuildingName.hashCode() : 0);
        return result;
    }
}
