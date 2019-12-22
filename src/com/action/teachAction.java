package com.action;
import com.bean.DdupTeachEntity;
import com.service.teachService;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class teachAction extends baseActionConfigA{
    private DdupTeachEntity teach;
    private teachService teachService;
    private String result;
    private String cno;
    private String tno;
    private String classno;
    private String teachRoomID;
    private String teachBuildingID;

    public String getTeachRoomID() {
        return teachRoomID;
    }

    public void setTeachRoomID(String teachRoomID) {
        this.teachRoomID = teachRoomID;
    }

    public String getTeachBuildingID() {
        return teachBuildingID;
    }

    public void setTeachBuildingID(String teachBuildingID) {
        this.teachBuildingID = teachBuildingID;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public DdupTeachEntity getTeach() {
        return teach;
    }

    public void setTeach(DdupTeachEntity teach) {
        this.teach = teach;
    }

    public com.service.teachService getTeachService() {
        return teachService;
    }

    public void setTeachService(com.service.teachService teachService) {
        this.teachService = teachService;
    }

    public String findAllUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = teachService.findAll();
            if (list.size() != 0) {
                map.put("teachlist", list);
                status = "1";
            } else {
                status = "0";
            }
            map.put("status", status);
            return ajax(map);
        } catch (Exception e) {
            status="0";
            map.put("status", status);
            e.printStackTrace();
            return ajax(map);
        }
    }
    public String findById(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;

        try{
            List list=teachService.findById(tno, cno, classno);
            if(list.size()!=0){
                teach=(DdupTeachEntity) list.get(0);
                map.put("teach",teach);
                status="1";
            }
            else{
                status="0";
            }
            map.put("status", status);
            return ajax(map);
        }catch (Exception e) {
            status="0";
            map.put("status", status);
            e.printStackTrace();
            return ajax(map);
        }

    }
    public String add(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try{
            teach=new DdupTeachEntity();
            teach.setDdupTeachBuildingId(teachBuildingID);
            teach.setDdupTeachRoomId(teachRoomID);
            teach.setDdupTno(tno);
            teach.setDdupClassno(classno);
            teach.setDdupCno(cno);
            if(teachService.add(teach)){
                status="1";
            }else{
                status="0";
            }
            map.put("status", status);
            return ajax(map);
        }catch (Exception e) {
            status="0";
            map.put("status", status);
            e.printStackTrace();
            return ajax(map);
        }
    }
    public String update(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try{
            teach=new DdupTeachEntity();
            teach.setDdupTeachRoomId(teachRoomID);
            teach.setDdupTeachBuildingId(teachBuildingID);
            teach.setDdupTno(tno);
            teach.setDdupClassno(classno);
            teach.setDdupCno(cno);
            if(teachService.updateInfo(teach)){
                status="1";
            }else{
                status="0";
            }
            map.put("status", status);
            return ajax(map);
        }catch (Exception e) {
            status="0";
            map.put("status", status);
            e.printStackTrace();
            return ajax(map);
        }
    }
    public String deleteById(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;

        try{

            if(teachService.deleteByHql(tno,cno,classno)){
                status="1";
            }else{
                status="0";
            }
            map.put("status", status);
            return ajax(map);
        }catch (Exception e) {
            status="0";
            map.put("status", status);
            e.printStackTrace();
            return ajax(map);
        }

    }

}
