package com.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DdupTeachEntityPK implements Serializable {
    private String ddupTno;
    private String ddupCno;
    private String ddupClassno;

    @Column(name = "ddup_Tno")
    @Id
    public String getDdupTno() {
        return ddupTno;
    }

    public void setDdupTno(String ddupTno) {
        this.ddupTno = ddupTno;
    }

    @Column(name = "ddup_Cno")
    @Id
    public String getDdupCno() {
        return ddupCno;
    }

    public void setDdupCno(String ddupCno) {
        this.ddupCno = ddupCno;
    }

    @Column(name = "ddup_Classno")
    @Id
    public String getDdupClassno() {
        return ddupClassno;
    }

    public void setDdupClassno(String ddupClassno) {
        this.ddupClassno = ddupClassno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DdupTeachEntityPK that = (DdupTeachEntityPK) o;

        if (ddupTno != null ? !ddupTno.equals(that.ddupTno) : that.ddupTno != null) return false;
        if (ddupCno != null ? !ddupCno.equals(that.ddupCno) : that.ddupCno != null) return false;
        if (ddupClassno != null ? !ddupClassno.equals(that.ddupClassno) : that.ddupClassno != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ddupTno != null ? ddupTno.hashCode() : 0;
        result = 31 * result + (ddupCno != null ? ddupCno.hashCode() : 0);
        result = 31 * result + (ddupClassno != null ? ddupClassno.hashCode() : 0);
        return result;
    }
}
