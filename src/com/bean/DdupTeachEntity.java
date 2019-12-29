package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "ddup_teach", schema = "ddupmis", catalog = "")
@IdClass(DdupTeachEntityPK.class)
public class DdupTeachEntity {
    private String ddupTno;
    private String ddupCno;
    private String ddupClassno;
    private String ddupTeachRoomId;
    private String ddupTeachBuildingId;
    private DdupTeacherEntity ddupTeacherByDdupTno;
    private DdupCourseEntity ddupCourseByDdupCno;
    private DdupClassEntity ddupClassByDdupClassno;

    @Id
    @Column(name = "ddup_Tno")
    public String getDdupTno() {
        return ddupTno;
    }

    public void setDdupTno(String ddupTno) {
        this.ddupTno = ddupTno;
    }

    @Id
    @Column(name = "ddup_Cno")
    public String getDdupCno() {
        return ddupCno;
    }

    public void setDdupCno(String ddupCno) {
        this.ddupCno = ddupCno;
    }

    @Id
    @Column(name = "ddup_Classno")
    public String getDdupClassno() {
        return ddupClassno;
    }

    public void setDdupClassno(String ddupClassno) {
        this.ddupClassno = ddupClassno;
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
    @Column(name = "ddup_teachBuildingID")
    public String getDdupTeachBuildingId() {
        return ddupTeachBuildingId;
    }

    public void setDdupTeachBuildingId(String ddupTeachBuildingId) {
        this.ddupTeachBuildingId = ddupTeachBuildingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DdupTeachEntity that = (DdupTeachEntity) o;

        if (ddupTno != null ? !ddupTno.equals(that.ddupTno) : that.ddupTno != null) {
            return false;
        }
        if (ddupCno != null ? !ddupCno.equals(that.ddupCno) : that.ddupCno != null){
            return false;
        }
        if (ddupClassno != null ? !ddupClassno.equals(that.ddupClassno) : that.ddupClassno != null) {
            return false;
        }
        if (ddupTeachRoomId != null ? !ddupTeachRoomId.equals(that.ddupTeachRoomId) : that.ddupTeachRoomId != null)
        {
            return false;
        }
        if (ddupTeachBuildingId != null ? !ddupTeachBuildingId.equals(that.ddupTeachBuildingId) : that.ddupTeachBuildingId != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = ddupTno != null ? ddupTno.hashCode() : 0;
        result = 31 * result + (ddupCno != null ? ddupCno.hashCode() : 0);
        result = 31 * result + (ddupClassno != null ? ddupClassno.hashCode() : 0);
        result = 31 * result + (ddupTeachRoomId != null ? ddupTeachRoomId.hashCode() : 0);
        result = 31 * result + (ddupTeachBuildingId != null ? ddupTeachBuildingId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ddup_Tno", referencedColumnName = "ddup_Tno", nullable = false)
    public DdupTeacherEntity getDdupTeacherByDdupTno() {
        return ddupTeacherByDdupTno;
    }

    public void setDdupTeacherByDdupTno(DdupTeacherEntity ddupTeacherByDdupTno) {
        this.ddupTeacherByDdupTno = ddupTeacherByDdupTno;
    }

    @ManyToOne
    @JoinColumn(name = "ddup_Cno", referencedColumnName = "ddup_Cno", nullable = false)
    public DdupCourseEntity getDdupCourseByDdupCno() {
        return ddupCourseByDdupCno;
    }

    public void setDdupCourseByDdupCno(DdupCourseEntity ddupCourseByDdupCno) {
        this.ddupCourseByDdupCno = ddupCourseByDdupCno;
    }

    @ManyToOne
    @JoinColumn(name = "ddup_Classno", referencedColumnName = "ddup_Cno", nullable = false)
    public DdupClassEntity getDdupClassByDdupClassno() {
        return ddupClassByDdupClassno;
    }

    public void setDdupClassByDdupClassno(DdupClassEntity ddupClassByDdupClassno) {
        this.ddupClassByDdupClassno = ddupClassByDdupClassno;
    }
}
