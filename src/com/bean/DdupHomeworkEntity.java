package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "ddup_homework", schema = "ddupmis", catalog = "")
public class DdupHomeworkEntity {
    private String ddupHomeworkNum;
    private String ddupCno;
    private String ddupHomeworkName;
    private String ddupStartTime;
    private String ddupEndTime;
    private Integer ddupSubmitNum;
    private DdupCourseEntity ddupCourseByDdupCno;

    @Id
    @Column(name = "ddup_homeworkNum")
    public String getDdupHomeworkNum() {
        return ddupHomeworkNum;
    }

    public void setDdupHomeworkNum(String ddupHomeworkNum) {
        this.ddupHomeworkNum = ddupHomeworkNum;
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
    @Column(name = "ddup_homeworkName")
    public String getDdupHomeworkName() {
        return ddupHomeworkName;
    }

    public void setDdupHomeworkName(String ddupHomeworkName) {
        this.ddupHomeworkName = ddupHomeworkName;
    }

    @Basic
    @Column(name = "ddup_startTime")
    public String getDdupStartTime() {
        return ddupStartTime;
    }

    public void setDdupStartTime(String ddupStartTime) {
        this.ddupStartTime = ddupStartTime;
    }

    @Basic
    @Column(name = "ddup_endTime")
    public String getDdupEndTime() {
        return ddupEndTime;
    }

    public void setDdupEndTime(String ddupEndTime) {
        this.ddupEndTime = ddupEndTime;
    }

    @Basic
    @Column(name = "ddup_submitNum")
    public Integer getDdupSubmitNum() {
        return ddupSubmitNum;
    }

    public void setDdupSubmitNum(Integer ddupSubmitNum) {
        this.ddupSubmitNum = ddupSubmitNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        DdupHomeworkEntity that = (DdupHomeworkEntity) o;

        if (ddupHomeworkNum != null ? !ddupHomeworkNum.equals(that.ddupHomeworkNum) : that.ddupHomeworkNum != null)
        {
            return false;
        }
        if (ddupCno != null ? !ddupCno.equals(that.ddupCno) : that.ddupCno != null) {
            return false;
        }
        if (ddupHomeworkName != null ? !ddupHomeworkName.equals(that.ddupHomeworkName) : that.ddupHomeworkName != null)
        {
            return false;
        }
        if (ddupStartTime != null ? !ddupStartTime.equals(that.ddupStartTime) : that.ddupStartTime != null)
        {
            return false;
        }
        if (ddupEndTime != null ? !ddupEndTime.equals(that.ddupEndTime) : that.ddupEndTime != null) {
            return false;
        }
        if (ddupSubmitNum != null ? !ddupSubmitNum.equals(that.ddupSubmitNum) : that.ddupSubmitNum != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = ddupHomeworkNum != null ? ddupHomeworkNum.hashCode() : 0;
        result = 31 * result + (ddupCno != null ? ddupCno.hashCode() : 0);
        result = 31 * result + (ddupHomeworkName != null ? ddupHomeworkName.hashCode() : 0);
        result = 31 * result + (ddupStartTime != null ? ddupStartTime.hashCode() : 0);
        result = 31 * result + (ddupEndTime != null ? ddupEndTime.hashCode() : 0);
        result = 31 * result + (ddupSubmitNum != null ? ddupSubmitNum.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ddup_Cno", referencedColumnName = "ddup_Cno")
    public DdupCourseEntity getDdupCourseByDdupCno() {
        return ddupCourseByDdupCno;
    }

    public void setDdupCourseByDdupCno(DdupCourseEntity ddupCourseByDdupCno) {
        this.ddupCourseByDdupCno = ddupCourseByDdupCno;
    }
}
