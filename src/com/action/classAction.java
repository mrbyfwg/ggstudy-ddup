package com.action;

import com.bean.DdupClassEntity;
import com.service.classService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class classAction extends baseActionConfig3 {
    private DdupClassEntity DdupClassEntity;
    private classService classService;
    private String id;
    private String name;
    private int major;

    public com.bean.DdupClassEntity getDdupClassEntity() {
        return DdupClassEntity;
    }

    public void setDdupClassEntity(com.bean.DdupClassEntity ddupClassEntity) {
        DdupClassEntity = ddupClassEntity;
    }

    public com.service.classService getClassService() {
        return classService;
    }

    public void setClassService(com.service.classService classService) {
        this.classService = classService;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public String findAllUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = classService.findAll();
            if (list.size() != 0) {
                map.put("classlist", list);
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
            List list=classService.findById(id);
            if(list.size()!=0){
                DdupClassEntity=(DdupClassEntity) list.get(0);
                map.put("Class",DdupClassEntity);
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
            DdupClassEntity=new DdupClassEntity();
            DdupClassEntity.setDdupCno(id);
            DdupClassEntity.setDdupName(name);
            DdupClassEntity.setDdupMajor(major);
            if(classService.add(DdupClassEntity)){
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
            DdupClassEntity=new DdupClassEntity();
            DdupClassEntity.setDdupCno(id);
            DdupClassEntity.setDdupName(name);
            DdupClassEntity.setDdupMajor(major);
            if(classService.updateInfo(DdupClassEntity)){
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
            if(classService.deleteById(id)){
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
