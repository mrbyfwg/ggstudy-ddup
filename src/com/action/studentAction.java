package com.action;

import com.bean.DdupStudentEntity;
import com.service.studentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class studentAction extends baseActionConfig2{
    private DdupStudentEntity student;
    private studentService studentService;
    private String result;
    private String id;
    private String name;
    private String sex;
    private int age;
    private String ddclass;
    private String originPlace;

    public DdupStudentEntity getStudent() {
        return student;
    }

    public void setStudent(DdupStudentEntity student) {
        this.student = student;
    }

    public com.service.studentService getStudentService() {
        return studentService;
    }

    public void setStudentService(com.service.studentService studentService) {
        this.studentService = studentService;
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

    public String getDdclass() {
        return ddclass;
    }

    public void setDdclass(String ddclass) {
        this.ddclass = ddclass;
    }

    public String getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }

    public String findAllUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = studentService.findAll();
            if (list.size() != 0) {
                map.put("studentlist", list);
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
            List list=studentService.findById(id);
            if(list.size()!=0){
                student=(DdupStudentEntity) list.get(0);
                map.put("student",student);
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
            student=new DdupStudentEntity();
            student.setDdupAge(age);
            System.out.println(age);
            student.setDdupName(name);
            student.setDdupClass(ddclass);
            student.setDdupSex(sex);
            student.setDdupOriginPlace(originPlace);
            student.setDdupSno(id);
            if(studentService.add(student)){
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
            student=new DdupStudentEntity();
            student.setDdupAge(age);
            System.out.println(age);
            student.setDdupName(name);
            student.setDdupClass(ddclass);
            student.setDdupSex(sex);
            student.setDdupOriginPlace(originPlace);
            student.setDdupSno(id);
            if(studentService.updateInfo(student)){
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
            if(studentService.deleteById(id)){
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
