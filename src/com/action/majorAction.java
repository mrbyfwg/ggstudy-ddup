package com.action;

import com.bean.DdupMajorEntity;
import com.service.majorService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class majorAction extends baseActionConfig5{
    private DdupMajorEntity major;
    private majorService majorService;
    private int id;
    private String name;

    public DdupMajorEntity getMajor() {
        return major;
    }

    public void setMajor(DdupMajorEntity major) {
        this.major = major;
    }

    public com.service.majorService getMajorService() {
        return majorService;
    }

    public void setMajorService(com.service.majorService majorService) {
        this.majorService = majorService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String findAllUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = majorService.findAll();
            if (list.size() != 0) {
                map.put("majorlist", list);
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
            List list=majorService.findById(id);
            if(list.size()!=0){
                major=(DdupMajorEntity) list.get(0);
                map.put("major",major);
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
            major=new DdupMajorEntity();
            major.setDdupId(id);
            major.setDdupName(name);
            if(majorService.add(major)){
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
            major=new DdupMajorEntity();
            major.setDdupId(id);
            major.setDdupName(name);
            if(majorService.updateInfo(major)){
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
            if(majorService.deleteById(id)){
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
