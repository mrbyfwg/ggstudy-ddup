package com.action;

import com.bean.DdupTeachbuildingEntity;
import com.service.teachBuildingService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class teachBuildingAction extends baseAction{
    private DdupTeachbuildingEntity student;
    private teachBuildingService teachBuildingService;
    private String result;
    private String id;
    private String teachBuildingName;

    public DdupTeachbuildingEntity getTeachBuildingEntity() {
        return student;
    }

    public void setTeachBuildingEntity(DdupTeachbuildingEntity student) {
        this.student = student;
    }

    public com.service.teachBuildingService getTeachBuildingService() {
        return teachBuildingService;
    }

    public void setTeachBuildingService(com.service.teachBuildingService teachBuildingService) {
        this.teachBuildingService = teachBuildingService;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeachBuildingName() {
        return teachBuildingName;
    }

    public void setTeachBuildingName(String teachBuildingName) {
        this.teachBuildingName = teachBuildingName;
    }

    public String findAllUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = teachBuildingService.findAll();
            if (list.size() != 0) {
                map.put("teachBuildinglist", list);
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
            List list=teachBuildingService.findById(id);
            if(list.size()!=0){
                student=(DdupTeachbuildingEntity) list.get(0);
                map.put("teachBuilding",student);
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
            student=new DdupTeachbuildingEntity();
            student.setDdupTeachBuildingName(teachBuildingName);
            student.setDdupTeachBuildingId(id);
            if(teachBuildingService.add(student)){
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
            student=new DdupTeachbuildingEntity();
            student.setDdupTeachBuildingName(teachBuildingName);
            student.setDdupTeachBuildingId(id);
            if(teachBuildingService.updateInfo(student)){
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
            if(teachBuildingService.deleteById(id)){
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
