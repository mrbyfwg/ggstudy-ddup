package com.action;
import com.bean.DdupTeacherEntity;
import com.service.teacherService;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class teacherAction extends baseAction{
    private DdupTeacherEntity teacher;
    private teacherService teacherService;
    private String result;
    private String id;
    private String name;
    private String sex;
    private int age;
    private String phone;
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public DdupTeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(DdupTeacherEntity teacher) {
        this.teacher = teacher;
    }

    public com.service.teacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(com.service.teacherService teacherService) {
        this.teacherService = teacherService;
    }

    public String findAllUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = teacherService.findAll();
            if (list.size() != 0) {
                map.put("teacherList", list);
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
            List list=teacherService.findById(id);
            if(list.size()!=0){
                teacher=(DdupTeacherEntity) list.get(0);
               map.put("teacher",teacher);
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
            teacher=new DdupTeacherEntity();
            teacher.setDdupAge(age);
            System.out.println(age);
            teacher.setDdupName(name);
            teacher.setDdupPhone(phone);
            teacher.setDdupSex(sex);
            teacher.setDdupTitle(title);
            teacher.setDdupTno(id);
            if(teacherService.add(teacher)){
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
                teacher=new DdupTeacherEntity();
                teacher.setDdupAge(age);
                System.out.println(age);
                teacher.setDdupName(name);
                teacher.setDdupPhone(phone);
                teacher.setDdupSex(sex);
                teacher.setDdupTitle(title);
                teacher.setDdupTno(id);
                if(teacherService.updateInfo(teacher)){
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

           if(teacherService.deleteById(id)){
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
