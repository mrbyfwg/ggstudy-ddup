package com.action;

import com.bean.DdupStudentpasswordmanageEntity;
import com.service.studentPasswordManageService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class studentPasswordManageAction extends baseAction{
    private DdupStudentpasswordmanageEntity student;
    private studentPasswordManageService studentPasswordManageService;
    private String result;
    private String id;
    private String password;

    public DdupStudentpasswordmanageEntity getStudentpasswordmanageEntity() {
        return student;
    }

    public void setStudentpasswordmanageEntity(DdupStudentpasswordmanageEntity student) {
        this.student = student;
    }

    public com.service.studentPasswordManageService getstudentPasswordManageService() {
        return studentPasswordManageService;
    }

    public void setStudentPasswordManageService(com.service.studentPasswordManageService studentPasswordManageService) {
        this.studentPasswordManageService = studentPasswordManageService;
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
            List list = studentPasswordManageService.findAll();
            if (list.size() != 0) {
                map.put("studentPasswordManagelist", list);
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
            List list=studentPasswordManageService.findById(id);
            if(list.size()!=0){
                student=(DdupStudentpasswordmanageEntity) list.get(0);
                map.put("studentPasswordManage",student);
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
            student=new DdupStudentpasswordmanageEntity();
            student.setDdupPassword(password);
            student.setDdupSno(id);
            if(studentPasswordManageService.add(student)){
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
            student=new DdupStudentpasswordmanageEntity();
            student.setDdupPassword(password);
            student.setDdupSno(id);
            if(studentPasswordManageService.updateInfo(student)){
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
            if(studentPasswordManageService.deleteById(id)){
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
    //学生登录验证
    public String login(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try{
            List list=studentPasswordManageService.findById(id);
            if(list.size()!=0){
                student=(DdupStudentpasswordmanageEntity) list.get(0);
                if(student.getDdupPassword().equals(password)){
                    status="1";
                    System.out.println("登录成功");
                }else {
                    status = "0";
                }
                //map.put("studentPasswordManage",student);
                // status="1";
            }else {
                status = "0";
            }
            map.put("status", status);
            return ajax(map);
            //System.out.println("登录失败");
            // return false;
        }catch (Exception e) {
            status="0";
            map.put("status", status);
            e.printStackTrace();
            return ajax(map);
        }

    }


}


/*
    public boolean login(){
        //Map<String, Object> map = new HashMap<String, Object>();
        //String status = null;
        try{
            List list=studentPasswordManageService.findById(id);
            if(list.size()!=0){
                student=(DdupStudentpasswordmanageEntity) list.get(0);
                if(student.getDdupPassword().equals(password)){
                    System.out.println("登录成功");
                }
                //map.put("studentPasswordManage",student);
               // status="1";
            }
            System.out.println("登录失败");
            return false;
        }catch (Exception e) {
            System.out.println("登录出错");
            e.printStackTrace();
            return false;
        }

    }*/


/*
//学生登录验证
    public S passwordVerify(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try{
            if(studentPasswordManageService.deleteById(id)){
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
}*/