package com.action;

import com.bean.DdupTeacherpasswordmanageEntity;
import com.service.teacherPasswordManageService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class teacherPasswordManageAction extends baseAction{
    private DdupTeacherpasswordmanageEntity teacher;
    private teacherPasswordManageService teacherPasswordManageService;
    private String result;
    private String id;
    private String password;

    public DdupTeacherpasswordmanageEntity getTeacherpasswordmanageEntity() {
        return teacher;
    }

    public void setTeacherpasswordmanageEntity(DdupTeacherpasswordmanageEntity teacher) {
        this.teacher = teacher;
    }

    public com.service.teacherPasswordManageService getTeacherPasswordManageService() {
        return teacherPasswordManageService;
    }

    public void setTeacherPasswordManageService(com.service.teacherPasswordManageService teacherPasswordManageService) {
        this.teacherPasswordManageService = teacherPasswordManageService;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String findAllUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = teacherPasswordManageService.findAll();
            if (list.size() != 0) {
                map.put("teacherPasswordManagelist", list);
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
            List list=teacherPasswordManageService.findById(id);
            if(list.size()!=0){
                teacher=(DdupTeacherpasswordmanageEntity) list.get(0);
                map.put("teacherPasswordManage",teacher);
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
            teacher=new DdupTeacherpasswordmanageEntity();
            teacher.setDdupPassword(password);
            teacher.setDdupTno(id);
            if(teacherPasswordManageService.add(teacher)){
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
            teacher=new DdupTeacherpasswordmanageEntity();
            teacher.setDdupPassword(password);
            teacher.setDdupTno(id);
            if(teacherPasswordManageService.updateInfo(teacher)){
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
            if(teacherPasswordManageService.deleteById(id)){
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

    /**教师登录验证*/
    public String login(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try{
            List list=teacherPasswordManageService.findById(id);
            if(list.size()!=0){
                teacher=(DdupTeacherpasswordmanageEntity) list.get(0);
                if(teacher.getDdupPassword().equals(password)){
                    status="1";
                    System.out.println("登录成功");
                }else {
                    status = "0";
                }

            }else {
                status = "0";
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
